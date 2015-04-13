package coreClasses;

import java.util.ArrayList;



public class Picker extends User{

	ArrayList<Item> itemBasket = new ArrayList<Item>();
	
	public Picker()
	{
		super();
		itemBasket = new ArrayList<Item>();
	}
	
	public Picker(String firstName, String surname, int userID,
			String email, String phone, String password) 
	{
		super(firstName, surname, userID, email, phone, password);
		itemBasket = new ArrayList<Item>();
	}
	
	public boolean addItem(Item item)
	{
		return itemBasket.add(item);
		
	}

	public boolean removeItem(Item item)
	{
		return itemBasket.remove(item);
	}
	
	public ArrayList<Item> getPickerItems()
	{
		return itemBasket;
	}
}
