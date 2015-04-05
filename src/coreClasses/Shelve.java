package coreClasses;

import java.util.ArrayList;

public class Shelve implements I_Shelve 
{
	private int numberOfSmallCubbies;
	private int  numberOfMediumCubbies;
	private int numberOfLargeCubbies;
	private int currentNumberOfSmallCubbies;
	private int currentNumberOfMediumCubbies;
	private int currentNumberOfLargeCubbies;
	private ArrayList<Integer> cubbies;
	private int id;
	
	public Shelve()
	{
		this.id = 0;
		this.numberOfSmallCubbies = 0;
		this.numberOfMediumCubbies = 0;
		this.numberOfLargeCubbies = 0;
		this.currentNumberOfSmallCubbies  = 0;
		this.currentNumberOfMediumCubbies = 0;
		this.currentNumberOfLargeCubbies  = 0;
		cubbies = new ArrayList<Integer>();
	}
	
	public Shelve(int id, int numberOfSmallCubbies, int numberOfMediumCubbies, int numberOfLargeCubbies )
	{
		this.numberOfSmallCubbies = numberOfSmallCubbies;
		this.numberOfMediumCubbies = numberOfMediumCubbies;
		this.numberOfLargeCubbies = numberOfLargeCubbies;
		this.currentNumberOfSmallCubbies  = 0;
		this.currentNumberOfMediumCubbies = 0;
		this.currentNumberOfLargeCubbies  = 0;
		cubbies = new ArrayList<Integer>();

	}
	
	@Override
	public int getNumberOfSmallCubbies() 
	{
		return numberOfSmallCubbies;
	}

	@Override
	public void setNumberOfSmallCubbies(int numberOfSmallCubbies) {
		this.numberOfSmallCubbies = numberOfSmallCubbies;
	}

	@Override
	public int getNumberOfMediumCubbies() {
		return numberOfMediumCubbies;
	}

	@Override
	public void setNumberOfMediumCubbies(int numberOfMediumCubbies)
	{
		this.numberOfMediumCubbies = numberOfMediumCubbies;
	}

	@Override
	public int getNumberOfLargeCubbies()
	{
		return numberOfLargeCubbies;
	}

	@Override
	public void setNumberOfLargeCubbies(int numberOfLargeCubbies)
	{
		this.numberOfLargeCubbies = numberOfLargeCubbies;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setCubbies(ArrayList<Integer> cubbies) {
		this.cubbies = cubbies;
	}

	@Override
	public void addSmallCubby(int cubbyID) {

		if(currentNumberOfSmallCubbies < numberOfSmallCubbies)
		{
			cubbies.add(cubbyID);
			currentNumberOfSmallCubbies++;
		}
		
	}

	@Override
	public void addMediumCubby(int cubbyID) 
	{
		if(currentNumberOfMediumCubbies < numberOfMediumCubbies)
		{
			cubbies.add(cubbyID);
			currentNumberOfMediumCubbies++;
		}
	}

	@Override
	public void addLargeCubby(int cubbyID) 
	{
		if(currentNumberOfLargeCubbies < numberOfLargeCubbies)
		{
			cubbies.add(cubbyID);
			currentNumberOfLargeCubbies++;
		}
		
	}

	@Override
	public boolean hasCubby(int cubbyID) 
	{
		return cubbies.contains(cubbyID);
		
	}

	@Override
	public ArrayList<Integer> getCubbies()
	{
		return cubbies;
	}

	@Override
	public void removeSmallCubby(int cubbyID)
	{
		cubbies.remove(cubbies.indexOf(cubbies));
		currentNumberOfSmallCubbies--;
	}

	@Override
	public void removeMediumCubby(int cubbyID) 
	{
		cubbies.remove(cubbies.indexOf(cubbies));
		currentNumberOfMediumCubbies--;
	}

	@Override
	public void removeLargeCubby(int cubbyID) 
	{
		cubbies.remove(cubbies.indexOf(cubbies));
		currentNumberOfLargeCubbies--;
	}

}
