package coreClasses;

import java.util.ArrayList;



public class Picker extends User{

	private ArrayList<Integer> itemBasket;
	
	protected Picker(int userID, String firstName, String surname, String email, String phone, String password) 
	{
		super(userID, firstName, surname,  email, phone, password);
		itemBasket = new ArrayList<Integer>();
	}
	
	public boolean addItemToBasket(Integer item)
	{
		return itemBasket.add(item);
	}

	public boolean removeItemFromBasket(Integer item)
	{
		return itemBasket.remove(item);
	}

	
	public ArrayList<Integer> getItemBasket()
	{
		return itemBasket;
	}

}
