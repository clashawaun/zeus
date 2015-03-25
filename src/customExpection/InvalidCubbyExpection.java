package customExpection;

public class InvalidCubbyExpection extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage()
	{
		return "   Invalid Cubby Type   ";
		
	}
}
