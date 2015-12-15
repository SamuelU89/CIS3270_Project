package cis3270.user;

public class Administrator extends Customer {
	
	public Administrator() {}
		
		/**
		 * This class will have the method to add and update flights moved from the Flight page found it cis3270.Flight
		 * @Samuel U
		 * 
		 * 
		 * 
		 */
		
	public Administrator(String firstName, String lastName, String address, String state, int zip, String email,
			int ssn, String securityQuestion, String securityAnswer, String username, String password, int admin) {

		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setState(state);
		setZip(zip);
		setEmail(email);
		setSSN(ssn);
		setSecurityQuestion(securityQuestion);
		setSecurityAnswer(securityAnswer);
		setUsername(username);
		setPassword(password);
		setAdmin(admin);
		
	}
	
	public Administrator (String username) {
		
		super(username);
		
		
	}
	
	
}
	
	
	


