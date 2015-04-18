package coreClasses;

import java.util.ArrayList;
//Comment
public class Stocker extends User {

	private ArrayList<Integer> stackBasket;
	
	
	public Stocker(int userID, String firstName, String surname, String email, String phone, String password)
	{
		super(userID, firstName, surname, email, phone, password);
		stackBasket = new ArrayList<Integer>();
	}
	
	public boolean addItem(Integer item)
	{
		return stackBasket.add(item);
	}
	
	public boolean removeItem(Integer item)
	{
		return stackBasket.remove(item);
	}
	
	
	
}
