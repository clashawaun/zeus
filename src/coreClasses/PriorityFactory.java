package coreClasses;

public class PriorityFactory 
{

	public PriorityFactory()
	{
		
	}
	
	public I_Priority getPriority(int priorityID)
	{
		switch(priorityID)
		{
			case 0: return new Priority(priorityID);
			default: return null;
		}
	}
}
