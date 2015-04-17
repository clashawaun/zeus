package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CollectItemsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CollectItemsFrame() {
		setTitle("Picker Main Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logOutButton = new JButton("Log Out");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIManager.changeFrame(new LogOutFrame());
			}
		});
		logOutButton.setBounds(335, 11, 89, 23);
		contentPane.add(logOutButton);
		
		JList listOfItemsToCollect = new JList();
		listOfItemsToCollect.setBounds(126, 100, 157, 108);
		contentPane.add(listOfItemsToCollect);
		
		JButton readyToCollectButton = new JButton("Ready");
		readyToCollectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIManager.changeFrame(new ItemsCollectedFrame());
			}
		});
		readyToCollectButton.setBounds(161, 219, 89, 23);
		contentPane.add(readyToCollectButton);
		
		JTextArea itemsToBeCollectedMessage = new JTextArea();
		itemsToBeCollectedMessage.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		itemsToBeCollectedMessage.setLineWrap(true);
		itemsToBeCollectedMessage.setEditable(false);
		itemsToBeCollectedMessage.setText("Items to be collected shown below.  Proceed when ready.");
		itemsToBeCollectedMessage.setBounds(65, 66, 291, 23);
		contentPane.add(itemsToBeCollectedMessage);
	}
}
