package cis3270.flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Plane {
	
	public static String getPlaneNum(int idPlane) throws SQLException, ClassNotFoundException {
			
		Connection connection = initializeDB();
		try{
			
		Statement statement = connection.createStatement();
		
		String queryString = "select planeNum " 
				+ " from plane "
				+ " where idPlane = '" + idPlane + "'";
		
		ResultSet rs = statement.executeQuery(queryString);
		
		if (!rs.next()) {
			
			//JOptionPane.showMessageDialog(null, "Invalid Login", "Error", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			
			return rs.getString(1);
			
			
		}
		
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		} finally {
			
			connection.close();
			
		}
		
		return null;
		
	}
	
	public static String getAirlineName(int idPlane) throws SQLException, ClassNotFoundException {
		
		Connection connection = initializeDB();
		try{
			
		Statement statement = connection.createStatement();
		
		String queryString = "select airlineName " 
				+ " from plane "
				+ " where idPlane = '" + idPlane + "'";
		
		ResultSet rs = statement.executeQuery(queryString);
		
		if (!rs.next()) {
			
			//JOptionPane.showMessageDialog(null, "Invalid Login", "Error", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			
			return rs.getString(1);
			
			
		}
		
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		} finally {
			
			connection.close();
			
		}
		
		return null;
		
	}
	
	public static int getCapacity(int idPlane) throws SQLException, ClassNotFoundException {
		
		Connection connection = initializeDB();
		try{
			
		Statement statement = connection.createStatement();
		
		String queryString = "select capacity " 
				+ " from plane "
				+ " where idPlane = '" + idPlane + "'";
		
		ResultSet rs = statement.executeQuery(queryString);
		
		if (!rs.next()) {
			
			//JOptionPane.showMessageDialog(null, "Invalid Login", "Error", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			
			return rs.getInt(1);
			
			
		}
		
		} catch(Exception ex){
			
			ex.printStackTrace();
			
		} finally {
			
			connection.close();
			
		}
		
		return 0;
		
	}
	
	public static Connection initializeDB() throws SQLException, ClassNotFoundException{
		
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

}
