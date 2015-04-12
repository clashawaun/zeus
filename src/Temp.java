
import servercommunication.*;


public class Temp 
{
	public static void main(String [] args)
	{
		//The Zeus server selection service will determine which server should be used to service the request.
		ServerCommunicator t = new ServerCommunicator();
		ServerMessage result = t.sendServerMessage(new ServerMessage("NewOrder", "{\"productIDs\": [9,12,5], \"shippingAddress\": \"yellow\"}"));
		System.out.println(result.getData());
	}
}
