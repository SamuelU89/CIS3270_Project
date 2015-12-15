package cis3270.flight;

import java.sql.*;

import javax.swing.JOptionPane;

public class Flight {
	
	private PreparedStatement preparedStatement;
	
	private int idFlight;
	private int idPlane;
	private String flightFrom;
	private String flightTo;
	private Timestamp flightDeparture;
	private Timestamp flightArrival;

	public Flight() {
		
	}
	
	public Flight(int idFlight) {
		
		this.idFlight = idFlight;
		
	}
	
	public Flight(int idFlight, int idPlane, String flightFrom, String flightTo, Timestamp flightDeparture, Timestamp flightArrival) {
		
		setIdFlight(idFlight);
		setIdPlane(idPlane);
		setFlightFrom(flightFrom);
		setFlightTo(flightTo);
		//setFlightDeparture(flightDeparture);
		//setFlightArrival(flightArrival);
		
	}
	
	public void setIdFlight(int idFlight) {
		
		this.idFlight = idFlight;
		
	}
	
	public int getIdFlight() {
		
		return idFlight;
		
	}
	
	public void setIdPlane(int idPlane) {
		
		this.idPlane = idPlane;
		
	}
	
	public int getIdPlane() {
		
		return idPlane;
	}
	
	public void setFlightFrom(String flightFrom) {
		
		this.flightFrom = flightFrom;
	}
	
	public String getFlightFrom() {
		
		return flightFrom;
	}
	
	public void setFlightTo(String flightTo) {
		
		this.flightTo = flightTo;
	}
	
	public String getFlightTo() {
		
		return flightTo;
	}
	
	public void setFlightDeparture(Timestamp flightDeparture) {
		
		if (flightDeparture != null) { 
			this.flightDeparture = flightDeparture; 
			}

	}
	
	public Timestamp getFlightDeparture() {
		
		return flightDeparture;
	}
	
	public void setFlightArrival(Timestamp flightArrival) {
		
		if (flightArrival != null) { 
			this.flightArrival = flightArrival; 
			}
	}
	
	public Timestamp getFlightArrival() {
		
		return flightArrival;
	}

	public Connection initializeDB() throws SQLException, ClassNotFoundException{
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", 
				"CIS3270", "Cis3270");
		
		System.out.println("Connection complete");
		return connection;
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		}
		return null;
		
	}

	public void add() throws ClassNotFoundException, SQLException {
	
		Connection connection = initializeDB();
		try{
		String queryString = "insert into Flight(idFlight, idPlane, flightFrom, flightTo, "
				+ "flightDeparture, flightArrival)"
				+ "values(?,?,?,?,?,?)";
		
		preparedStatement = connection.prepareStatement(queryString);
		
		preparedStatement.setInt(1, getIdFlight());
		preparedStatement.setInt(2, getIdPlane());
		preparedStatement.setString(3, getFlightFrom());
		preparedStatement.setString(4, getFlightTo());
		//preparedStatement.setTimestamp(5, getFlightDeparture());
		//preparedStatement.setString(6, getFlightArrival());
		
		preparedStatement.executeUpdate();
		
		} catch(SQLException ex){
			
			JOptionPane.showMessageDialog(null, "Flight ID already exists!");
			ex.printStackTrace();
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
			
		} finally {
			
			connection.close();
			
		}
	}
	
	public void delete() throws ClassNotFoundException, SQLException{
		
		initializeDB();
		
	}
	
	public void update() throws ClassNotFoundException, SQLException{
		
		initializeDB();
		
	}
	
	public void getInformation() throws SQLException, ClassNotFoundException{
		
		Connection connection = initializeDB();
		try{
			
		Statement statement = connection.createStatement();
		
		String queryString = "select a.idFlight, a.idPlane, a.flightFrom, a.flightTo, "
				+ " a.flightDeparture, a.flightArrival " 
				+ " from Flight a"
				+ " where idFlight = '" + getIdFlight() + "'";
		
		ResultSet rs = statement.executeQuery(queryString);
		
		if (!rs.next()) {
			
			//JOptionPane.showMessageDialog(null, "Invalid Login", "Error", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			
			setIdFlight(rs.getInt(1));
			setIdPlane(rs.getInt(2));
			setFlightFrom(rs.getString(3));
			setFlightTo(rs.getString(4));
			setFlightDeparture(rs.getTimestamp(5));
			setFlightArrival(rs.getTimestamp(6));
			
		}
		
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		} finally {
			
			connection.close();
			
		}
		
	}
}
