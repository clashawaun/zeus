package database;

import java.text.ParseException;
import java.util.ArrayList;

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
import coreClasses.PriorityFactory;
import coreClasses.I_Priority;
import coreClasses.UserFactory;


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
	private UserFactory userFactory;
	
	public Database() throws ParseException, Exception
	{
	
		users = new ArrayList<User>();
		
		userFactory = new UserFactory();
		
		users.add(userFactory.makeUser(1, 1, "Cookie", "Monster",  "Cookie.Monster@gmail.com", "087XXXXXXX0", "cookies"));
		users.add(userFactory.makeUser(2, 2,"Big", "Bird","Big.Bird@gmail.com", "087XXXXXXX2", "yellow"));
		users.add(userFactory.makeUser(3, 3, "Kermit", "the Frog", "Kermit.the.Frog@gmail.com", "087XXXXXXX1", "swamp"));
		users.add(userFactory.makeUser(4, 4, "Power", "Rangers", "Power.Rangers@gmail.com", "087XXXXXXX4", "morphin"));
		
		users.add(userFactory.makeUser(1, 5, "Mr", "Picker",  "picker", "087XXXXXXX0", "1234"));
		users.add(userFactory.makeUser(2, 6,"Mr", "Packer","packer", "087XXXXXXX2", "1234"));
		users.add(userFactory.makeUser(3, 7, "Mr", "Manager", "manager", "087XXXXXXX1", "1234"));
		users.add(userFactory.makeUser(4, 8, "Mr", "Stocker", "stocker", "087XXXXXXX4", "1234"));
		userIndexer = 9;
		
		products = new ArrayList<Product>();
		products.add(new Product(1,"X-Box One","This is description one.", 10.00f, 100.0f, 40.0f, 30.0f, 100.0f, 0));
		products.add(new Product(2,"The Book of life","This is description two.", 10.00f, 100.0f, 40.0f, 30.0f, 100.0f, 0));
		products.add(new Product(3,"Pizza","This is description three.", 10.00f, 100.0f, 40.0f, 30.0f, 100.0f, 0));
		productIndexer = 4;
		
		
		items = new ArrayList<Item>();
		
		items.add(new Item(1, 50000, "2014-12-01", null));
		items.add(new Item(3, 50001, null, "2015-04-12"));
		items.add(new Item(2, 50002, "2013-12-06", null));
		items.add(new Item(2, 50003, "2014-12-05", null));
		items.add(new Item(1, 50004, "2015-01-12", null));
		items.add(new Item(3, 50005, null, "2015-04-03"));
		items.add(new Item(1, 50006, "2014-08-07", null));
		items.add(new Item(2, 50007, "2012-12-05", null));
		items.add(new Item(3, 50008, null, "2014-12-05"));
		
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
			tempShelve.add(shelve.getID());
		}
		
		sectors.get(0).setShelves(tempShelve);
		
	}
	@Override
	public User createUser(String firstName, String secondName, String password, String email, String phone, int type ) 
	{
		userIndexer++;
			User temp = userFactory.makeUser(type, userIndexer, firstName, secondName, password, email, phone);
			users.add(temp);
			return temp;
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
			if(order.getID() == ID)  return order;
		}
		
		return null;
	}

	@Override
	public Item createItem(int productID, String manufactureDate, String expriryDate) throws Exception
	{
		Item item= new Item(productID, itemIndexer, manufactureDate, expriryDate);
		items.add(item);
		itemIndexer++;
		
		return item;
	}

	@Override
	public Product createProduct(String name, String description, double price, 
			float height, float width, float depth,float weight, int priorityID) 
	{
		
		Product product = new Product(productIndexer, name, description, price, height, width, depth, weight, priorityID);
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
			if(item.getProductID() == productID)
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
	public void updateProductPriority(int productID, int priority) 
	{

		
		for(Product product: products)
		{
			if(product.getID() == productID)
			{
				product.setPriorityID(priority);
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
	public void addItemToCuby(int itemID, int cubbyID) 
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
				return;
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
				return;
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
	
//+-----------Anything added below this line was added by shane, so I take responsibility if it breaks things and for the shite code in general. Most will prob be deleted--------------------+
	
	@Override
	public I_Priority getPriority(int priorityID)
	{
		return new PriorityFactory().getPriority(priorityID);
	}
	
	
	
	
	//TODO: I dont know if this is ok todo, simply adding this in for the moment to speed up dev of ProcessinngOrder and will come back to change. Marked TODO so wont forget
	public void updateProduct(Product product)
	{
		//This code is shite, do not use in the final version
		for(int i = 0; i < products.size(); i++)
		{
			if(products.equals(product))
			{
				products.set(i, product);
				return;
			}
		}
	}
	
	@Override
	public void updateItem(Item item)
	{
		//This code is shite, do not use in the final version
		for(int i = 0; i < products.size(); i++)
		{
			if(items.get(i).getID() == item.getID())
			{
				items.set(i, item);
				return;
			}
		}
	}

	@Override
	public ArrayList<I_Sector> getAllSectors()
	{
		return sectors;
	}
	
	public void updateOrder(Order order)
	{
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getID() == order.getID())
			{
				orders.set(i, order);
				return;
			}
		}
	}
	
	@Override
	public I_Sector createSector()
	{
		return sectorFactory.makeSector(1, sectorIndexer);
	}
	
	public void updateSector(I_Sector sector)
	{
		for(int index = 0; index < sectors.size(); index++)
		{
			if(sectors.get(index).equals(sector))
				sectors.set(index, sector);
		}
	}
	
	@Override
	public I_Sector getSector(int ID)
	{
		for(I_Sector sec : sectors)
		{
			if(sec.getID() == ID ) return sec;
		}
		
		return null;
	}

	@Override
	public I_Cubby itemBelongsToCubby(int itemID )
	{
		for(I_Cubby cub : cubbies)
		{
			if(cub.hasItem(itemID)) return cub;
		}
		return null;
	}
	
	@Override
	public I_Shelf cubbyBelongsToShelf(int cubbyID)
	{
		for(I_Shelf shelf : shelves)
		{
			if (shelf.hasCubby(cubbyID)) return shelf;
		}
		return null;
	}
	
	@Override
	public I_Sector shelfBelongsToSector(int shelfID)
	{
		for(I_Sector sector : sectors)
		{
			if (sector.hasShelf(shelfID)) return sector;
		}
		return null;
	}
	
	@Override
	public User getUser(String email, String password) {
		
		for(User user : users)
		{
			if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) return user;
		}
		
		return null;
	}
	@Override
	public User getUser(int userID) {
		
		for(User user : users)
		{
			if(user.getID() == userID) return user;
		}
		return null;
	}
	
	@Override
	public void updateUser(User user)
	{
		for(int index = 0; index < users.size(); index++)
		{
			if(users.get(index).equals(user)) 
			{
				users.set(index, user);
				return;
			}
		}
	}

}
