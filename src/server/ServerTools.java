package server;
import java.util.ArrayList;

import coreClasses.I_Sector;
import coreClasses.Item;
import coreClasses.Order;
import coreClasses.Product;
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
					//Is this strategy Design Pattern ?
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
		for(SectorTools  tool : sectorTools)
		{
			if(tool.getSectorId() == itemSector.getID())
			{
				itemSector.putItemInQueue(item);
				break;
			}
		}
	}
	
	public void addSectorTool(SectorTools sectorTool)
	{
		sectorTools.add(sectorTool);
	}
	
	
	
}
