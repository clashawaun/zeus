package customExpection;

public class InvalidItemIDExpection extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6392706941074911536L;

	@Override
	public String getMessage()
	{
		return " Invalid Item ID  ";
		
	}
	
	public String getMessage(int itemID)
	{
		return " Item ID = " + itemID + "  is an invalid item ID  "; 
	}
	
}
