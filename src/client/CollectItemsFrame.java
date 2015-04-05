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

public class CollectItemsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CollectItemsFrame frame = new CollectItemsFrame();
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
	public CollectItemsFrame() {
		setTitle("Picker Main Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logOutButton = new JButton("Log Out");
		logOutButton.setBounds(335, 11, 89, 23);
		contentPane.add(logOutButton);
		
		JList listOfItemsToCollect = new JList();
		listOfItemsToCollect.setBounds(126, 100, 157, 108);
		contentPane.add(listOfItemsToCollect);
		
		JButton readyButton = new JButton("Ready");
		readyButton.setBounds(161, 219, 89, 23);
		contentPane.add(readyButton);
		
		JTextArea itemsToBeCollectedMessage = new JTextArea();
		itemsToBeCollectedMessage.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		itemsToBeCollectedMessage.setLineWrap(true);
		itemsToBeCollectedMessage.setEditable(false);
		itemsToBeCollectedMessage.setText("Items to be collected shown below.  Proceed when ready.");
		itemsToBeCollectedMessage.setBounds(65, 66, 291, 23);
		contentPane.add(itemsToBeCollectedMessage);
	}
}
