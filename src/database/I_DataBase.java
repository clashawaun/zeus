package database;

import java.util.ArrayList;
import java.util.Date;

import coreClasses.Cubby;
import coreClasses.Item;
import coreClasses.Order;
import coreClasses.Product;
import coreClasses.Sector;
import coreClasses.Shelve;
import coreClasses.User;

public interface I_DataBase {

	public User createUser(String firstName, String secondName, String password, int type, String email, String phone );
	public boolean isValidLoggin(String username, String password);

	public void registerOrder(ArrayList<String> productIds, String shippingAddress);
	public Order getOrder(String ID);
	
	public Item addItem(String productID, String id, Date manufactureDate, Date expriryDate);
	public Product createProduct(String name, String description, double price, float height, float width, float depth, float basePriority );
	
	public ArrayList<Order> getOpenOrders();
	public ArrayList<Item> getItems(String productID);
	public ArrayList<Product> getProducts(String productID);
	
	public String getOrderAddress(String orderID);
	public Order itemBelonngsTo(String itemID);
	
	public void assignItemToOrder(String itemID, String orderID);
	public void assignItemToUser(String itemID, String userID);
	
	public void updateOrderStatus(String status);
	public void updateItemStutas(String itemID, String status);
	public void updateProductStutas(String productID, String status);
	
	public void updateItemPriority(String itemID, int Priority );
	public void updateProductPriority(String productID, int Priority );
	public void updateOrderPriority(String orderID, int Priority );
	
	public Cubby createCubby();
	public Shelve createShelve();
	public Sector createSector();
	
	public void assignCubbyToShelve(String cubbyID, String shelveID);
	public void removeCubbyFromShelve(String cubbyID, String shelveID);
	
	public void addItemFromCuby(String itemID, String cubbyID);
	public void removeItemFromCuby(String itemID, String cubbyID);
	
	public void deleteItem(String itemID);
	public void deletePrdoct(String productID);
	public void deleteOrder(String Order);
	
	public ArrayList<Item> get_All_Items_For_User(String userID);
	public ArrayList<Item> get_All_Items_For_All_Users();

}
