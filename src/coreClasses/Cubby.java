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
	
	public int getCubbyId()
	{
		return ID;
	}
	public ArrayList<Item> getCubbyItems()
	{
		return cubbyItems;
	}
	public int getCubbyHeight()
	{
		return HEIGHT; 
	}
	public int getCubbyWidth()
	{
		return WIDTH;
	}
	public int getCubbyDepth()
	{
		return DEPTH;
	}
	
	public int getType()
	{
		return TYPE;
	}
	
}
