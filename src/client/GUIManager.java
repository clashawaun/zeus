package client;

import javax.swing.JFrame;


public class GUIManager 
{
	private static JFrame aFrame;
	
	public static void init()
	{
		GUICommunicatorController GCC = new GUICommunicatorController();
		aFrame = new LogInFrame();
		aFrame.setVisible(true);
		((LogInFrame) aFrame).addGUICommunicationController(GCC);
	}
	
	public static void changeFrame(JFrame bFrame)
	{
		aFrame.dispose();
		aFrame = bFrame;
		aFrame.setVisible(true);
		
	}
	
}
