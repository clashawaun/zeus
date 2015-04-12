package server;
import java.util.ArrayList;



import coreClasses.I_Sector;
import coreClasses.Picker;
import coreClasses.Sector;
import coreClasses.Item;
public class SectorTools 
{
	private I_Sector sector;
	public SectorTools()
	{
		sector = null;
	}
	
	public SectorTools(I_Sector sector)
	{
		this.sector = sector;
	}
	
	public void addItemToQueue(Item item)
	{
		//The reason for encapsulating this is I think 
		//More functionality may be needed here when the 
		//design becomes more fleshed out
		sector.putItemInQueue(item);
	}
	
	public boolean isItemOnQueue()
	{
		//Same as above function
		return !sector.getItemQueue().isEmpty();
	}
	
	public ArrayList<Item> getNewItemsForCollector(Picker picker)
	{
		//This function requires DB access to set certain variables to maintain state.
		//Also its required that the server message objects always carry the user ID
		//of the person sending request.
		return new ArrayList<Item>();
	}
	
}
