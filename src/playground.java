import sun.net.www.content.image.gif;
import client.GUICommunicatorController;


public class playground {
	
	
	public static void main(String args[])
	{
	
		GUICommunicatorController GCC = new GUICommunicatorController();
		GCC.LoginUser("picker", "1234");
		GCC.collectItem(2);
		//System.out.println(GCC.collectItem(2));
	}
}
