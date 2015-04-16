package coreClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Sector implements I_Sector
{
	private Queue<Item> itemQueue;
	private ArrayList<Integer> shelves;
	private int height;
	private int width;
	private int depth;
	private int ID;
	
	
	protected Sector(int ID, int height, int width, int depth)
	{
		this.ID = ID;
		this.height = height;
		this.width = width;
		this.depth = depth;
		shelves = new ArrayList<Integer>();
		itemQueue = new LinkedList<Item>();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return (((obj instanceof Sector)) && ((Sector) obj) != null && this.ID == ((Sector) obj).getID());     
	}
	
	public ArrayList<Integer> getShelves()
	{
		return shelves;
	}
	
	public void setShelves(ArrayList<Integer> shelves)
	{
		this.shelves = shelves;
	}
	
	public void addShelve(int shelveID)
	{
		shelves.add(shelveID);
	}
	
	public Queue<Item> getItemQueue()
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getDepth() 
	{
		return depth;
	}

	public void setDepth(int depth)
	{
		this.depth = depth;
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public void setItemQueue(Queue<Item> itemQueue) 
	{
		this.itemQueue = itemQueue;
	}

	@Override
	public boolean hasShelf(int shelfID) {
		
		for(Integer shelf : shelves)
		{
			if(shelf == shelfID) return true;
		}
		
		return false;
	}



	
}
