package database;

import java.util.ArrayList;
import java.util.Date;

import coreClasses.Item;
import coreClasses.Order;
import coreClasses.Product;
import coreClasses.User;

public interface I_DataBase {

	public boolean isValidLoggin(String username, String password);
	
	public User createUser(String firstName, String secondName, String password, int type, String email, String phone );
	
	public Item createItem(String productID, String id, Date manufactureDate, Date expriryDate);
	
	public Product createProduct(String name, String description, double price, float height, float width, float depth, float basePriority );

	public void registerOrder(ArrayList<String> productIds, String shippingAddress);
	
	public Order getOrder(String ID);
	
	public ArrayList<Item> getItems(String productID);
	public ArrayList<Product> getProducts(String productID);
}
