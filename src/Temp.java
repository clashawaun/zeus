import servercommunication.*;
public class Temp 
{
	public static void main(String [] args)
	{
		ServerCommunicator t = new ServerCommunicator();
		ServerMessage m = t.sendServerMessage(new ServerMessage("beep", "bop"));
		
	}
}
