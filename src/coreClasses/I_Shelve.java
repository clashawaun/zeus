package coreClasses;

import java.util.ArrayList;

public interface I_Shelve {

	public void addSmallCubby(int cubbyID);
	public void addMediumCubby(int cubbyID);
	public void addLargeCubby(int cubbyID);
	public boolean hasCubby(int cubbyID);
	public ArrayList<Integer> getCubbies();
	public void removeSmallCubby(int cubbyID);
	public void removeMediumCubby(int cubbyID);
	public void removeLargeCubby(int cubbyID);
	public int getNumberOfSmallCubbies();
	public void setNumberOfSmallCubbies(int numberOfSmallCubbies);
	public int getNumberOfMediumCubbies();
	public void setNumberOfMediumCubbies(int numberOfMediumCubbies);
	public int getNumberOfLargeCubbies();
	public void setNumberOfLargeCubbies(int numberOfLargeCubbies);
	public int getId();
	public void setId(int id);
	public void setCubbies(ArrayList<Integer> cubbies);

}
