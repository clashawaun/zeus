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
	
	public int getSectorId()
	{
		return sector.getID();
	}
	
	public ArrayList<Item> assignItemsForPicker(Picker picker)
	{
		//This function requires DB access to set certain variables to maintain state.
		//Also its required that the server message objects always carry the user ID
		//of the person sending request.
		ArrayList<Item> assignedItems = new ArrayList<Item>();
		for(int i = 0; i < 5; i++)
		{
			Item tempItem = sector.getNextItem();
			if(tempItem == null)
				break;
			//TODO: Duplication of logic .... needs to be revised
			tempItem.setAssignedUserID(picker.getID());
			tempItem.setCurrentState("AWAITING_CHECK_IN");
			picker.addItemToBasket(tempItem);
			assignedItems.add(tempItem);
		}
		return assignedItems;
	}
	
}
