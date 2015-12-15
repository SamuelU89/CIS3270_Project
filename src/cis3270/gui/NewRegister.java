package cis3270.gui; 
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import cis3270.user.Customer;
import cis3270.user.User;
 /**
  * this is the form for new users
  * @author xakai77x
  *
  */
public class NewRegister extends JFrame {
		
	public JFrame newReg;
	private JLabel firstName, lastName, address, zip, state, email, ssn, 
		securityQuestion, securityAnswer, username, password, admin;
	private JTextField enterFName, enterLName, enterAddress, enterZip, enterState, enterEmail, enterSSN, 
		enterQuestion, enterAnswer, enterUsername, enterPassword;
	private JButton setRegister, cancelRegister;
	JPanel p1, p2;
	GridLayout g1, g2;
	BorderLayout b1;
	FlowLayout f1;
	
	public NewRegister() {
		initialize();
	}
	
	private void initialize() {
		
		newReg = new JFrame();
		newReg.setSize(1000, 800);
		newReg.setResizable(false);
		newReg.setLocationRelativeTo(null);
		newReg.setVisible(true);
		newReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		firstName = new JLabel("First Name: ");
		lastName = new JLabel("Last Name: ");
		address = new JLabel("Address");
		zip = new JLabel("Zip");
		state = new JLabel("State"); 
		email = new JLabel("Email");
		ssn = new JLabel("SSN"); 
		securityQuestion = new JLabel ("Security Question");
		securityAnswer = new JLabel("Security Answer"); 
		username = new JLabel("Username"); 
		password = new JLabel("Password"); 
		admin = new JLabel("Admin");
		
		enterFName = new JTextField();
		enterLName = new JTextField();
		enterAddress = new JTextField();
		enterZip = new JTextField();
		enterState = new JTextField();
		enterEmail = new JTextField();
		enterSSN = new JTextField();
		enterQuestion = new JTextField();
		enterAnswer = new JTextField();
		enterUsername = new JTextField();
		enterPassword = new JTextField();
		
		setRegister = new JButton("Register");
		cancelRegister = new JButton("Cancel");
		
		p1 = new JPanel();
		p2 = new JPanel();
		
		g1 = new GridLayout(22,1);
		g2 = new GridLayout(1,1);
		
		b1 = new BorderLayout();
		
		f1 = new FlowLayout();
		
		p1.setLayout(g1);
		p1.add(firstName);
		p1.add(enterFName);
		p1.add(lastName);
		p1.add(enterLName);
		p1.add(address);
		p1.add(enterAddress);
		p1.add(zip);
		p1.add(enterZip);
		p1.add(state);
		p1.add(enterState);
		p1.add(email);
		p1.add(enterEmail);
		p1.add(ssn);
		p1.add(enterSSN);
		p1.add(securityQuestion);
		p1.add(enterQuestion);
		p1.add(securityAnswer);
		p1.add(enterAnswer);
		p1.add(username);
		p1.add(enterUsername);
		p1.add(password);
		p1.add(enterPassword);
		
		p2.setLayout(g2);
		
		p2.add(setRegister);
		setRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Customer c1 = new Customer(enterFName.getText(), enterLName.getText(), enterAddress.getText(), enterState.getText(), Integer.parseInt(enterZip.getText()), 
						enterEmail.getText(), Integer.parseInt(enterSSN.getText()), enterQuestion.getText(), enterAnswer.getText(), enterUsername.getText(), enterPassword.getText(), 0);
				
				try {
					
					c1.add();
					
				} catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "Error");
					ex.printStackTrace();
					
				}
				
			}
		});
		newReg.getContentPane().add(setRegister);
		
		p2.add(cancelRegister);
		cancelRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login window;
				
				try {
				/**
				 * This is running the Login page from cis3270.gui.Login;
				 */
					window = new Login();
					window.frame.setVisible(true);
					newReg.setVisible(false);
				
				} catch (Exception ex) {
					ex.printStackTrace();
					
				}	
				
			}
		});
		newReg.getContentPane().add(cancelRegister);
		
		newReg.setLayout(g2);
		newReg.add(p1, BorderLayout.NORTH);
		newReg.add(p2, BorderLayout.SOUTH);
		newReg.setSize(1000,800);
		newReg.setVisible(true);
		
		
		
		
	
	
	
	
	}

}


