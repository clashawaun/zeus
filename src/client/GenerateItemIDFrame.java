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

public class GenerateItemIDFrame extends JFrame {

	private JPanel contentPane;
	private JTextField productIDField;
	private JTextField manufactureDateField;
	private JTextField expiryDateField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateItemIDFrame frame = new GenerateItemIDFrame();
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
	public GenerateItemIDFrame() {
		setTitle("Stocker Main Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logOutButton = new JButton("Log Out");
		logOutButton.setBounds(335, 11, 89, 23);
		contentPane.add(logOutButton);
		
		productIDField = new JTextField();
		productIDField.setText("Product ID");
		productIDField.setBounds(134, 85, 129, 20);
		contentPane.add(productIDField);
		productIDField.setColumns(10);
		
		manufactureDateField = new JTextField();
		manufactureDateField.setText("Manufacture Date");
		manufactureDateField.setBounds(134, 116, 129, 20);
		contentPane.add(manufactureDateField);
		manufactureDateField.setColumns(10);
		
		expiryDateField = new JTextField();
		expiryDateField.setText("Expiry Date");
		expiryDateField.setBounds(134, 147, 129, 20);
		contentPane.add(expiryDateField);
		expiryDateField.setColumns(10);
		
		JButton generateItemIDButton = new JButton("Generate Item ID");
		generateItemIDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		generateItemIDButton.setBounds(134, 187, 129, 23);
		contentPane.add(generateItemIDButton);
		
		JButton stockItemsFrameButton = new JButton("Stock Items");
		stockItemsFrameButton.setBounds(10, 11, 129, 23);
		contentPane.add(stockItemsFrameButton);
	}

}
