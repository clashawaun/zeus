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
	private int id;
	
	public Sector()
	{
		itemQueue = new LinkedList<Item>();
		shelves = new ArrayList<Integer>();
		this.id = 0;
		this.height = 0;
		this.width = 0;
		this.depth = 0;
	}
	
	public Sector(int id, int height, int width, int depth)
	{
		this.id = id;
		this.height = height;
		this.width = width;
		this.depth = depth;
		shelves = new ArrayList<Integer>();
		itemQueue = new LinkedList<Item>();
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

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setItemQueue(Queue<Item> itemQueue) {
		this.itemQueue = itemQueue;
	}



	
}
