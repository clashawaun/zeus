package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JList;

public class StockItemsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockItemsFrame frame = new StockItemsFrame();
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
	public StockItemsFrame() {
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
		
		JButton generateItemIDButton = new JButton("Generate Item ID");
		generateItemIDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		generateItemIDButton.setBounds(114, 11, 130, 23);
		contentPane.add(generateItemIDButton);
		
		JTextArea txtrItemsToBe = new JTextArea();
		txtrItemsToBe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		txtrItemsToBe.setText("Items to be stocked below. Proceed when ready.");
		txtrItemsToBe.setBounds(82, 58, 242, 23);
		contentPane.add(txtrItemsToBe);
		
		JList listOfItemsToStock = new JList();
		listOfItemsToStock.setBounds(82, 92, 242, 112);
		contentPane.add(listOfItemsToStock);
		
		JButton readyButton = new JButton("Ready");
		readyButton.setBounds(155, 215, 89, 23);
		contentPane.add(readyButton);
	}
}
