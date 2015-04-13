package coreClasses;

import java.util.ArrayList;



public class Picker extends User{

	ArrayList<Item> itemBasket;
	
	public Picker(String firstName, String surname, int userID,
			String email, String phone, String password) 
	{
		super(firstName, surname, userID, email, phone, password);
		itemBasket = new ArrayList<Item>();
	}
	
	public boolean addItemToBasket(Item item)
	{
		return itemBasket.add(item);
	}

	public boolean removeItemFromBasket(Item item)
	{
		return itemBasket.remove(item);
	}
<<<<<<< HEAD
	
	public ArrayList<Item> getItemBasket()
	{
		return itemBasket;
	}
=======

>>>>>>> 026a47235d11ec53923b51ffc9735b64eeaa6c5a
}
