package servercommunication;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerCommunicator 
{
	//This class will be used to open a connection to the server.
	//Will be used to transmit server messages;
	
	private Socket serverSocket;
	private ObjectOutputStream out;
	private String endpoint;
	
	public ServerCommunicator()
	{
		serverSocket = new Socket();
		//Shane - need to add logic that will connect to server when its online.
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
		//This code will send the server message object in the stream. Need to have 
		ServerMessage delete_me = new ServerMessage();
		//out.writeObject(delete_me);
		return delete_me;

	}
	
}
