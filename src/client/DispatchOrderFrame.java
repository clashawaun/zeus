package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class DispatchOrderFrame extends JFrame {

	private JPanel contentPane;
	private JTextField itemIDToBeDispatched;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DispatchOrderFrame frame = new DispatchOrderFrame();
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
	public DispatchOrderFrame() {
		setTitle("Packer Main Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		itemIDToBeDispatched = new JTextField();
		itemIDToBeDispatched.setText("Item ID");
		itemIDToBeDispatched.setBounds(31, 74, 122, 54);
		contentPane.add(itemIDToBeDispatched);
		itemIDToBeDispatched.setColumns(10);
		
		JButton searchForOrderButton = new JButton("Search For Order");
		searchForOrderButton.setBounds(193, 74, 122, 23);
		contentPane.add(searchForOrderButton);
		
		JButton disptachOrderButton = new JButton("Dispatch Order");
		disptachOrderButton.setBounds(193, 105, 122, 23);
		contentPane.add(disptachOrderButton);
		
		JTextArea orderShipped = new JTextArea();
		orderShipped.setText("Order Shipped");
		orderShipped.setBounds(31, 179, 108, 23);
		contentPane.add(orderShipped);
		
		JButton logOutButton = new JButton("Log Out");
		logOutButton.setBounds(335, 11, 89, 23);
		contentPane.add(logOutButton);
	}

}
