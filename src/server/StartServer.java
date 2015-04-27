package server;

public class StartServer 
{
	public static void main(String [] args)
	{
		try
		{
			Server server = new Server();
			server.runServer();
		}
		catch(Exception e)
		{
			//Server has crashed...
		}
	}
}
