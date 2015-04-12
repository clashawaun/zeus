package coreClasses;

import java.util.Date;

public interface I_Item {

	public float getPriority() ;
	public void setPriority(float priority) ;
	public String getCurrentState() ;
	public void setCurrentState(String currentState);
	public int getAssignedUserID() ;
	public void setAssignedUserID(int assignedUserID);
	public int getCubbyID();
	public void setCubbyID(int cubbyID) ;
	public int getxPlacementPoint() ;
	public void setxPlacementPoint(int xPlacementPoint);
	public int getPRODUCT_ID() ;
	public int getID() ;
	public Date getDATE_OF_MANUFACTURE();
	public Date getDATE_OF_EXPRIRY();
	
	@Override
	public boolean equals(Object obj);
}
