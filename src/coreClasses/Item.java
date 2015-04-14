package coreClasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Item  implements I_Item{

	private final int PRODUCT_ID;
	private final int ID;
	
	private Date manufactureDate;
	private Date expriryDate;
	
	private String currentState;
	private int assignedUserID;
	private int xPlacementPoint;
	private float priority;
	
	public Item(int productID, int id, String manufactureDate, String expriryDate) throws Exception
	{
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		 
		
		this.PRODUCT_ID = productID;
		this.ID = id;
		
		try {
			if(manufactureDate == null)
			{
				this.manufactureDate = null;
			}
			else 
			{	
				this.manufactureDate = (Date) format.parse(manufactureDate);
			}
		} catch (ParseException e) 
		{
			throw new Exception("Cannot convert: " + manufactureDate + " to valid date format: \"yyyy-mm-dd\"  ");
		}
		
		try {
			
			if(expriryDate == null)
			{
				this.expriryDate = null;
			} 
			else
			{
				this.expriryDate = (Date) format.parse(expriryDate);
			}
		
		} 
		catch (ParseException e)
		{
			throw new Exception("Cannot convert: " + expriryDate + " to valid date format: \"yyyy-mm-dd\"  ");
		}
		
		
		this.currentState = "AWAITING_STOCKER";

		this.xPlacementPoint = 0;
		this.priority = 0;
	}
	
	
	@Override
	public boolean equals(Object obj)
	{
		return (((obj instanceof Item)) && ((Item) obj) != null && this.ID == ((Item) obj).getID());     
	}
	
	@Override
	public float getPriority() 
	{
		return priority;
	}
	
	@Override
	public void setPriority(float priority)
	{
		this.priority = priority;
	}
	
	@Override
	public String getCurrentState()
	{
		return currentState;
	}

	/*
	 * Options are:
	 *  AWAITING_STOCKER
	 *	PENDING_STOCKING
	 * 	AVAILABLE
	 *	AWAITING_PICKER
	 *	AWAITING_CHECK_IN
	 *	AWAITING_PACKER
	 *	PACKED
	 *	SHIPPED
	 * 
	 */
	@Override
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	@Override
	public int getAssignedUserID() {
		return assignedUserID;
	}

	@Override
	public void setAssignedUserID(int assignedUserID) {
		this.assignedUserID = assignedUserID;
	}

	@Override
	public int getxPlacementPoint() {
		return xPlacementPoint;
	}

	@Override
	public void setxPlacementPoint(int xPlacementPoint) {
		this.xPlacementPoint = xPlacementPoint;
	}

	@Override
	public int getProductID() {
		return PRODUCT_ID;
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public Date getDateOfManufacture() {
		return manufactureDate;
	}
	
	@Override
	public Date getDateOfExpriry() {
		return expriryDate;
	}
	
	
}
