import java.io.IOException;

import server.Server;


public class test {

	public static void main(String args[])  {
		Server server =  new Server();
		
		try {
			server.runServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}