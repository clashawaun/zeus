import java.io.IOException;

import server.Server;
import servercommunication.*;
import coreClasses.*;

import com.google.gson.Gson;

public class Temp 
{
	public static void main(String [] args)
	{

		ServerCommunicator t = new ServerCommunicator();
		ServerMessage m = t.sendServerMessage(new ServerMessage("Login", "{\"email\": \"big.bird@gmail.com\", \"password\": \"yellow\"}"));
		ServerMessage result = t.sendServerMessage(m);
		System.out.println(result.toString());
	}
}
