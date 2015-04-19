package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;

public class StockItemsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public StockItemsFrame() {
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
				GUIManager.getGCC().logOut();
				GUIManager.changeFrame(new LogOutFrame());
			}
		});
		logOutButton.setBounds(335, 11, 89, 23);
		contentPane.add(logOutButton);
		
		JButton generateItemIDButton = new JButton("Generate Item ID");
		generateItemIDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIManager.changeFrame(new GenerateItemIDFrame());
			}
		});
		
		generateItemIDButton.setBounds(114, 11, 130, 23);
		contentPane.add(generateItemIDButton);
		
		JTextArea txtrItemsToBe = new JTextArea();
		txtrItemsToBe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		txtrItemsToBe.setText("Items to be stocked below. Proceed when ready.");
		txtrItemsToBe.setBounds(82, 58, 242, 23);
		contentPane.add(txtrItemsToBe);
		
		DefaultListModel <String> aListModel = new DefaultListModel <String>();
		ArrayList<String> aArrayItemList = GUIManager.getGCC().getStockerCurrentBasket();
		JList <String> listOfItemsToStock = new JList<String>();
		
		for (String temp : aArrayItemList) 
		 {
		        aListModel.addElement(temp);
		 }
		
		listOfItemsToStock.setModel(aListModel);
		
		listOfItemsToStock.setBounds(82, 92, 242, 112);
		contentPane.add(listOfItemsToStock);
		
		
		
		JButton readyToStockButton = new JButton("Ready");
		readyToStockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIManager.changeFrame(new ItemsStockedFrame());
			}
		});
		readyToStockButton.setBounds(155, 215, 89, 23);
		contentPane.add(readyToStockButton);
	}
}
