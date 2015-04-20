package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchForProductFrame extends JFrame {

	private JPanel contentPane;
	private JTextField productToSearch;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SearchForProductFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton logOutButton = new JButton("Log Out");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIManager.getGCC().logOut();
				GUIManager.changeFrame(new LogOutFrame());
			}
		});
		
		logOutButton.setBounds(335, 11, 89, 23);
		contentPane.add(logOutButton);
		
		productToSearch = new JTextField();
		productToSearch.setText("Product Name");
		productToSearch.setBounds(40, 63, 161, 51);
		contentPane.add(productToSearch);
		productToSearch.setColumns(10);
		
		JButton searchForOrderButton = new JButton("Search Product");
		searchForOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Searches information on database
			}
		});
		
		searchForOrderButton.setBounds(211, 62, 133, 23);
		contentPane.add(searchForOrderButton);
		
		JButton stockItemsFrameButton = new JButton("Stock Items");
		stockItemsFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIManager.changeFrame(new StockItemsFrame());
			}
		});
		
		stockItemsFrameButton.setBounds(10, 11, 130, 23);
		contentPane.add(stockItemsFrameButton);
		
		JButton returnHomeButton = new JButton("Generate Item ID");
		returnHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIManager.changeFrame(new GenerateItemIDFrame());
			}
		});
	}

}
