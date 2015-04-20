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
	private JsonObject currentSector;

	
	private Gson gson;
	
	public GUICommunicatorController() 
	{
		communicator = new ServerCommunicator();
		user = null;
		gson = new Gson();
		currentSector = new JsonObject();
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
		currentSector = null;
		return true;
	}
	
	public int getUserType()
	{
		if(user != null)	
			return user.get("type").getAsInt();
		
		return -1;
	}
	
	public void setCurrentSectorLocation(int sectorID)
	{
		if(user != null)
			currentSector.addProperty("sector", sectorID);
	}
	
	
	public ArrayList<String> getPickerCurrentBasket()
	{
		serverResult = communicator.sendServerMessage(new ServerMessage("GetItemsForPicker", "" ,user.toString() ));
		
		if(serverResult == null)
			return null;
		
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
		serverResult = communicator.sendServerMessage(new ServerMessage("AssignItemsToPicker", currentSector.toString() ,user.toString() ));
		
		if(serverResult == null)
			return false;
		
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		return credentials.get("isSuccess").getAsBoolean();
	}
	
	public boolean requestItemsForStockerBasket()
	{
		serverResult = communicator.sendServerMessage(new ServerMessage("GetItemsForStocker", currentSector.toString() ,user.toString() ));
		
		if(serverResult == null)
			return false;
		
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		return credentials.get("isSuccess").getAsBoolean();

	}
	
	public ArrayList<String> getStockerCurrentBasket()
	{
		serverResult = communicator.sendServerMessage(new ServerMessage("GetItemsForStocker", currentSector.toString() ,user.toString() ));
		
		if(serverResult == null)
			return null;
		
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		JsonArray jsonArray = credentials.getAsJsonArray("items");
		ArrayList<String> basket = new ArrayList<String>();
		
		JsonObject obj;
		
		for(JsonElement element : jsonArray )
		{
			obj = gson.fromJson(element, JsonObject.class); 
			basket.add("Product ID: " + obj.get("ID").getAsString() + " Location: " + "XXXXXX");
		}
		
		return basket;
	}
	
	public ArrayList<Integer> getSectorsIDs()
	{
		ArrayList<Integer> sectors = new ArrayList<Integer>();
	
		serverResult = communicator.sendServerMessage(new ServerMessage("GetSectors", "" ,user.toString() ));
		
		if(serverResult == null)
			return null;
	
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		JsonArray jsonArray = credentials.getAsJsonArray("sectors");
		
		for(JsonElement element : jsonArray )
			sectors.add(gson.fromJson(element, JsonObject.class).get("ID").getAsInt());
		
		if(sectors.size()>0)
			currentSector.addProperty("sector", sectors.get(0));
		
		return sectors;
	}
	
	public ArrayList<String> searchForProduct(String product)
	{

		JsonObject obj = new JsonObject();
		obj.addProperty("searchTerm", product);
		
		serverResult = communicator.sendServerMessage(new ServerMessage("SearchProduct", obj.toString() ,user.toString() ));
		
		if(serverResult == null)
			return null;
		
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		
		JsonArray jsonArray = credentials.getAsJsonArray("products");
		ArrayList<String> products = new ArrayList<String>();
		
		for(JsonElement element : jsonArray )
		{
			obj = gson.fromJson(element, JsonObject.class); 
			products.add("Product Name: " + obj.get("name").getAsString() + " Product ID: " + obj.get("ID").getAsString());
		}
		
		return products;
	}
	
	public int registorItem(int productID, String manDate, String expDate)
	{
		return 7;
	}
	
	public boolean putItemInCubby(int itemID)
	{
		//"StockItems"

		return true;
	}
}