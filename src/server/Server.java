package server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import coreClasses.*;
import servercommunication.*;
import database.Database;
import database.I_Database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Needs the server message object
public class Server implements I_Server
{
	//Needs more atts, will come up with whats needed during implementation!
	private ServerTools serverTools;
	private Map<String, Command> messageFunctionMap;
	private I_Database database;
	private Gson gson;
	//Refactor exception handling.
	public Server()throws Exception
	{
		messageFunctionMap = new HashMap<String, Command>();
		buildMessageFunctionMap();
		database = new Database();
		serverTools = new ServerTools(database);
		setUpSectorTools();
	}
	
	public void runServer() throws IOException
	{
		ServerSocket listener = new ServerSocket(9090);
        try 
        {
            while (true) 
            {
                Socket socket = listener.accept();
                try 
                {
                	ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                	ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
                	try
                	{
                		//Get the ServerMessage object passed from the client
                		ServerMessage incomingMessage = (ServerMessage) in.readObject();
                		//Debug Message, remove before shipping
                		System.out.println("This was sent from client: Message=" + incomingMessage.getMessage() + "," + "Data=" + incomingMessage.getData());
                		//Using the command design pattern, we can execute necessary logic in a single call.
                		ServerMessage outgoingMessage = messageFunctionMap.get(incomingMessage.getMessage()).runCommand(incomingMessage);
                		//Return the result to the client.
                		outToServer.writeObject(outgoingMessage);
                	}
                	catch(Exception e)
                	{
                		System.out.println("oh oh :( " + e.toString());
                		e.printStackTrace();
                	}
                	finally
                	{
                		
                	}
                } 
                catch(Exception e)
                {
                	//Bad request or Zeus Server Selector checking if server is alive.
                }
                finally 
                {
                    socket.close();
                }
            }
        }
        finally 
        {
            listener.close();
        }
	}
	
	public void buildMessageFunctionMap()
	{
		/*Command Design Pattern
		  Allows us to map functions to messages here so no change needs to be made to the incoming system.
		  All the server needs to know is that using the command interface it passes the server message object
		  it receives from the client to the contained function and then it gets a server message object back to 
		  respond with. Allows for easy expansion of server side framework and adding of functions with no changes 
		  to pre-existing architecture.
		*/
		messageFunctionMap.put("Login", new Command() {public ServerMessage runCommand(ServerMessage m) {return login(m);}});
		messageFunctionMap.put("RegisterUser", new Command() {public ServerMessage runCommand(ServerMessage m) {return register(m);}});
		messageFunctionMap.put("NewOrder", new Command() {public ServerMessage runCommand(ServerMessage m) {return processIncomingOrder(m);}});
		messageFunctionMap.put("AssignItemsToPicker", new Command() {public ServerMessage runCommand(ServerMessage m) {return assignPickerItems(m);}});
	}
	
	private void setUpSectorTools()
	{
		ArrayList<I_Sector> sectors = database.getAllSectors();
		for(I_Sector sector : sectors)
		{
			serverTools.addSectorTool(new SectorTools(sector));
		}
	}
	
	private ServerMessage login(ServerMessage message)
	{
		JsonObject result = new JsonObject();
		result.addProperty("isValid", authenticate(message.getData()));
		return new ServerMessage(message.getMessage()+"Result", result.toString());		
	}
	
	private ServerMessage register(ServerMessage message)
	{
		return new ServerMessage("It", "Worked");
	}
	
	private ServerMessage assignPickerItems(ServerMessage message)
	{
		if (!authenticate(message.getUserData()))
			return new ServerMessage(message.getMessage() + "Result", "Invalid Credentials");
		
		
	}
	
	private ServerMessage processIncomingOrder(ServerMessage message)
	{
		JsonObject orderData = new JsonParser().parse(message.getData()).getAsJsonObject();
		JsonArray jsonArray =  orderData.get("productIDs").getAsJsonArray();
		ArrayList<Integer> productIDs = new ArrayList<Integer>();
		for(JsonElement ID : jsonArray)
		{
			productIDs.add(ID.getAsInt());
		}
		JsonObject result = new JsonObject();
		result.addProperty("isSubmitted", serverTools.processNewOrder(database.registerOrder(productIDs, orderData.get("shippingAddress").getAsString())));
		return new ServerMessage("NewOrderResult", result.toString());
	}
		
	private boolean authenticate(String userData)
	{
		//Convert the userData JSON string in a JsonObject 
		JsonObject credentials = new JsonParser().parse(userData).getAsJsonObject();
		//Return the result of isValidLogin where true denotes a valid set of credentials.
		return database.isValidLogin(credentials.get("email").getAsString(), credentials.get("password").getAsString());
	}
	
	/*public ServerMessage processServerMessage(ServerMessage msg)
	{
		
	}*/
}
