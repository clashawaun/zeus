package servercommunication;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ServerCommunicator 
{
	//This class will be used to open a connection to the server.
	//Will be used to transmit server messages;
	
	private Socket serverSocket;
	private String endpoint;
	private int port;
	
	//For the purposes of this project the default constructor should be used.
	public ServerCommunicator()
	{
		autoServerSelection();
	}
	public ServerCommunicator(String endpoint)
	{
		this.endpoint = endpoint;
		this.port = 9090;
	}
	public ServerCommunicator(String endpoint, int port)
	{
		this.endpoint = endpoint;
		this.port = port;
	}
	
	private boolean openServerConnection()
	{
		try
		{
			serverSocket = new Socket(endpoint, port);
			return true;
		}
		catch (Exception e) 
		{
			//DELETE ME For final version and add error handling
			System.out.println("Error - Failed to connect to the server. Is it online ?");
			return false;
		}
	}
	
	/** Use this function if you want the Zeus Server Selector to determine the best server to connect to*/
	public void autoServerSelection()
	{
		try
		{
			//URL to the server Selector service
			URL serverSelector = new URL("http://zeus.shanecraven.info/zeus_software/what_server.aspx");
			URLConnection connection = serverSelector.openConnection();
			//Read the JSON returned from the service
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			JsonObject selectedServer = new JsonParser().parse(in.readLine()).getAsJsonObject();
			//Set the endpoint and port based on data returned from the service
			setEndpoint(selectedServer.get("endpoint").getAsString());
			setPort(selectedServer.get("port").getAsInt());
			//TODO: Debug Message, remove before finished version
			System.out.println("The selected info was: endpoint=" + selectedServer.get("endpoint").getAsString() + ", port=" + selectedServer.get("port").getAsInt());
		}
		catch(Exception e)
		{
			//Failed to auto select, lets use defaults in this case
			setEndpoint("104.236.24.208");
			setPort(9090);
			//TODO: debug message, remove before finished version
			System.out.println("Defaults used");
		}
	}
	
	public String getEndpoint()
	{
		return endpoint;
	}
	
	public void setEndpoint(String endpoint)
	{
		this.endpoint = endpoint;
	}
	
	public void setPort(int port)
	{
		this.port = port;
	}
	
	public int getPort()
	{
		return port;
	}
	public ServerMessage sendServerMessage(ServerMessage serverMessage)
	{
		ServerMessage response = null;
		try
		{
			if(openServerConnection())
			{
				ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());
				out.writeObject(serverMessage);
				response = (ServerMessage) in.readObject();
				//Debug message
				System.out.println("This was returned from server: Message=" + response.getMessage() + "," + "Data=" + response.getData());
				
			}
			else
			{
				throw new Exception("Failed to open Connection to server");
			}
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong :( , " + e.toString());
		}
		return response;
	}
}
	

