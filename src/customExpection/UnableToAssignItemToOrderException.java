package customExpection;

public class UnableToAssignItemToOrderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2998644173740772637L;

	@Override
	public String getMessage()
	{
		return " Unable to Assign Item To Order  ";
		
	}
	
	public String getMessage(int orderID, int productID, int itemID)
	{
		return "  Order ID = " + orderID + "  Product ID = " + productID + "  Item ID = " + itemID + "  Unable to Assign Item To Order"; 
	}
}
