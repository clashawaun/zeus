
import servercommunication.*;


public class Temp 
{
	public static void main(String [] args)
	{
		//The Zeus server selection service will determine which server should be used to service the request.
		ServerCommunicator t = new ServerCommunicator();
		ServerMessage result = t.sendServerMessage(new ServerMessage("NewOrder", "{\"productIDs\": [1,2,3], \"shippingAddress\": \"yellow\"}"));
		t.sendServerMessage(new ServerMessage("GetItemsForPicker", "", "{\"email\": \"picker\", \"password\": \"1234\"}"));
		t.sendServerMessage(new ServerMessage("MarkItemAsPicked", "{\"items\": [9]}", "{\"email\": \"picker\", \"password\": \"1234\"}"));
		result = t.sendServerMessage(new ServerMessage("AssignItemsToPicker", "{\"sector\": 1}", "{\"email\": \"picker\", \"password\": \"1234\"}"));
		System.out.println(result.getData());
	}
}
