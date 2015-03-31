package coreClasses;

import java.util.Calendar;


public class Item {

	private final int PRODUCT_ID;
	private final int ID;
	private final Calendar DATE_OF_MANUFACTURE;
	private final Calendar DATE_OF_EXPRIRY;
	
	private String currentState;
	private int assignedUserID;
	private String cubbyID;
	private int xPlacementPoint;
	
	
	public Item(int productID, int id, Calendar manufactureDate, Calendar expriryDate)
	{
		PRODUCT_ID = productID;
		ID = id;
		DATE_OF_MANUFACTURE = manufactureDate;
		DATE_OF_EXPRIRY = expriryDate;
		
		currentState = "";
		cubbyID = "";
		xPlacementPoint = 0;
		
		
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

	public String getCubbyID() {
		return cubbyID;
	}

	public void setCubbyID(String cubbyID) {
		this.cubbyID = cubbyID;
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

	public Calendar getDATE_OF_MANUFACTURE() {
		return DATE_OF_MANUFACTURE;
	}

	public Calendar getDATE_OF_EXPRIRY() {
		return DATE_OF_EXPRIRY;
	}
	
	
}
