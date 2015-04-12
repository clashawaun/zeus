package database;

import java.text.ParseException;
import java.util.ArrayList;

import coreClasses.I_Cubby;
import coreClasses.I_Priority;
import coreClasses.I_Sector;
import coreClasses.I_Shelf;
import coreClasses.Item;
import coreClasses.Order;
import coreClasses.Product;
import coreClasses.User;


public interface I_Database {


	
	public User createUser(String firstName, String secondName, String password, int type, String email, String phone );
	public boolean isValidLogin(String username, String password);

	public Order registerOrder(ArrayList<Integer> productIDs, String shippingAddress);
	public Order getOrder(int ID);
	
	public Item addItem(int productID, String manufactureDate, String expriryDate) throws ParseException, Exception;
	public Product createProduct(String name, String description, double price, float height, float width, float depth, float weight, int basePriority );
	
	public ArrayList<Order> getOpenOrders();
	public ArrayList<Item> getItems(int productID);
	public ArrayList<Product> getProducts();
	
	public Item getItem(int itemID);
	public Product getProduct(int productID);
	
	public String getOrderAddress(int orderID);
	public int itemBelonngsTo(int itemID);
	
	public void assignItemToOrder(int itemID, int productID, int orderID);
	public void assignItemToUser(int itemID, int userID);
	
	public void updateOrderStatus(int orderID, String status);
	public void updateItemStutas(int itemID, String state);
	public void updateProductStutas(int productID, String state);
	
	public void updateItemPriority(int itemID, float Priority );
	public void updateProductPriority(int productID, int Priority );
	public void updateOrderPriority(int orderID, float Priority );
	
	public I_Cubby createCubby(int type);
	public I_Shelf createShelve(int type);
	public I_Sector createSector(int type);
	
	public void assignCubbyToShelve(int cubbyID, int shelveID);
	public void removeCubbyFromShelve(int cubbyID, int shelveID);
	
	public void addItemFromCuby(int itemID, int cubbyID);
	public void removeItemFromCuby(int itemID, int cubbyID);
	
	public void deleteItem(int itemID);
	public void deletePrdoct(int productID);
	public void deleteOrder(int OrderID);
	
	public ArrayList<Integer> getAllItemsForUser(int userID);
	public ArrayList<Integer> getAllItemsForAllUsers();
	
	public I_Priority getPriority(int priorityID);
	
	//TODO: This following functions will probably be deleted. Adding to test server code
	public void updateProduct(Product product);
	public void updateItem(Item item);
	public void updateOrder(Order order);
	public ArrayList<I_Sector> getAllSectors();

}
