package customExpection;

public class UnableToAssignItemToUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -421608144395274571L;
	
	@Override
	public String getMessage()
	{
		return " Unable To Assign Item To User  ";
		
	}
	
	public String getMessage(int itemID, int userID)
	{
		return " " + "Item ID = " + itemID + " User ID = " + userID + " Unable To Assign Item To User"; 
	}


}
