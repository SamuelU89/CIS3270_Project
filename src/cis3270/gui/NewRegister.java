package cis3270.gui; 
import javax.swing.*;

import cis3270.user.User;

public class NewRegister extends User {
	public static void main(String[] args) {
		
		// Creates a button that says "OK"
		JButton jbtOK = new JButton("OK");
		
		// Creates a button that says "Cancel"
		JButton jbtCancel = new JButton("Cancel");
		
		//Creates a label for first name
		JLabel jlblFirstName = new JLabel("Enter first name: ");
		
		//Creates a text box for first name
		JTextField jtfFirstName = new JTextField("Type First Name Here");
		
		// Creates a label for last name
		JLabel jlblLastName = new JLabel("Enter last name: ");
		
		// Creates a text box for first name
		JTextField jtfLastName = new JTextField("Type Last Name Here");
		
		// Creates a label for address
		JLabel jlblAddress = new JLabel("Enter address: ");
				
		// Creates a text box for first name
		JTextField jtfAddress = new JTextField("Type Address Here");
		
		// Creates a label for state
		JLabel jlblState = new JLabel("Enter State: ");
						
		// Creates a text box for first name
		JTextField jtfState = new JTextField("Type State Here");
		
		// Creates a label for Zip Code
		JLabel jlblZipCode = new JLabel("Enter Zip code: ");
						
		// Creates a text box for Zip Code
		JTextField jtfZipCode = new JTextField("Type Zip Code Here");
		
		// Creates a label for email
		JLabel jlblEmail = new JLabel("Enter Email: ");
						
		// Creates a text box for first name
		JTextField jtfEmail = new JTextField("Type Email Here");
		
		// Creates a label for ssn
		JLabel jlblSsn = new JLabel("Enter SSN: ");
						
		// Creates a text box for SSN
		JTextField jtfSsn = new JTextField("Type SSN Here");
		
		// Creates a label for Security Question
		JLabel jlblSecurityQuestion = new JLabel("Enter Security Question: ");
						
		// Creates a text box for Security Question
		JTextField jtfSecurityQuestion = new JTextField("Type Security Question Here");
		
		// Creates a label for Security Answer
		JLabel jlblSecurityAnswer = new JLabel("Enter Security Answer: ");
						
		// Creates a text box for first name
		JTextField jtfSecurityAnswer = new JTextField("Type Security Answer Here");
		
		// Creates a label for username
		JLabel jlblUsername = new JLabel("Enter Username: ");
						
		// Creates a text box for username
		JTextField jtfUsername= new JTextField("Type Username Here");
		
		// Creates a label for password
		JLabel jlblPassword = new JLabel("Enter Password: ");
						
		// Creates a text box for password
		JTextField jtfPassword = new JTextField("Type Password Here");
		
	}
	
}


