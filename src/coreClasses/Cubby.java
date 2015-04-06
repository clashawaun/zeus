package coreClasses;
import java.util.ArrayList;
public abstract class Cubby implements I_Cubby
{
	private int ID;
	private ArrayList<Item> cubbyItems;
	private final int HEIGHT;
	private final int WIDTH;
	private final int DEPTH;
	private final int TYPE;
	
	public Cubby()
	{
		this.ID = 0;
		this.HEIGHT = 0;
		this.WIDTH = 0;
		this.DEPTH = 0;
		this.TYPE = 0;
	}
	
	public Cubby(int id, int height, int width, int depth, int type)
	{
		this.ID = id;
		this.HEIGHT = height;
		this.WIDTH = width;
		this.DEPTH = depth;
		this.TYPE = type;
	}
	
	public int getID()
	{
		return ID;
	}
	public ArrayList<Item> getItems()
	{
		return cubbyItems;
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
	
}
