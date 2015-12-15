package cis3270.flight;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import cis3270.user.Customer;

public class ListFlight extends Flight{

	Customer c1;
	private PreparedStatement preparedStatement;
	public JFrame fFrame;
	
	/**
	 * Create the application.
	 */
	public ListFlight(Customer c1) {
		this.c1 = c1;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JPanel mainPanel = new JPanel();
		
		JButton book = new JButton("Book");
		mainPanel.add(book);
		book.setPreferredSize(new Dimension(200, 80));
		
		JTextField enterFlightNum = new JTextField("Enter Flight Number");
		enterFlightNum.setColumns(10);
		enterFlightNum.setBounds(227, 251, 286, 42);
		mainPanel.add(enterFlightNum);
		
		JButton mainMenu = new JButton("Main Menu");
		mainPanel.add(mainMenu);
		mainMenu.setPreferredSize(new Dimension(200, 80));
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fFrame.setVisible(false);
			
			}
		});
		
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try{
					c1.bookFlight(Integer.parseInt(enterFlightNum.getText()));;
				}
				catch (Exception ex) {
					
					ex.printStackTrace();
					
				}
				
			}
		});
		
		
		JPanel mainPanel2 = new JPanel();
		JLabel listFlights = new JLabel();
		mainPanel2.add(listFlights);
		
		Connection connection;
		String labelText = "<html>";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", 
					"CIS3270", "Cis3270");
			
			System.out.println("Connection complete");
			
		
		Statement statement;
		
		statement = connection.createStatement();
		
		String queryString = "select * from flight";
		
		ResultSet rs = statement.executeQuery(queryString);
		
		while(rs.next()) {
			
			
			labelText = labelText + rs.getString(1) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5)
					+ " " + rs.getString(6) + "<br>";
			}
		
		
		} catch (Exception e) {
			
			
			
		}
		
		listFlights.setText(labelText);
		System.out.println(labelText);
		
		JPanel mainCombine = new JPanel();
		mainCombine.add(mainPanel, BorderLayout.NORTH);
		mainCombine.add(mainPanel2, BorderLayout.SOUTH);
		
		
		fFrame = new JFrame();
		fFrame.setSize(1000, 800);
		fFrame.add(mainCombine);
		fFrame.setVisible(true);
		fFrame.setResizable(false);
		fFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fFrame.getContentPane().setLayout(null);
		
	}
	
}
	
		





