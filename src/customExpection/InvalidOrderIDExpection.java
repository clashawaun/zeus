package customExpection;

public class InvalidOrderIDExpection extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4997478460237690448L;

	@Override
	public String getMessage()
	{
		return " Invalid Order ID  ";
		
	}
	
	public String getMessage(int orderID)
	{
		return " Order ID = " + orderID + "  is an Invalid Order ID"; 
	}
}
