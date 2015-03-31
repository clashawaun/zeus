package database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.google.gson.Gson;

import coreClasses.Cubby;
import coreClasses.Item;
import coreClasses.Order;
import coreClasses.Product;
import coreClasses.Sector;
import coreClasses.Shelve;
import coreClasses.User;

public class DataBase implements I_DataBase {

	private ArrayList<User> users;
	private int userIndexer;
	
	private ArrayList<Item> items;
	private int itemIndexer;
	
	private ArrayList<Product> products;
	private int productIndexer;
	
	private ArrayList<Order> orders;
	private int orderIndexer;
	
	private ArrayList<Cubby> cubbies;
	private ArrayList<Shelve> shelves; 
	private ArrayList<Sector> sectors;
	
	Gson gson;
	
	public DataBase()
	{
	
		users = new ArrayList<User>();
		users.add(new User("Cookie", "Monster", 0, "Cookie.Monster@gmail.com", "087XXXXXXX0", "cookies"));
		users.add(new User("Kermit", "the Frog", 1, "Kermit.the.Frog@gmail.com", "087XXXXXXX1", "swamp"));
		users.add(new User("Big", "Bird", 2, "Big.Bird@gmail.com", "087XXXXXXX2", "yellow"));
		
		userIndexer = 3;
		
		products = new ArrayList<Product>();
		products.add(new Product(0,"X-Box One","This is description one.", 10.00f, 100.0f, 40.0f, 30.0f, 100.0f, 0));
		products.add(new Product(1,"The Book of life","This is description two.", 10.00f, 100.0f, 40.0f, 30.0f, 100.0f, 0));
		products.add(new Product(2,"Pizza","This is description three.", 10.00f, 100.0f, 40.0f, 30.0f, 100.0f, 0));
		productIndexer = 3;
		
		
		items = new ArrayList<Item>();
		items.add(new Item(0, 0, new GregorianCalendar(2014,12,1), null));
		items.add(new Item(2, 1, null, new GregorianCalendar(2015,4,12)));
		items.add(new Item(1, 2, new GregorianCalendar(2013,12,6), null));
		items.add(new Item(1, 3, new GregorianCalendar(2014,12,5), null));
		items.add(new Item(0, 4, new GregorianCalendar(2015,1,12), null));
		items.add(new Item(2, 5, null, new GregorianCalendar(2015,4,3)));
		items.add(new Item(1, 6, new GregorianCalendar(2014,12,7), null));
		items.add(new Item(0, 7, new GregorianCalendar(2015,4,12), null));
		items.add(new Item(2, 8, null, new GregorianCalendar(2015,4,25)));
		itemIndexer = 9;
		
		orders = new ArrayList<Order>();
		ArrayList<Integer> tempOrderList = new ArrayList<Integer>();
		tempOrderList.add(0);
		tempOrderList.add(2);
		tempOrderList.add(1);
		orders.add(new Order(0,tempOrderList, "Address one \n Address two \n Town"));
		tempOrderList.clear();
		
		tempOrderList.add(0);
		tempOrderList.add(0);
		tempOrderList.add(2);
		orders.add(new Order(1,tempOrderList, "Address one \n Address two \n Town"));
		tempOrderList.clear();
		
		tempOrderList.add(1);
		tempOrderList.add(1);
		tempOrderList.add(2);
		orders.add(new Order(2,tempOrderList, "Address one \n Address two \n Town"));
		tempOrderList.clear();
		
		orderIndexer = 3;
		
		gson = new Gson();
		
	}
	@Override
	public String createUser(String firstName, String secondName, String password, int type, String email, String phone) 
	{
		User user = new User(firstName, secondName, userIndexer, email, phone, password);
		userIndexer++;
		
		return gson.toJson(user);
	}

	@Override
	public String isValidLoggin(String username, String password) {

		boolean isValid = false;
		for(User user: users)
		{
			if(user.getFirstname() == username && user.getPassword() == password)
			{
				isValid = true;
			}
		}
		
		return gson.toJson(isValid);
	}

	@Override
	public String registerOrder(ArrayList<Integer> productIDs, String shippingAddress) {

		Order order = new Order(orderIndexer, productIDs, shippingAddress);
		orders.add(order);
		orderIndexer++;
		
		return gson.toJson(order);
	}

	@Override
	public String getOrder(int ID) {

		for(Order order : orders)
		{
			if(order.getID() == ID)
				return gson.toJson(order);
		}
		
		return gson.toJson(null);
	}

	@Override
	public String addItem(int productID, Calendar manufactureDate, Calendar expriryDate)
	{
		Item item = new Item(productID, itemIndexer, manufactureDate, expriryDate);
		items.add(item);
		itemIndexer++;
		
		return gson.toJson(item);
	}

	@Override
	public String createProduct(String name, String description, double price, 
			float height, float width, float depth,float weight, float basePriority) {
		
		Product product = new Product(productIndexer, name, description, price, height, width, depth, weight, basePriority);
		products.add(product);
		productIndexer++;
		
		return gson.toJson(product);
	}

	@Override
	public String getOpenOrders() {
		
		ArrayList<Order> tempOrders = new ArrayList<Order>();
		
		for(Order order : orders)
		{
			if(order.getStatus() == "OPEN")
			tempOrders.add(order);
		}
		
		return gson.toJson(tempOrders);
	}

	@Override
	public String getItems(int productID) {
		
		ArrayList<Item> tempItems = new ArrayList<Item>();
		
		for(Item item : items)
		{
			if(item.getPRODUCT_ID() == productID)
			{
				tempItems.add(item);
			}
		}
		
		return gson.toJson(tempItems);
	}

	@Override
	public String getProducts() {
		
		return gson.toJson(products);
	}
	
	@Override
	public String getProduct(int productID) {
		
		for(Product product : products)
		{
			if(product.getID() == productID)
			{
				return gson.toJson(product);
			}
		}
		
		return gson.toJson(null);
	}
	
	@Override
	public String getItem(int itemID) {
		
		for(Item item : items)
		{
			if(item.getID() == itemID)
			{
				return gson.toJson(item);
			}
		}
		return gson.toJson(null);
	}
	
	@Override
	public String getOrderAddress(int orderID) {

		for(Order order : orders)
		{
			if(order.getID() == orderID)
			{
				return gson.toJson(order.getShippingAddress());
			}
		}
		return gson.toJson(null);
	}
	
	@Override
	public String itemBelonngsTo(int itemID) {
		// TODO Auto-generated method stub

		return gson.toJson(null);
	}
	
	@Override
	public void assignItemToOrder(int itemID, int orderID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void assignItemToUser(int itemID, int userID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateOrderStatus(String status) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateItemStutas(String itemID, String status) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateProductStutas(String productID, String status) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateItemPriority(int itemID, float Priority) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateProductPriority(int productID, float Priority) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateOrderPriority(int orderID, float Priority) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Cubby createCubby() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Shelve createShelve() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Sector createSector() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void assignCubbyToShelve(int cubbyID, int shelveID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeCubbyFromShelve(int cubbyID, int shelveID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addItemFromCuby(int itemID, int cubbyID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeItemFromCuby(int itemID, int cubbyID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteItem(int itemID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deletePrdoct(int productID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteOrder(int Order) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String get_All_Items_For_User(int userID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String get_All_Items_For_All_Users() {
		// TODO Auto-generated method stub
		return null;
	}



}
