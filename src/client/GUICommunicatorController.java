package client;
import servercommunication.ServerCommunicator;
import servercommunication.ServerMessage;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class GUICommunicatorController 
{
	private ServerCommunicator communicator;
	private ServerMessage serverResult;
	private int type;
	
	public GUICommunicatorController() 
	{
		communicator = new ServerCommunicator();
		type = 1;
	}
	
	public GUICommunicatorController(String endAddress, String port) 
	{
		
		communicator = new ServerCommunicator();
		communicator.setEndpoint(endAddress);
	}
	
	public boolean LoginUser(String email, String password)
	{
		JsonObject jsonSender = new JsonObject();
		jsonSender.addProperty("email", email);
		jsonSender.addProperty("password", password);
		
		serverResult = communicator.sendServerMessage(new ServerMessage("Login", jsonSender.toString()));
		
		JsonObject credentials = new JsonParser().parse(serverResult.getData()).getAsJsonObject();
		//type = credentials.get("type").getAsInt();
		return credentials.get("isValid").getAsBoolean();
		
	}
	
	public int getUserType()
	{
		
		return type;
	}

}
