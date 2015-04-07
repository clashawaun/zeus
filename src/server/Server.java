package server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import coreClasses.*;
import servercommunication.*;

import com.google.gson.Gson;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//Needs the server message object
public class Server implements I_Server
{
	//Needs more atts, will come up with whats needed during implementation!
	private ServerTools serverTools;
	private Map<String, Command> messageFunctionMap;
	public Server()
	{
		messageFunctionMap = new HashMap<String, Command>();
		buildMessageFunctionMap();
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
                		System.out.println("oh oh :(");
                	}
                	finally
                	{
                		
                	}
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
		messageFunctionMap.put("Register", new Command() {public ServerMessage runCommand(ServerMessage m) {return register(m);}});
		messageFunctionMap.put("PickerItemRequest", new Command() {public ServerMessage runCommand(ServerMessage m) {return assignPickerItems(m);}});
	}
	
	private ServerMessage login(ServerMessage message)
	{
		//handles login events
		return new ServerMessage("It", "Worked");
	}
	
	private ServerMessage register(ServerMessage message)
	{
		return new ServerMessage("It", "Worked");
	}
	
	private ServerMessage assignPickerItems(ServerMessage message)
	{
		return new ServerMessage("It", "Worked");
	}
	
	/*public ServerMessage processServerMessage(ServerMessage msg)
	{
		
	}*/
}
