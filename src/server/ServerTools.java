package server;
import java.util.ArrayList;
import java.util.Collections;

import coreClasses.CubbyFactory;
import coreClasses.CubbySmall;
import coreClasses.I_Cubby;
import coreClasses.I_Sector;
import coreClasses.I_Shelf;
import coreClasses.Item;
import coreClasses.Order;
import coreClasses.Picker;
import coreClasses.Product;
import coreClasses.Sector;
import coreClasses.Stocker;
import database.Database;
import database.I_Database;

public class ServerTools 
{
	private ArrayList<SectorTools> sectorTools;
	private PackagingTools packagingTools;
	private ReportTools reportTools;
	private I_Database database;
	//There must be a better way to distribute the DB. Maybe static ? or something all tools inherit from
	public ServerTools()
	{
		sectorTools = new ArrayList<SectorTools>();
		packagingTools = new PackagingTools();
		reportTools = new ReportTools();
	}
	
	public ServerTools(I_Database database)
	{
		this.database = database;
		sectorTools = new ArrayList<SectorTools>();
		packagingTools = new PackagingTools();
		reportTools = new ReportTools();
	}
	
	public ArrayList<SectorTools> getSectorTools() 
	{
		return sectorTools;
	}
	public PackagingTools getPackagingTools() 
	{
		return packagingTools;
	}
	public ReportTools getReportTools() 
	{
		return reportTools;
	}
	
	/** This function will find items in the system that will be used to fulfil the provided order*/
	public boolean processNewOrder(Order newOrder)
	{
		//Get the product objects the ID's provided represent
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Item> chosenItems = new ArrayList<Item>();
		for(int productID : newOrder.getProductIds())
		{
			Product temp = database.getProduct(productID);
			if(temp == null)
				return false;
			products.add(temp);
		}
		for(Product product : products)
		{
			Item bestItem = null;
			int bestItemPriority = -1;
			ArrayList<Item> items = database.getItems(product.getID());
			if(items==null)
				return false;
			for(Item item : items)
			{
				if(item.getCurrentState().equals("AVAILABLE"))
				{
					//Strategy Design Pattern 
					int itemPriority = database.getPriority(product.getPriorityID()).calculatePriority(item, product);
					if(itemPriority > bestItemPriority)
					{
						bestItem = item;
						bestItemPriority = itemPriority;
					}
				}
			}
			if(bestItem == null)
				return false;
			//This will probably change
			chosenItems.add(bestItem);	
		}
		//Sanity check
		ArrayList<Integer> itemIDs = new ArrayList<Integer>();
		for(Item item : chosenItems)
		{
			queueItemForPickup(item);
			item.setCurrentState("AWAITING_PICKER");
			database.updateItem(item);
			itemIDs.add(item.getID());
		}
		newOrder.setProductIds(itemIDs);
		database.updateOrder(newOrder);
		return true;
	}
	
	public void queueItemForPickup(Item item)
	{
		I_Sector itemSector = database.shelfBelongsToSector(database.cubbyBelongsToShelf(database.itemBelongsToCubby(item.getID()).getID()).getID());
		SectorTools tool = getSectorTool(itemSector.getID());
		if(tool == null)
			return;
		tool.addItemToQueue(item);
	}
	
	public ArrayList<Item> processPickerItemAssignments(Picker picker, I_Sector sector)
	{
		SectorTools tool = getSectorTool(sector.getID());
		if(tool == null)
			return null;
		return tool.assignItemsForPicker(picker);
	}
	
	/*public ArrayList<Item> processStockerItemAssignments(Stocker stocker, I_Sector sector)
	{
		SectorTools tool = getSectorTool(sector.getID());
		
	}*/
	
	public boolean processNewItem(Stocker stocker, I_Sector sector, Item item, int productID)
	{
		if(!item.getCurrentState().equals("AWAITING_STOCKER"))
			return false;
		System.out.println("State is set correctly");
		//Revise how this works in the database.... this level of code should not be needed in the server as far as Im concerned (To much boilerplate)
		Product relatedProduct = database.getProduct(productID);
		if(relatedProduct == null)
			return false;
		System.out.println("Related product found");
		ArrayList<I_Shelf> shelves = new ArrayList<I_Shelf>();
		for(int shelfID: sector.getShelves())
			shelves.add(database.getShelf(shelfID));
		ArrayList<I_Cubby> cubbies = new ArrayList<I_Cubby>();
		for(I_Shelf shelf: shelves)
		{
			for(int cubbyID: shelf.getCubbies())
			{
				cubbies.add(database.getCubby(cubbyID));
				System.out.println("cubbyFound");
			}
		}
		
		//Now that we have a list of cubbies, lets go through the list and find one that meets our requirements.
		for(I_Cubby cubby: cubbies)
		{
			//Loop through the valid cubby and try and get one that meets our requirements
			//Lets check that our cubby meets height and depth requirements
			
			ArrayList<Item> cubbyItems = new ArrayList<Item>();
			for(int itemID: cubby.getItems())
			{
				cubbyItems.add(database.getItem(itemID));
			}
			if(isCubbyUsable(relatedProduct, cubby, cubbyItems, item))
			{
				//if the cubby can store the item lets store it.
				//I dont like how manual this process is ..... room for improvement in the core classes...
				cubby.addItem(item.getID());
				database.updateCubby(cubby);
				generateItemSku(item);
				item.setAssignedUserID(stocker.getID());
				stocker.addItem(item);
				item.setCurrentState("PENDING_STOCKING");
				System.out.println("item placement: " + item.getxPlacementPoint());
				database.updateItem(item);
				return true;
			}
			//Now we have the items that exist in the cubby, build the current dimensions.
		}
		//DELETE ME 
		return false;
	}
	
	//Seperate this logic into its own method so we can modify how the algorithm determines if the cubby is a suitable stoarge unit for an item.
	//It will also add a placement point to the new item if it finds it usuable
	private boolean isCubbyUsable(Product product, I_Cubby cubby, ArrayList<Item> currentItems, Item itemToAdd)
	{
		//Check that the cubby satisfies height and depth requirements for this product.
		if(product.getHeigth() > cubby.getHeight() || product.getDepth() > cubby.getDepth())
			return false;
		//If we have got this far we know that the cubby has sufficient depth and height
		ArrayList<Integer> xAxis = new ArrayList<Integer>();
		for(Item item: currentItems)
		{
			if(item == null);
			else
			{
				//Could this go wrong ?
				xAxis.add(item.getxPlacementPoint());
			}
		}
		//Sort the collection of X Points so we have an X-Axis to work with
		Collections.sort(xAxis);
		int startPoint = 0;
		//This algorithm will find a place in the cubby to try and fit the item
		System.out.println("Lets start the terrible algorithm. Current cubby state: Dimensions=(" + cubby.getHeight() + "," + cubby.getWidth() + "," + cubby.getDepth() + ")");
		if(xAxis.size() == 0 && product.getWidth() <= cubby.getWidth())
		{
			//If we have no items in the cubby, just check if it fits and add it
			itemToAdd.setxPlacementPoint(0);
			System.out.println("Default case satisfied");
			cubby.addItem(itemToAdd.getID());
			return true;
		}
		int endPoint = 0;
		for(int i = 0; i < xAxis.size(); i++)
		{
			//Refector needed
			if(i == 0)
			{
				if(startPoint < xAxis.get(i))
				{
					if(startPoint + product.getWidth() < xAxis.get(i))
					{
						System.out.println("Item will fit :D .. using default case and placing it in position zero");
						itemToAdd.setxPlacementPoint(startPoint);
						cubby.addItem(itemToAdd.getID());
						return true;
					}
				}
			}
			else
			{
				//We should be dealing with either float or int, not both
				startPoint = xAxis.get(i) - (xAxis.get(i-1) + (int) product.getWidth());
				System.out.println("startPoint i " + xAxis.get(i));
				System.out.println("startPoint i-1 " + xAxis.get(i-1));
				System.out.println("Space between" + startPoint);
				System.out.println("Checking if there is room .....");
				if(product.getWidth() <= startPoint)
				{
					System.out.println("Cubby ID: " + cubby.getID() + " Item will fit :D .. putting the item into position: " + (xAxis.get(i-1) + (int) product.getWidth()));
					//We have found a suitable place
					itemToAdd.setxPlacementPoint(xAxis.get(i-1) + (int) product.getWidth());
					cubby.addItem(itemToAdd.getID());
					return true;
				}
				endPoint = xAxis.get(i) + (int) product.getWidth();
			}
		}
		if(product.getWidth() < cubby.getWidth() - endPoint)
		{
			//Add the item at the end 
			System.out.println("Add Item to end");
			itemToAdd.setxPlacementPoint(endPoint+1);
			cubby.addItem(itemToAdd.getID());
			return true;
		}
		return false;
	}
	
	
	public boolean markItemCollected(Item item, Picker picker)
	{
		if(item.getAssignedUserID() != picker.getID())
			return false;
		ArrayList<Item> pickerItems = picker.getItemBasket();
		for(int i = 0; i < pickerItems.size(); i++)
		{
			if(pickerItems.get(i).getID() == item.getID())
			{
				//Again duplication of logic with assigned users needs to be revised
				pickerItems.remove(i);
				item.setCurrentState("AWAITING_PACKER");
				item.setAssignedUserID(-1);
				database.updateItem(item);
				database.updateUser(picker);
				return true;
			}
		}
		return false;
	}
	
	private boolean generateItemSku(Item item)
	{
		boolean uniqueSku = false;
		while(!uniqueSku)
		{
			String sku = String.format("%013d", (int) (Math.random() * 999999999));
			System.out.println("SKU GENERATED " + sku);
			if(database.isItemSkuUnique(sku))
			{
				try
				{
					item.setSku(sku);
					uniqueSku = true;
				}
				catch(Exception e)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private SectorTools getSectorTool(int ID)
	{
		for(SectorTools tool : sectorTools)
		{
			if(tool.getSectorId() == ID)
				return tool;
		}
		return null;
	}
	
	public void addSectorTool(SectorTools sectorTool)
	{
		sectorTools.add(sectorTool);
	}
	
	
	
}
