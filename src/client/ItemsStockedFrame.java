package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemsStockedFrame extends JFrame {

	private JPanel contentPane;
	private JTextField itemIDToBeStockedField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ItemsStockedFrame() {
		setTitle("Stocker Main Window");
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
		
		itemIDToBeStockedField = new JTextField();
		itemIDToBeStockedField.setText("Item ID");
		itemIDToBeStockedField.setBounds(65, 63, 119, 31);
		contentPane.add(itemIDToBeStockedField);
		itemIDToBeStockedField.setColumns(10);
		
		JButton itemStockedButton = new JButton("Item Stocked");
		itemStockedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Listing updates and removes items that are stocked.
			}
		});
		itemStockedButton.setBounds(194, 63, 112, 33);
		contentPane.add(itemStockedButton);
		
		JList listOfItemsToBeStocked = new JList();
		listOfItemsToBeStocked.setBounds(65, 113, 241, 95);
		contentPane.add(listOfItemsToBeStocked);
	}

}
