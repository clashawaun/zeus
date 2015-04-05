package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class SearchForOrderFrame extends JFrame {

	private JPanel contentPane;
	private JTextField itemIDToSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchForOrderFrame frame = new SearchForOrderFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchForOrderFrame() {
		setTitle("Packer Main Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logOutButton = new JButton("Log Out");
		logOutButton.setBounds(335, 11, 89, 23);
		contentPane.add(logOutButton);
		
		itemIDToSearch = new JTextField();
		itemIDToSearch.setText("Item ID");
		itemIDToSearch.setBounds(40, 63, 161, 51);
		contentPane.add(itemIDToSearch);
		itemIDToSearch.setColumns(10);
		
		JButton searchForOrderButton = new JButton("Search For Order");
		searchForOrderButton.setBounds(211, 62, 133, 23);
		contentPane.add(searchForOrderButton);
		
		JButton printAddressButton = new JButton("Print Address");
		printAddressButton.setBounds(211, 153, 133, 23);
		contentPane.add(printAddressButton);
		
		JTextArea orderIDDetails = new JTextArea();
		orderIDDetails.setBounds(40, 152, 161, 72);
		contentPane.add(orderIDDetails);
		
		JButton dispatchOrderButton = new JButton("Dispatch Order");
		dispatchOrderButton.setBounds(211, 91, 133, 23);
		contentPane.add(dispatchOrderButton);
	}

}
