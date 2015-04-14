package coreClasses;

import java.util.Date;

public interface I_Item {

	public float getPriority() ;
	public void setPriority(float priority) ;
	public String getCurrentState() ;
	public void setCurrentState(String currentState);
	public int getAssignedUserID() ;
	public void setAssignedUserID(int assignedUserID);

	public int getxPlacementPoint() ;
	public void setxPlacementPoint(int xPlacementPoint);
	public int getProductID() ;
	public int getID() ;
	public Date getDateOfManufacture();
	public Date getDateOfExpriry();
	
	@Override
	public boolean equals(Object obj);
}
