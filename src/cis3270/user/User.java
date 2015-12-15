package cis3270.user;

import java.sql.*;

import javax.swing.JOptionPane;

import cis3270.database.dbModify;
import cis3270.flight.Flight;
import cis3270.flight.Plane;

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
	
	public void getInformation() throws SQLException, ClassNotFoundException{
		
		Connection connection = initializeDB();
		try{
			
		Statement statement = connection.createStatement();
		
		String queryString = "select firstName, lastName, address, zip, "
				+ "state, email, ssn, securityQuestion, securityAnswer, username, password, admin" 
				+ " from User"
				+ " where username = '" + getUsername() + "'";
		
		ResultSet rs = statement.executeQuery(queryString);
		
		if (!rs.next()) {
			
			//JOptionPane.showMessageDialog(null, "Invalid Login", "Error", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			
			setFirstName(rs.getString(1));
			setLastName(rs.getString(2));
			setAddress(rs.getString(3));
			setZip(rs.getInt(4));
			setState(rs.getString(5));
			setEmail(rs.getString(6));
			setSSN(rs.getInt(7));
			setSecurityQuestion(rs.getString(8));
			setSecurityAnswer(rs.getString(9));
			setPassword(rs.getString(11));
			setAdmin(rs.getInt(12));
			
		}
		
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		} finally {
			
			connection.close();
			
		}
		
	}
	
	public Connection initializeDB() throws SQLException, ClassNotFoundException{
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", 
				"CIS3270", "Cis3270");
		
		System.out.println("Connection complete");
		return connection;
		} catch(SQLException ex){
			
			ex.printStackTrace();
			
		} catch(Exception ex) {
			
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
		
		} catch(SQLException ex){
			
			ex.printStackTrace();
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
			
		} finally {
			
			connection.close();
			
		}
		
	}
	
	public String getFlight() throws ClassNotFoundException, SQLException {
		
		String labelText = "<html>";
		Connection connection = initializeDB();
		try{
			
			Statement statement = connection.createStatement();
			
			String queryString = "select b.planeNum, b.airlineName, a.flightFrom, a.flightTo, a.flightDeparture, a.flightArrival, b.capacity " 
					+ "from flight a left join plane b "
					+ " on a.idPlane = b.idPlane "
					+ " right join reserve c "
					+ " on a.idFlight = c.idFlight "
					+ " where c.username = '" + getUsername() +"'";
			
			ResultSet rs = statement.executeQuery(queryString);
			
			while(rs.next()) {
				
				
				labelText = labelText + rs.getString(1) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5)
						+ " " + rs.getString(6) + " " + rs.getString(7) + "<br>";
			}
		
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		} finally {
			
			connection.close();
			
		}
		labelText = labelText + "</HTML>";
		return labelText;
	}
	
	public void bookFlight(int idFlight) throws SQLException, ClassNotFoundException {
		Flight book = new Flight(idFlight);
		book.getInformation();
		
		int capacity = Plane.getCapacity(book.getIdPlane());
		
		Connection connection = initializeDB();
		
		int bookedFlights = 0;
		try{
			
			Statement statement = connection.createStatement();
			
			String queryString = "select count(*) "
					+ " from reserve "
					+ " where idFlight = '" + book.getIdFlight() +"'";
			
			ResultSet rs = statement.executeQuery(queryString);
			
			if(rs.next()) {
				
				bookedFlights = rs.getInt(1);

			}
		
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		} finally {
			
			connection.close();
			
		}
		/** This check overcapacity */
		if (bookedFlights > capacity) {
			
			JOptionPane.showMessageDialog(null, "Over capacity");
			
		} 
		/** This checks time constraints */
		else {
			connection = initializeDB();
			
			Flight f1;
			
			boolean conflict = false;
			ResultSet rs = null;
			try{
				
				Statement statement = connection.createStatement();
				
				String queryString = "select idFlight " 
						+ "from reserve "
						+ " where username = '" + getUsername() +"'";
				
				rs = statement.executeQuery(queryString);
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				
			} catch(Exception ex){
				
				ex.printStackTrace();
				
			} 
			
			while(rs.next() && conflict == false) {
					
				f1 = new Flight(rs.getInt(1)); 
				f1.getInformation();
				if((f1.getFlightDeparture().after(book.getFlightDeparture()) && 
						f1.getFlightDeparture().before(book.getFlightArrival())) || (f1.getFlightArrival().after(book.getFlightDeparture()) && 
						f1.getFlightArrival().before(book.getFlightArrival()))) {
					
					JOptionPane.showMessageDialog(null, "Time constraint");
					conflict = true;
					
					
					
				} 
				
			}
				
			if(conflict == false) {
				connection = initializeDB();
				try{
				String queryString = "insert into reserve(idFlight, username) "
						+ "values(?,?)";
				
				preparedStatement = connection.prepareStatement(queryString);
				
				preparedStatement.setInt(1, book.getIdFlight());
				preparedStatement.setString(2, getUsername());
				
				preparedStatement.executeUpdate();
				JOptionPane.showMessageDialog(null, "Booked!");
				
				} catch(SQLException ex){
					
					ex.printStackTrace();
					
				} catch(Exception ex) {
					
					ex.printStackTrace();
					
				} finally {
					
					connection.close();
					
				}
			}
					
				
			
			
		}
		
	}
	
	public void delete() throws ClassNotFoundException, SQLException{
		
		initializeDB();
		
	}
	
	public void update() throws ClassNotFoundException, SQLException{
		
		initializeDB();
		
	}	
	
}