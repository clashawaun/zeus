package client;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

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
	private JsonObject currentSector;
	
	private Gson gson;
	
	public GUICommunicatorController() 
	{
		communicator = new ServerCommunicator();
		user = null;
		gson = new Gson();
	}

	public boolean LoginUser(String email, String password)
	{
		if ( email == null || password == null) return false;
		
		user = new JsonObject();
		user.addProperty("email", email);
		user.addProperty("password", password);
		
		serverResult = communicator.sendServerMessage(new ServerMessage("Login", user.toString()));
		
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		
		if(credentials.get("isValid").getAsBoolean())
		{
			user.addProperty("type", credentials.get("type").getAsInt());
			System.out.println(user);
		} else user = null;
		
		return credentials.get("isValid").getAsBoolean();
	}
	
	public boolean logOut()
	{
		user = null;
		return true;
	}
	
	public int getUserType()
	{
		if(user != null)	
			return user.get("type").getAsInt();
		
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
				basket.add(" Item Id: "+ element.getAsJsonObject().get("ID") + "  Location: " + "XXXX");
		
		return basket;
	}
	
	
	public void collectItem(int itemID)
	{
		JsonObject items = new JsonObject();
		items.add("items", gson.toJsonTree(new int[] {itemID}).getAsJsonArray());
		serverResult = communicator.sendServerMessage(new ServerMessage("MarkItemAsPicked", items.toString() ,user.toString() ));
	}
	
	public boolean requestItemsForPickerBasket()
	{
		serverResult = communicator.sendServerMessage(new ServerMessage("AssignItemsToPicker", user.toString() ,user.toString() ));
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		return credentials.get("isSuccess").getAsBoolean();
	}
	
	public boolean requestItemsForStockerBasket()
	{
		serverResult = communicator.sendServerMessage(new ServerMessage("AssignItemsToPicker", user.toString() ,user.toString() ));
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		return credentials.get("isSuccess").getAsBoolean();
	}
}
