package coreClasses;

import java.util.LinkedList;
import java.util.Queue;

public class Sector 
{
	private Queue<Item> itemQueue;
	public Sector()
	{
		itemQueue = new LinkedList<Item>();
	}
	
	public Queue getItemQueue()
	{
		return itemQueue;
	}
	
	public Item getNextItem()
	{
		return itemQueue.poll();
	}
	public void putItemInQueue(Item item)
	{
		itemQueue.add(item);
	}
}
