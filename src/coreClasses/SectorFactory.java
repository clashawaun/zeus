package coreClasses;

public class SectorFactory {

	public SectorFactory() {
	
	}
	
	public I_Sector makeSector(int type, int id)
	{
		I_Sector sector;
		
		switch(type)
		{
			case 1:
				sector = new Sector(id, 10000, 10000, 5000 );
				break;
			default:
				sector = null;
				break;
		}
		return sector;
	}
}
