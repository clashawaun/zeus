package coreClasses;

import java.util.ArrayList;
//Comment
public class Stocker extends User {

	ArrayList<Item> stackQueue = new ArrayList<Item>();
	
	
	public Stocker(int userID, String firstName, String surname, String email, String phone, String password)
	{
		super(userID, firstName, surname, email, phone, password);
	}
	
	public boolean addItem(Item item)
	{
		return stackQueue.add(item);
	}
	
	public boolean removeItem(Item item)
	{
		return stackQueue.remove(item);
	}
	
	
	
}
