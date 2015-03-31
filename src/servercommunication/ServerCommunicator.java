package servercommunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class ServerCommunicator 
{
	//This class will be used to open a connection to the server.
	//Will be used to transmit server messages;
	
	private Socket serverSocket;
	private String endpoint;
	
	public ServerCommunicator()
	{
		//Hardcode in server address for the moment.
		try
		{
			serverSocket = new Socket("104.236.24.208", 9090);
		}
		catch (Exception e) 
		{
			//DELETE ME For final version and add error handling
			System.out.println("Error - Failed to connect to the server. Is it online ?");
		}
	}
	
	public boolean openServerConnection()
	{
		//!!this will open the socket, need endpoint before adding code;
		//serverSocket.connect(endpoint, timeout);
		return false;
	}
	
	public String getEndpoint()
	{
		return endpoint;
	}
	
	public void setEndpoint(String endpoint)
	{
		this.endpoint = endpoint;
	}
	
	public ServerMessage sendServerMessage(ServerMessage serverMessage)
	{
		ServerMessage response = null;
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());
			out.writeObject(serverMessage);
			response = (ServerMessage) in.readObject();
			//Debug message
			System.out.println("This was returned from server: Message=" + response.getMessage() + "," + "Data=" + response.getData());
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong :( , " + e.toString());
		}
		return response;
	}
}
	

