import java.io.IOException;

import server.Server;


public class RunServer {

	public static void main(String args[])throws Exception  {
		Server server =  new Server();
		
		try {
			server.runServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
