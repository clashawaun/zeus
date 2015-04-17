package client;

import javax.swing.JFrame;


public class GUIManager 
{
	private static JFrame aFrame;
	private static GUICommunicatorController GCC;
	
	public static void init()
	{
		GCC = new GUICommunicatorController();
		aFrame = new LogInFrame();
		aFrame.setVisible(true);
	}
	
	public static GUICommunicatorController getGCC()
	{
		return GCC;
	}
	
	public static void changeFrame(JFrame bFrame)
	{
		aFrame.dispose();
		aFrame = bFrame;
		aFrame.setVisible(true);
		
	}
	
}
