package coreClasses;
import java.util.List;

public interface I_Cubby 
{
	public int getID();
	public List<Item> getItems();
	public int getHeight();
	public int getWidth();
	public int getDepth();
	public int getType();

	@Override
	public boolean equals(Object obj);
}
