package database;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import coreClasses.CubbyFactory;
import coreClasses.I_Cubby;
import coreClasses.I_Sector;
import coreClasses.I_Shelf;
import coreClasses.Item;
import coreClasses.Order;
import coreClasses.Product;
import coreClasses.SectorFactory;
import coreClasses.ShelfFactory;
import coreClasses.User;


public class Database implements I_Database {

	private ArrayList<User> users;
	private int userIndexer;
	
	private ArrayList<Item> items;
	private int itemIndexer;
	
	private ArrayList<Product> products;
	private int productIndexer;
	
	private ArrayList<Order> orders;
	private int orderIndexer;
	
	private ArrayList<I_Cubby> cubbies;
	private int cubbyIndexer;
	
	private ArrayList<I_Shelf> shelves; 
	private int shelveIndexer;
	
	private ArrayList<I_Sector> sectors;
	private int sectorIndexer;
	
	private CubbyFactory cubbyFactory;
	private ShelfFactory shelveFactory;
	private SectorFactory sectorFactory;

	
	public Database() throws ParseException, Exception
	{
	
		users = new ArrayList<User>();
		users.add(new User("Cookie", "Monster", 1, "Cookie.Monster@gmail.com", "087XXXXXXX0", "cookies"));
		users.add(new User("Kermit", "the Frog", 2, "Kermit.the.Frog@gmail.com", "087XXXXXXX1", "swamp"));
		users.add(new User("Big", "Bird",3, "Big.Bird@gmail.com", "087XXXXXXX2", "yellow"));
		
		userIndexer = 4;
		
		products = new ArrayList<Product>();
		products.add(new Product(1,"X-Box One","This is description one.", 10.00f, 100.0f, 40.0f, 30.0f, 100.0f, 0));
		products.add(new Product(2,"The Book of life","This is description two.", 10.00f, 100.0f, 40.0f, 30.0f, 100.0f, 0));
		products.add(new Product(3,"Pizza","This is description three.", 10.00f, 100.0f, 40.0f, 30.0f, 100.0f, 0));
		productIndexer = 4;
		
		
		items = new ArrayList<Item>();
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");

		Date date = (Date) format.parse("2014-12-01");
		items.add(new Item(1, 50000, date, null));
		
		date = (Date) format.parse("2015-04-12");
		items.add(new Item(3, 50001, null, date));
		
		date = (Date) format.parse("2013-12-06");
		items.add(new Item(2, 50002, date, null));
		
		date = (Date) format.parse("2014-12-05");
		items.add(new Item(2, 50003, date, null));
		
		date = (Date) format.parse("2015-01-12");
		items.add(new Item(1, 50004, date, null));
		
		date = (Date) format.parse("2015-04-03");
		items.add(new Item(3, 50005, null, date));
		
		date = (Date) format.parse("2014-08-07");
		items.add(new Item(1, 50006, date, null));
		
		date = (Date) format.parse("2012-12-05");
		items.add(new Item(2, 50007, date, null));
		
		date = (Date) format.parse("2014-12-05");
		items.add(new Item(3, 50008, null, date));
		
		itemIndexer = 50009;
		
		orders = new ArrayList<Order>();
		ArrayList<Integer> tempOrderList = new ArrayList<Integer>();
		tempOrderList.add(0);
		tempOrderList.add(2);
		tempOrderList.add(1);
		orders.add(new Order(0,tempOrderList, "Order Address one \n Address two \n Town"));
		tempOrderList.clear();
		
		tempOrderList.add(0);
		tempOrderList.add(0);
		tempOrderList.add(2);
		orders.add(new Order(1,tempOrderList, "Order Address two \n Address two \n Town"));
		tempOrderList.clear();
		
		tempOrderList.add(1);
		tempOrderList.add(1);
		tempOrderList.add(2);
		orders.add(new Order(2,tempOrderList, "Order Address Three \n Address two \n Town"));
		tempOrderList.clear();
		
		orderIndexer = 3;
		
		
		this.cubbyFactory = new CubbyFactory();
		this.cubbyIndexer = 1;
		
		this.shelveFactory = new ShelfFactory();
		this.shelveIndexer = 1;
		shelves = new ArrayList<I_Shelf>();
		for(int i = 0; i < 10; i++)
		{
			if(shelves == null)
				System.out.println("Shelves is null");
			if(shelveFactory == null)
				System.out.println("factory is null");
			shelves.add(shelveFactory.makeShelve(1, shelveIndexer));
			this.shelveIndexer++;
		}
		
		
		ArrayList<Integer> tempCubbies;
		I_Cubby tempCub;
		cubbies = new ArrayList<I_Cubby>();
		for(I_Shelf shelve : shelves)
		{
			
			tempCubbies = new ArrayList<Integer>();
			
			for(int i = 0; i < 8; i++)
			{
				tempCub = cubbyFactory.makeCubby(1, cubbyIndexer);
				cubbies.add(tempCub);
				tempCubbies.add(tempCub.getID());
				cubbyIndexer++;
			}
			
			for(int i = 0; i < 4; i++)
			{
				tempCub = cubbyFactory.makeCubby(2, cubbyIndexer);
				cubbies.add(tempCub);
				tempCubbies.add(tempCub.getID());
				cubbyIndexer++;
			}
		
			for(int i = 0; i < 2; i++)
			{
				tempCub = cubbyFactory.makeCubby(3, cubbyIndexer);
				cubbies.add(tempCub);
				tempCubbies.add(tempCub.getID());
				cubbyIndexer++;
			}
			
			shelve.setCubbies(tempCubbies);
		}
		
		sectors = new ArrayList<I_Sector>();
		sectorIndexer = 1;
		sectorFactory = new SectorFactory();
		
		sectors.add(sectorFactory.makeSector(1, sectorIndexer));
		sectorIndexer++;
		
		ArrayList<Integer> tempShelve = new ArrayList<Integer>();
		
		for(I_Shelf shelve : shelves)
		{
			tempShelve.add(shelve.getId());
		}
		
		sectors.get(0).setShelves(tempShelve);
		
	}
	@Override
	public User createUser(String firstName, String secondName, String password, int type, String email, String phone) 
	{
		User user = new User(firstName, secondName, userIndexer, email, phone, password);
		userIndexer++;
		
		return user;
	}

	@Override
	public boolean isValidLogin(String email, String password) 
	{
		for(User user: users)
		{
			//Shane - I changed this since it was using == which is incorrect for strings
			if(user.getEmail().equals(email) && user.getPassword().equals(password))
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Order registerOrder(ArrayList<Integer> productIDs, String shippingAddress) 
	{

		Order order = new Order(orderIndexer, productIDs, shippingAddress);
		orders.add(order);
		orderIndexer++;
		
		return order;
	}

	@Override
	public Order getOrder(int ID) 
	{
		for(Order order : orders)
		{
			if(order.getID() == ID)
			{
				return order;
			}
		}
		
		return null;
	}

	@Override
	public Item addItem(int productID, String manufactureDate, String expriryDate) throws ParseException,Exception
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		
		Date manDate = (Date) format.parse(manufactureDate);
		Date expDate = (Date) format.parse(manufactureDate);
		
		Item item= new Item(productID, itemIndexer, manDate, expDate);
		items.add(item);
		itemIndexer++;
		
		return item;
	}

	@Override
	public Product createProduct(String name, String description, double price, 
			float height, float width, float depth,float weight, float basePriority) 
	{
		
		Product product = new Product(productIndexer, name, description, price, height, width, depth, weight, basePriority);
		products.add(product);
		productIndexer++;
		
		return product;
	}

	@Override
	public ArrayList<Order> getOpenOrders()
	{
		
		ArrayList<Order> tempOrders = new ArrayList<Order>();
		
		for(Order order : orders)
		{
			if(order.getStatus().equalsIgnoreCase( "OPEN"));
			tempOrders.add(order);
		}
		
		return tempOrders;
	}

	@Override
	public ArrayList<Item> getItems(int productID) 
	{
		
		ArrayList<Item> tempItems = new ArrayList<Item>();
		
		for(Item item : items)
		{
			if(item.getPRODUCT_ID() == productID)
			{
				tempItems.add(item);
			}
		}
		
		return tempItems;
	}

	@Override
	public ArrayList<Product> getProducts() 
	{
		return products;
	}
	
	@Override
	public Product getProduct(int productID) 
	{
		
		for(Product product : products)
		{
			if(product.getID() == productID)
			{
				return product;
			}
		}
		
		return null;
	}
	
	@Override
	public Item getItem(int itemID) 
	{
		
		for(Item item : items)
		{
			if(item.getID() == itemID)
			{
				return item;
			}
		}
		return null;
	}
	
	@Override
	public String getOrderAddress(int orderID) 
	{

		for(Order order : orders)
		{
			if(order.getID() == orderID)
			{
				return order.getShippingAddress();
			}
		}
		return null;
	}
	
	@Override
	public int itemBelonngsTo(int itemID)
	{
		for(Order order : orders)
		{
			if(order.hasItem(itemID))
			{
				return order.getID();
			}
		}
		

		return 0;
	}
	
	@Override
	public void assignItemToOrder( int itemID, int productID,int orderID) 
	{

		for(Order order : orders)
		{
			if(order.getID() == orderID)
			{
				order.addItemId(itemID, productID);
			}
		}
		
	}
	
	@Override
	public void assignItemToUser(int itemID, int userID) 
	{
		
		for(User user : users)
		{
			if(user.getID() == userID)
			{
				for(Item item : items)
				{
					if(item.getID() == itemID)
					{
						item.setAssignedUserID(userID);
						user.addItemToUser(itemID);
					}
				}
				
			}
		}
	
	}
	
	
	@Override
	public void updateOrderStatus(int orderID, String status)
	{
		
		for(Order order : orders)
		{
			if(order.getID() == orderID)
			{
				order.setStatus(status);
			}
		}

	}
	
	@Override
	public void updateItemStutas(int itemID, String state)
	{
		
		for(Item item : items)
		{
			if(item.getID() == itemID)
			{
				item.setCurrentState(state);
			}
		}
	}
	
	@Override
	public void updateProductStutas(int productID, String state)
	{
		for(Product product: products)
		{
			if(product.getID() == productID)
			{
				product.setState(state);
			}
		}
		
	}
	
	@Override
	public void updateItemPriority(int itemID, float priority)
	{
		
		for(Item item : items)
		{
			if(item.getID() == itemID)
			{
				item.setPriority(priority);;
			}
		}
		
	}
	
	@Override
	public void updateProductPriority(int productID, float priority) 
	{

		
		for(Product product: products)
		{
			if(product.getID() == productID)
			{
				product.setBasePriority(priority);
			}
		}
		
	}
	
	@Override
	public void updateOrderPriority(int orderID, float priority) 
	{
		for(Order order : orders)
		{
			if(order.getID() == orderID)
			{
				order.setPriority(priority);;
			}
		}
	}
	
	@Override
	public I_Cubby createCubby(int type) 
	{
		
		cubbies.add(cubbyFactory.makeCubby(type, cubbyIndexer ));
		
		return cubbies.get(cubbies.size()-1);
		
	}
	
	@Override
	public I_Shelf createShelve( int type) 
	{
		I_Shelf temp = shelveFactory.makeShelve(type, shelveIndexer);
		shelveIndexer++;
		return temp;
	}
	
	@Override
	public I_Sector createSector(int type)
	{
		I_Sector tempsector = sectorFactory.makeSector(type, sectorIndexer);
		sectorIndexer++;
		return tempsector;
	}
	
	@Override
	public void assignCubbyToShelve(int cubbyID, int shelveID) 
	{
		// TODO Auto-generated method stub
	}
	
	@Override
	public void removeCubbyFromShelve(int cubbyID, int shelveID) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addItemFromCuby(int itemID, int cubbyID) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItemFromCuby(int itemID, int cubbyID) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteItem(int itemID)
	{

		for(int index = 0; index < items.size(); index++)
		{
			if(items.get(index).getID() == itemID)
			{
				items.remove(index);
			}
		}

	}
	
	@Override
	public void deletePrdoct(int productID)
	{

		for(int index = 0; index <products.size(); index++)
		{
			if(products.get(index).getID() == productID)
			{
				products.remove(index);
				
			}
		}
		
	}
	
	@Override
	public void deleteOrder(int orderID) 
	{
		for(int index = 0; index <orders.size(); index++)
		{
			if(orders.get(index).getID() == orderID)
			{
				orders.remove(index);
			}
		}
		
	}
	
	@Override
	public ArrayList<Integer> getAllItemsForUser(int userID) 
	{
		
		for(User user : users)
		{
			if(user.getID() == userID)
			{
				return user.getItems();
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<Integer> getAllItemsForAllUsers() 
	{
		
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		
		for(User user : users)
		{
			tempList.addAll(user.getItems());
		}
		return tempList;
	}



}
