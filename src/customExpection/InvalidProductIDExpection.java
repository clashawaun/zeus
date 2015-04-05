package customExpection;

public class InvalidProductIDExpection extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8959191516887114633L;

	@Override
	public String getMessage()
	{
		return " Invalid Product ID  ";
		
	}
	
	public String getMessage(int productID)
	{
		return " Product ID = " + productID + "  is an Invalid Product ID"; 
	}
	
	
}
