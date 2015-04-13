package coreClasses;

import java.util.Date;


public class Item  implements I_Item{

	private final int PRODUCT_ID;
	private final int ID;
	private Date date_of_manufacture;
	private Date date_of_expriry;
	
	private String currentState;
	private int assignedUserID;
	private int xPlacementPoint;
	private float priority;
	
	protected Item()
	{
		PRODUCT_ID = -1;
		ID = -1;
	}


	public Item(int productID, int id, Date manufactureDate, Date expriryDate)
	{
		this.PRODUCT_ID = productID;
		this.ID = id;
		this.date_of_manufacture = manufactureDate;
		this.date_of_expriry = expriryDate;
		
		this.currentState = "";

		this.xPlacementPoint = 0;
		this.priority = 0;
	}
	
	
	@Override
	public boolean equals(Object obj)
	{
		return (((obj instanceof Item)) && ((Item) obj) != null && this.ID == ((Item) obj).getID());     
	}
	
	public float getPriority() {
		return priority;
	}

	public void setPriority(float priority) {
		this.priority = priority;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public int getAssignedUserID() {
		return assignedUserID;
	}

	public void setAssignedUserID(int assignedUserID) {
		this.assignedUserID = assignedUserID;
	}



	public int getxPlacementPoint() {
		return xPlacementPoint;
	}

	public void setxPlacementPoint(int xPlacementPoint) {
		this.xPlacementPoint = xPlacementPoint;
	}

	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public int getID() {
		return ID;
	}

	public Date getDATE_OF_MANUFACTURE() {
		return date_of_manufacture;
	}

	public Date getDATE_OF_EXPRIRY() {
		return date_of_expriry;
	}
	
	
}
