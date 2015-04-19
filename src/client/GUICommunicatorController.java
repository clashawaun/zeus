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
	private ArrayList<String> basket;
	ArrayList<Integer> sectors;
	
	private Gson gson;
	
	public GUICommunicatorController() 
	{
		communicator = new ServerCommunicator("127.0.0.1");
		
		user = null;
		gson = new Gson();
		basket = new ArrayList<String>();
		sectors  = new ArrayList<Integer>();
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
		serverResult = communicator.sendServerMessage(new ServerMessage("GetItemsForStocker", user.toString() ,user.toString() ));
		
		if(serverResult == null)
			return false;
		
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		return credentials.get("isSuccess").getAsBoolean();
//		
//		basket.add("Item Id: "+ 20 +"shelf number: " +  1 + " cubby number: " + 2 + "  in sector: " + 1);
//		basket.add("Item Id: "+ 22 +"shelf number: " +  2 + " cubby number: " + 1 + "  in sector: " + 1);
//		basket.add("Item Id: "+ 26 +"shelf number: " +  3 + " cubby number: " + 3 + "  in sector: " + 1);
//		
//		System.out.println("Stocker is Requesting Items from server");
//		System.out.println("Server has items for stocker");
//		return true;
	}
	
	public boolean putItemInCubby(int itemID)
	{
		//"StockItems"
		serverResult = communicator.sendServerMessage(new ServerMessage("StockItems", user.toString() ,user.toString() ));
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		System.out.println("Stocker has put an items away on item number: " +  itemID);
		return true;
	}
	
	public ArrayList<String> getStockerCurrentBasket()
	{
		basket.add("Item Id: "+ 20 +"shelf number: " +  1 + " cubby number: " + 2 + "  in sector: " + 1);
		basket.add("Item Id: "+ 22 +"shelf number: " +  2 + " cubby number: " + 1 + "  in sector: " + 1);
		basket.add("Item Id: "+ 26 +"shelf number: " +  3 + " cubby number: " + 3 + "  in sector: " + 1);
		
		return basket;
	}
	
	public ArrayList<Integer> getSectorsIDs()
	{
		if(sectors.size()>0)
			sectors = new ArrayList<Integer>();
		
		serverResult = communicator.sendServerMessage(new ServerMessage("GetSectors", "" ,user.toString() ));
		
		if(serverResult == null)
			return null;
	
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		JsonArray jsonArray = credentials.getAsJsonArray("sectors");
		
		
		JsonObject obj;
		for(int index=0; index < jsonArray.size(); index++ )
		{
			obj = gson.fromJson(jsonArray.get(index), JsonObject.class); 
			sectors.add(obj.get("ID").getAsInt());
		}
		
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
		
		for(int index=0; index < jsonArray.size(); index++ )
		{
			obj = gson.fromJson(jsonArray.get(index), JsonObject.class); 
			products.add("Product Name: " + obj.get("name").getAsString() + " Product ID: " + obj.get("ID").getAsString());
		}
		
		return products;
	}
	
	public int registorItem(int productID, String manDate, String expDate)
	{
		return 7;
	}
}