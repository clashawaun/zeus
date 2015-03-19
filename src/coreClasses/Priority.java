package coreClasses;

public class Priority implements I_Priority
{
	private final String ID;
	
	public Priority(String id)
	{
		this.ID = id;
	}
	
	public String getPriorityId()
	{
		return ID;
	}
	

	public int calculatePriority()
	{
		//This needs to be changed
		return 0;
	}
	
}
