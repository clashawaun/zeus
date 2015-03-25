package coreClasses;

import customExpection.InvalidCubbyExpection;

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
	public I_Cubby makeCubby(int type) throws InvalidCubbyExpection
	{
		//set cubby to default of null
		Cubby cubby = null;
		
		//id is created in createCubbyID
		String id  = createCubbyID();
		
		
		
		
		//Switch statement to decide what type of cubby to create
		switch (type)
		{
		case 0:
			cubby = new CubbySmall(id);
			break;
			
		case 1:
			cubby = new CubbyMedium(id);
			break;
			
		case 2:
			cubby =  new CubbyLarge(id);
			break;
		
		default:
			//if invalid type throw invalid Cubby Exception
			throw new InvalidCubbyExpection();
		}
		
		//return the cubby. this will never return null.
		return cubby;
	}
	
	
	/*
	 * Look at database of IDs. Keep creating IDs until
	 * it isn't in the list of IDs in the database.
	 * Could also store a list of IDs not in use and select out of that
	 */
	private String createCubbyID()
	{
		boolean isUnique = false;
		String id ="";
		
		//while isnt Unique
		while(!isUnique)
		{
			//create random ID
			id = "AB201";
		
			//just for testing set isUnique = true
			isUnique = true;
		}
		
		//return id
		return id;
	}
}
