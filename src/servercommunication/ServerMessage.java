package servercommunication;

import java.io.Serializable;

public class ServerMessage implements Serializable 
{
	//This object is sent to the server.
	//The message to send to the server
	private String message;
	//The data/content to accompany the message. Should be in JSON format
	private String data;
	private String userData;
	
	public ServerMessage()
	{
		message = "None";
		data = "None";
		userData = "None";
	}
	
	/** This constructor is deprecated, DO NOT USE for any new code. Use the one which takes all 3 parameters.*/
	public ServerMessage(String message, String data)
	{
		this.message = message;
		this.data = data;
	}
	
	public ServerMessage(String message, String data, String userData)
	{
		this.message = message;
		this.data = data;
		this.userData = userData;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public void setData(String data)
	{
		this.data = data;
	}
	
	public void setUserData(String userData)
	{
		this.userData = userData;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public String getData()
	{
		return data;
	}
	
	public String getUserData()
	{
		return userData;
	}
}
