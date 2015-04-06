package coreClasses;

import java.util.ArrayList;

public interface I_Shelve {

	public boolean hasCubby(int cubbyID);
	public boolean addCubby(I_Cubby cubby);
	public boolean removeCubby(I_Cubby cubby);
	public ArrayList<Integer> getCubbies();
	public int getId();
	public void setId(int id);
	public void setCubbies(ArrayList<Integer> cubbies);
	
	public int getHeight();
	public int getWidth();
	public int getDepth();
	public void setHeight(int height);
	public void setWidth(int width);
	public void setDepth(int depth);

}
