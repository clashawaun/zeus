package coreClasses;
import java.util.List;
public abstract class Cubby implements I_Cubby
{
	private final String ID;
	private List<Item> cubbyItems;
	private final int HEIGHT;
	private final int WIDTH;
	private final int DEPTH;
	private final int TYPE;
	
	public Cubby()
	{
		this.ID = null;
		this.HEIGHT = 0;
		this.WIDTH = 0;
		this.DEPTH = 0;
		this.TYPE = 0;
	}
	
	public Cubby(String id, int height, int width, int depth, int type)
	{
		this.ID = id;
		this.HEIGHT = height;
		this.WIDTH = width;
		this.DEPTH = depth;
		this.TYPE = type;
	}
	
	public String getCubbyId()
	{
		return ID;
	}
	public List<Item> getCubbyItems()
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
	
	
	
}
