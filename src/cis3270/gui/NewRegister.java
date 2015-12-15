package cis3270.gui; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cis3270.user.User;
 /**
  * this is the form for new users
  * @author xakai77x
  *
  */
public class NewRegister extends User {
		
	public JFrame newReg;
	private JLabel firstName = new JLabel("First Name: ");
	private JLabel lastName = new JLabel("Last Name: ");
	private JLabel address = new JLabel("Address: ");
	private JLabel zip = new JLabel("Zip: ");
	private JLabel state = new JLabel("State: ");
	private JLabel email = new JLabel("Email: ");
	private JLabel ssn = new JLabel("SSN: ");
	private JLabel securityQuestion = new JLabel("Security Question: ");
	private JLabel securityAnswer = new JLabel("Security Answer: ");
	private JLabel username = new JLabel("Username: ");
	private JLabel password = new JLabel("Password: ");
	private JLabel admin = new JLabel("Enter first name: ");
	
	private JTextField enterFName = new JTextField();	
	private JTextField enterLName = new JTextField();
	private JTextField enterAddress = new JTextField();
	private JTextField enterZip = new JTextField();
	private JTextField enterState = new JTextField();
	private JTextField enterEmail = new JTextField();
	private JTextField enterSSN = new JTextField();
	private JTextField enterQuestion = new JTextField();
	private JTextField enterAnswer = new JTextField();
	private JTextField enterUsername = new JTextField();
	private JTextField enterPassword = new JTextField();
	
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
		
		newReg.add(firstName);
		newReg.add(enterFName);
		newReg.add(lastName);
		newReg.add(enterLName);
		newReg.add(address);
		newReg.add(enterAddress);
		newReg.add(zip);
		newReg.add(enterZip);
		newReg.add(state);
		newReg.add(enterState);
		newReg.add(email);
		newReg.add(enterEmail);
		newReg.add(ssn);
		newReg.add(enterSSN);
		newReg.add(securityQuestion);
		newReg.add(enterQuestion);
		newReg.add(securityAnswer);
		newReg.add(enterAnswer);
		newReg.add(username);
		newReg.add(enterUsername);
		newReg.add(password);
		newReg.add(enterPassword);
		
		JButton setRegister = new JButton("OK");
		setRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//the user can request his or her password with this button
			}
		});
		newReg.getContentPane().add(setRegister);
		
		JButton cancelRegister = new JButton("Cancel");
		cancelRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//the user can request his or her password with this button
			}
		});
		newReg.getContentPane().add(cancelRegister);
	
	
	
	
	}

}


