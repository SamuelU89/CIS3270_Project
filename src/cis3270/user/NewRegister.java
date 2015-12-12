package cis3270.user; 
import javax.swing.*;

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
		
	}
	
}


