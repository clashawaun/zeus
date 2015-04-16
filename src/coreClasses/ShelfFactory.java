package coreClasses;

public class ShelfFactory implements I_ShelfFactory{

	public ShelfFactory() 
	{
		
	}
	
	public I_Shelf makeShelve(int type, int id)
	{
		I_Shelf shelve;
		
		switch(type)
		{
		case 1:
			shelve = new Shelf(id, 400, 1000, 100);
			break;
		case 2:
			shelve = new Shelf(id,400, 1000, 100);
			break;
		case 3:
			shelve = new Shelf(id,400, 1000, 100);
			break;
		case 4:
			shelve = new Shelf(id,400, 1000, 100);
			break;
		default:
			shelve = null;
		}
		
		return shelve;
	}

}
