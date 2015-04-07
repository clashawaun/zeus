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
		ServerMessage result = t.sendServerMessage(new ServerMessage("Login", "{\"email\": \"Big.Bird@gmail.com\", \"password\": \"yellow\"}"));
		System.out.println(result.getData());
	}
}
