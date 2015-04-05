package customExpection;

public class InvalidUserExection extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 745193141540613725L;

	
	@Override
	public String getMessage()
	{
		return " Invalid User ID  ";
		
	}
	
	public String getMessage(int userID)
	{
		return " User ID = " + userID + "  is an Invalid User ID"; 
	}
}
