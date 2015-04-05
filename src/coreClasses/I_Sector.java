package coreClasses;

import java.util.Queue;

public interface I_Sector {

	public Queue<Item> getItemQueue();	
	public Item getNextItem();
	public void putItemInQueue(Item item);
	
}
