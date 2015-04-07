package coreClasses;


public class CubbyFactory 
{
	public CubbyFactory()
	{
		
	}
	
	/*
	 * Creates a cubby object depending on the type
	 * 0 = small cubby
	 * 1 = medium cubby
	 * 2 = large cubby
	 * Never Returns Null. Can throw Exception 
	 */
	public I_Cubby makeCubby(int type, int id) 
	{

		Cubby cubby;
		
		switch (type)
		{
		case 1:
			cubby = new CubbySmall(id);
			break;
			
		case 2:
			cubby = new CubbyMedium(id);
			break;
			
		case 3:
			cubby =  new CubbyLarge(id);
			break;
		
		default:
			
			cubby = null;
		}
		
		
		return cubby;
	}
	
	
	
}
