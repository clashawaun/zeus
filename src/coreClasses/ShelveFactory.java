package coreClasses;

public class ShelveFactory {

	public ShelveFactory() 
	{
		
	}
	
	public I_Shelve makeShelve(int type, int id)
	{
		I_Shelve shelve;
		
		switch(type)
		{
		case 1:
			shelve = new Shelve(id, 8, 4, 2);
			break;
		case 2:
			shelve = new Shelve(id, 40, 0, 0);
			break;
		case 3:
			shelve = new Shelve(id, 0, 12, 0);
			break;
		case 4:
			shelve = new Shelve(id, 0, 0, 6);
			break;
		default:
			shelve = null;
		}
		
		return shelve;
	}

}
