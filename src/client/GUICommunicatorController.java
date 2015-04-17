package client;

import java.util.ArrayList;

import servercommunication.ServerCommunicator;
import servercommunication.ServerMessage;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GUICommunicatorController 
{
	private ServerCommunicator communicator;
	private ServerMessage serverResult;
	private JsonObject user;

	public GUICommunicatorController() 
	{
		communicator = new ServerCommunicator();
		user = null;
	}

	public boolean LoginUser(String email, String password)
	{
		if ( email == null || password == null) return false;
		user = new JsonObject();
		user.addProperty("email", email);
		user.addProperty("password", password);
		
		
		serverResult = communicator.sendServerMessage(new ServerMessage("Login", user.toString()));
		
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		user.addProperty("type", credentials.get("type").getAsInt());
		
		return credentials.get("isValid").getAsBoolean();
	}
	
	public boolean logOut()
	{
		user = null;
		return true;
	}
	
	public int getUserType()
	{
		if(user != null)	return user.get("type").getAsInt();
		
		return 0;
	}
	
	public void setCurrentSectorLocation(int sectorID)
	{
		if(user != null)
			user.addProperty("sector", sectorID);
	}
	
	
	public ArrayList<String> getPickerCurrentBasket()
	{
		serverResult = communicator.sendServerMessage(new ServerMessage("GetItemsForPicker", "" ,user.toString() ));
		
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		
		JsonArray jsonArray = credentials.getAsJsonArray("items");
		
		ArrayList<String> basket = new ArrayList<String>();
		
		for(JsonElement element : jsonArray)
		{
			JsonObject obj = element.getAsJsonObject();
				
			basket.add(" Item Id: "+ obj.get("ID") + "  Location: " + "XXXX");
		}
		
		return basket;
	}
	
	public void collectItem(int itemID)
	{
		/*//"MarkItemAsPicked"
		JsonObject items = new JsonObject();
		items.addProperty("key", itemID);
		
		JsonArray array = new JsonArray();

		JsonElement element = items.get("key");
		array.add(element);
		items.addProperty("items", itemID);
		
		System.out.println(items);
		serverResult = communicator.sendServerMessage(new ServerMessage("MarkItemAsPicked", items.toString() ,user.toString() ));
		*/
	}
}
