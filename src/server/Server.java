package server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import servercommunication.*;

import java.util.Date;


//Needs the server message object
public class Server implements I_Server
{
	//Needs more atts, will come up with whats needed during implementation!
	private ServerTools serverTools;
	public Server()
	{

	}
	
	public void runServer() throws IOException
	{
		ServerSocket listener = new ServerSocket(9090);
        try 
        {
            while (true) 
            {
                Socket socket = listener.accept();
                try 
                {
                	ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                	ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
                	try
                	{
                		//Code to test communication between client and server.
                		ServerMessage m = (ServerMessage) in.readObject();
                		System.out.println("This was sent from client: Message=" + m.getMessage() + "," + "Data=" + m.getData());
                		m.setMessage("hi");
                		m.setData("there from server");
                		outToServer.writeObject(m);
                		//PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                		//out.println(new Date().toString() + "  ------> Kevin and Cian are very bold");
                	}
                	catch(Exception e)
                	{
                		System.out.println("oh oh :(");
                	}
                	finally
                	{
                		
                	}
                } 
                finally 
                {
                    socket.close();
                }
            }
        }
        finally 
        {
            listener.close();
        }
	}
	
	/*public ServerMessage processServerMessage(ServerMessage msg)
	{
		
	}*/
}
