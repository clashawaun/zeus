package database;

import java.util.ArrayList;
import java.util.Date;

import coreClasses.Item;
import coreClasses.Order;
import coreClasses.Product;
import coreClasses.User;

public class DataBase implements I_DataBase {

	@Override
	public boolean isValidLoggin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User createUser(String firstName, String secondName,
			String password, int type, String email, String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item createItem(String productID, String id, Date manufactureDate,
			Date expriryDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product createProduct(String name, String description, double price,
			float height, float width, float depth, float basePriority) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerOrder(ArrayList<String> productIds,
			String shippingAddress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getOrder(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Item> getItems(String productID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> getProducts(String productID) {
		// TODO Auto-generated method stub
		return null;
	}

}