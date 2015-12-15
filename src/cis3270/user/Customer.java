package cis3270.user;

public class Customer extends User {
	
	public Customer(){
		
		super();
		
	};

	public Customer(String firstName, String lastName, String address, String state, int zip, String email,
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
	
	public Customer(String username) {
		
		super(username);
		
		
	}
}
