package cis3270.user;

import java.sql.*;
import cis3270.database.dbModify;

public abstract class User implements dbModify {

	/** These fields are the attributes in the User table of the database. These will also be the
	 * fields a person has to fill out when they register as a user. */
	
	private PreparedStatement preparedStatement;
	
	private String firstName;
	private String lastName;
	private String address;
	private String state;
	private int zip;
	private String email;
	private int ssn;
	private String securityQuestion;
	private String securityAnswer;
	private String username;
	private String password;
	private int admin = 0;
	
	public User() {
		
		
	}
	
	public User(String firstName, String lastName, String address, String state, int zip, String email,
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
	
	public User(String username) {
		
		setUsername(username);
		
		
	}
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}
	
	public String getFirstName() {
		
		return firstName;
		
	}
	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
		
	}
	
	public String getLastName() {
		
		return lastName;
		
	}
	
	public void setAddress(String address) {
		
		this.address = address;
		
	}
	
	public String getAddress() {
		
		return address;
		
	}

	public void setState(String state) {
		
		this.state = state;
		
	}

	public String getState() {
		
		return state;
		
	}

	public void setZip(int zip) {
		
		this.zip = zip;
		
	}
	
	public int getZip() {
		
		return zip;
		
	}
	
	public void setEmail(String email) {
		
		this.email = email;
		
	}
	
	public String getEmail() {
		
		return email;
		
	}
	
	public void setSSN(int ssn) {
		
		this.ssn = ssn;
		
	}
	
	public int getSSN() {
		
		return ssn;
		
	}
	
	public void setSecurityQuestion(String securityQuestion) {
		
		this.securityQuestion = securityQuestion;
		
	}
	
	public String getSecurityQuestion() {
		
		return securityQuestion;
		
	}
	
	public void setSecurityAnswer(String securityAnswer) {
		
		this.securityAnswer = securityAnswer;
		
	}
	
	public String getSecurityAnswer() {
		
		return securityAnswer;
		
	}
	
	public void setUsername(String username) {
		
		this.username = username;
		
	}
	
	public String getUsername() {
		
		return username;
		
	}
	
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	public String getPassword() {
		
		return password;
		
	}
	
	public void setAdmin(int admin) {
		
		this.admin = admin;
		
	}
	
	public int getAdmin() {
		
		return admin;
		
	}
	public Connection initializeDB() throws SQLException, ClassNotFoundException{
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", 
				"CIS3270", "Cis3270");
		
		return connection;
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		}
		return null;
	}
	
	public void add() throws ClassNotFoundException, SQLException {
	
		Connection connection = initializeDB();
		try{
		String queryString = "insert into User(firstName, lastName, address, zip, "
				+ "state, email, ssn, securityQuestion, securityAnswer, username, password, admin)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		preparedStatement = connection.prepareStatement(queryString);
		
		preparedStatement.setString(1, getFirstName());
		preparedStatement.setString(2, getLastName());
		preparedStatement.setString(3, getAddress());
		preparedStatement.setInt(4, getZip());
		preparedStatement.setString(5, getState());
		preparedStatement.setString(6, getEmail());
		preparedStatement.setInt(7, getSSN());
		preparedStatement.setString(8, getSecurityQuestion());
		preparedStatement.setString(9, getSecurityAnswer());
		preparedStatement.setString(10, getUsername());
		preparedStatement.setString(11, getPassword());
		preparedStatement.setInt(12, getAdmin());
		
		preparedStatement.executeUpdate();
		
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		}
	}
	
	public void delete() throws ClassNotFoundException, SQLException{
		
		initializeDB();
		
	}
	
	public void update() throws ClassNotFoundException, SQLException{
		
		initializeDB();
		
	}
}
