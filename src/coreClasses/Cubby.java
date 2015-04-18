package coreClasses;
import java.util.ArrayList;
public abstract class Cubby implements I_Cubby
{
	private int ID;
	private ArrayList<Integer> items;
	private final int HEIGHT;
	private final int WIDTH;
	private final int DEPTH;
	private final int TYPE;
	

	
	protected Cubby(int id, int height, int width, int depth, int type)
	{
		this.ID = id;
		this.HEIGHT = height;
		this.WIDTH = width;
		this.DEPTH = depth;
		this.TYPE = type;
		this.items = new ArrayList<Integer>();
	}
		
	public int getID()
	{
		return ID;
	}
	
	public ArrayList<Integer> getItems()
	{
		return items;
	}
	
	public void addItem(int itemID)
	{
		items.add(itemID);
	}
	
	public int getHeight()
	{
		return HEIGHT; 
	}
	
	public int getWidth()
	{
		return WIDTH;
	}
	
	public int getDepth()
	{
		return DEPTH;
	}
	
	public int getType()
	{
		return TYPE;
	}
	
	public boolean hasItem(int itemID)
	{
		for(Integer i : items)
		{
			if(i == itemID) return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return "CubbyId: " + ID + " Items: " + items;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return (((obj instanceof Cubby)) && ((Cubby) obj) != null && this.ID == ((Cubby) obj).getID());     
	}
}
