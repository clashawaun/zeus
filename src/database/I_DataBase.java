package database;

import java.util.ArrayList;
import java.util.Calendar;

import coreClasses.Cubby;
import coreClasses.Sector;
import coreClasses.Shelve;

public interface I_DataBase {


	public String createUser(String firstName, String secondName, String password, int type, String email, String phone );
	public String isValidLoggin(String username, String password);

	public String registerOrder(ArrayList<Integer> productIDs, String shippingAddress);
	public String getOrder(int ID);
	
	public String addItem(int productID, Calendar manufactureDate, Calendar expriryDate);
	public String createProduct(String name, String description, double price, float height, float width, float depth, float weight, float basePriority );
	
	public String getOpenOrders();
	public String getItems(int productID);
	public String getProducts();
	
	public String getItem(int itemID);
	public String getProduct(int productID);
	
	public String getOrderAddress(int orderID);
	public String itemBelonngsTo(int itemID);
	
	public void assignItemToOrder(int itemID, int orderID);
	public void assignItemToUser(int itemID, int userID);
	
	public void updateOrderStatus(String status);
	public void updateItemStutas(String itemID, String status);
	public void updateProductStutas(String productID, String status);
	
	public void updateItemPriority(int itemID, float Priority );
	public void updateProductPriority(int productID, float Priority );
	public void updateOrderPriority(int orderID, float Priority );
	
	public Cubby createCubby();
	public Shelve createShelve();
	public Sector createSector();
	
	public void assignCubbyToShelve(int cubbyID, int shelveID);
	public void removeCubbyFromShelve(int cubbyID, int shelveID);
	
	public void addItemFromCuby(int itemID, int cubbyID);
	public void removeItemFromCuby(int itemID, int cubbyID);
	
	public void deleteItem(int itemID);
	public void deletePrdoct(int productID);
	public void deleteOrder(int OrderID);
	
	public String get_All_Items_For_User(int userID);
	public String get_All_Items_For_All_Users();

}
