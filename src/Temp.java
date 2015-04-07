
import servercommunication.*;


public class Temp 
{
	public static void main(String [] args)
	{

		ServerCommunicator t = new ServerCommunicator();
		ServerMessage result = t.sendServerMessage(new ServerMessage("Login", "{\"email\": \"Big.Bird@gmail.com\", \"password\": \"yellow\"}"));
		System.out.println(result.getData());
	}
}
