package cis3270.flight;

import java.sql.*;

import javax.swing.JOptionPane;

public class Flight {
	
	private PreparedStatement preparedStatement;
	
	private int idFlight;
	private int idPlane;
	private String flightFrom;
	private String flightTo;
	private String flightDeparture;
	private String flightArrival;

	public Flight() {
		
	}
	
	public Flight(int idFlight, int idPlane, String flightFrom, String flightTo, String flightDeparture, String flightArrival) {
		
		setIdFlight(idFlight);
		setIdPlane(idPlane);
		setFlightFrom(flightFrom);
		setFlightTo(flightTo);
		setFlightDeparture(flightDeparture);
		setFlightArrival(flightArrival);
		
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
	
	public void setFlightDeparture(String flightDeparture) {
		
		this.flightDeparture = flightDeparture;
	}
	
	public String getFlightDeparture() {
		
		return flightDeparture;
	}
	
	public void setFlightArrival(String flightArrival) {
		
		this.flightArrival = flightArrival;
	}
	
	public String getFlightArrival() {
		
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
		preparedStatement.setString(5, getFlightDeparture());
		preparedStatement.setString(6, getFlightArrival());
		
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
}
