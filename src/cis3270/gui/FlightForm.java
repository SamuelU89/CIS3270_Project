package cis3270.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;

import cis3270.flight.Flight;
import cis3270.user.Customer;
/**
 * This class is for the flight form. This is where admins can add flight information.
 * @author xakai77x
 *
 */
public class FlightForm extends Flight {

	Customer c1;
	public JFrame fForm;
	private JLabel flightID, planeID, flightTo, flightFrom, depart, arrive;
	private JTextField enterFID, enterPID, enterFTo, enterFFrom, enterDepart, enterArrive;
	private JButton addFlight, cancelAdd;
	
	JPanel p1, p2;
	GridLayout g1, g2;
	FlowLayout f1;
	
	public FlightForm(Customer c1) {
		
		this.c1 = c1;
		initialize();
		
	}
	
	private void initialize() {
		
		fForm = new JFrame();
		fForm.setSize(1000, 800);
		fForm.setResizable(false);
		fForm.setLocationRelativeTo(null);
		fForm.setVisible(true);
		fForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		flightID = new JLabel("Flight ID: ");
		planeID = new JLabel("Plane ID: ");
		flightTo = new JLabel("To: ");
		flightFrom = new JLabel("From: ");
		depart = new JLabel("Departure Time: ");
		arrive = new JLabel("Arrival Time: ");
		
		enterFID = new JTextField("FID");
		enterPID = new JTextField("PID");
		enterFTo = new JTextField("To(City, State)");
		enterFFrom = new JTextField("From(City, State)");
		enterDepart = new JTextField("YYYY-MM-DD HH-MM-SS");
		enterArrive = new JTextField("YYYY-MM-DD HH-MM-SS");
		
		addFlight = new JButton("Add");
		cancelAdd = new JButton("Cancel");
		
		p1 = new JPanel();
		p2 = new JPanel();
		
		g1 = new GridLayout(22,1);
		g2 = new GridLayout(1,1);
		
		f1 = new FlowLayout();
		
		p1.setLayout(g1);
		p1.add(flightID);
		p1.add(enterFID);
		p1.add(planeID);
		p1.add(enterPID);
		p1.add(flightTo);
		p1.add(enterFTo);
		p1.add(flightFrom);
		p1.add(enterFFrom);
		p1.add(depart);
		p1.add(enterDepart);
		p1.add(arrive);
		p1.add(enterArrive);
		
		p2.setLayout(g2);
		p2.add(addFlight);
		addFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
				Date parsedDate;
				Date parsedDate2;
				
				Timestamp timestamp = null;
				Timestamp timestamp2 = null;
				try {
					parsedDate = dateFormat.parse(enterDepart.getText());
					parsedDate2 = dateFormat2.parse(enterArrive.getText());
					
					timestamp = new java.sql.Timestamp(parsedDate.getTime());
					timestamp2 = new java.sql.Timestamp(parsedDate2.getTime());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Flight f1 =  new Flight(Integer.parseInt(enterFID.getText()), Integer.parseInt(enterPID.getText()), enterFTo.getText(), 
						enterFFrom.getText(), timestamp, timestamp2);
				
				try {
					
					f1.add();
					JOptionPane.showMessageDialog(null, "Successfully added");
					
				} catch(SQLException ex){
					
					JOptionPane.showMessageDialog(null, "Flight ID already exists!");
					ex.printStackTrace();
					
				} catch(Exception ex) {
					
					ex.printStackTrace();
					
				}
				
			}
		});
		
		p2.add(cancelAdd);
		cancelAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainUI window;
				
				try {

					window = new MainUI(c1);
					window.mainUI.setVisible(true);
					fForm.setVisible(false);
				
				} catch (Exception ex) {
					ex.printStackTrace();
					
				}	
				
			}
		});
		
		fForm.setLayout(g2);
		fForm.add(p1);
		fForm.add(p2);
		fForm.setSize(1000, 800);
		fForm.setVisible(true);
		
		
		
		
	}
	
}
