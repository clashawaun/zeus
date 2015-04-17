package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ItemsCollectedFrame extends JFrame {

	private JPanel contentPane;
	private JTextField itemIDToBeCollectedField;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public ItemsCollectedFrame() {
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
		
		itemIDToBeCollectedField = new JTextField();
		itemIDToBeCollectedField.setText("Item ID");
		itemIDToBeCollectedField.setBounds(51, 44, 154, 39);
		contentPane.add(itemIDToBeCollectedField);
		itemIDToBeCollectedField.setColumns(10);
		
		JButton itemCollectedButton = new JButton("Item Collected");
		itemCollectedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//Listing updates and removes items that are collected.
			}
		});
		itemCollectedButton.setBounds(215, 43, 109, 40);
		contentPane.add(itemCollectedButton);
		
		JList listOfItemsToBeCollected = new JList();
		listOfItemsToBeCollected.setBounds(51, 94, 273, 128);
		contentPane.add(listOfItemsToBeCollected);
	}
}
