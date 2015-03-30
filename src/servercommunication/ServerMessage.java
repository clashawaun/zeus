package servercommunication;

public class ServerMessage 
{
	//The message to send to the server
	private String message;
	//The data/content to accompany the message. Should be in JSON format
	private String data;
	
	public ServerMessage()
	{
		message = "None";
		data = "None";
	}
	
	public ServerMessage(String message, String data)
	{
		this.message = message;
		this.data = data;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public void setData(String data)
	{
		this.data = data;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public String getData()
	{
		return data;
	}
}
