package client;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	JButton logInButton;
	GUICommunicatorController GCC;

	/**
	 * Create the frame.
	 */
	public LogInFrame() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setText("Username");
		usernameField.setBounds(171, 95, 86, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 126, 86, 20);
		contentPane.add(passwordField);
		
		logInButton = new JButton("Log In");
		logInButton.setBounds(171, 157, 89, 23);
		contentPane.add(logInButton);
		
		logInButton.addActionListener(this);
		
		GCC = null;
	}

	public void addGUICommunicationController(GUICommunicatorController GCC)
	{
		this.GCC = GCC;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (GCC != null)
		{
			if (GCC.LoginUser(usernameField.getText(), new String(passwordField.getPassword())))
			{
				switch(GCC.getUserType())
				{
					case 1 :  //Picker
						System.out.println("I am in switch state ment");
						ItemsCollectedFrame aFrame = new ItemsCollectedFrame();
						aFrame.setVisible(true);
						break;
					case 2 :  //Packer
						
						break;
					case 3 :  //Manager
						
						break;
					case 4 :  //Stocker
						
						break;
						
					default: 
						break;
				}
				
			}
			
		}
		
		
	}
}
