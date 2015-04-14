package coreClasses;

import java.util.ArrayList;
//Comment
public class Stocker extends User {

	private ArrayList<Item> stackQueue;
	
	
	protected Stocker(int userID, String firstName, String surname, String email, String phone, String password)
	{
		super(userID, firstName, surname, email, phone, password);
		stackQueue = new ArrayList<Item>();
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
