package coreClasses;

import java.util.ArrayList;

public class Stocker extends User {

	ArrayList<Item> stackQueue = new ArrayList<Item>();
	
	public Stocker()
	{
		super();
	}
	
	public Stocker(String firstName, String surname, int userID, String email, String phone, String password)
	{
		super(firstName, surname, userID, email, phone, password);
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
