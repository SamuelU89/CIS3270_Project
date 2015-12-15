package cis3270.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cis3270.flight.ListFlight;
import cis3270.flight.ShowFlight;
import cis3270.user.Customer;

public class MainUI extends JFrame{

	Customer c1;
	public JFrame mainUI;
	private JButton listFlights = new JButton("List Flight");
	private JButton myFlights = new JButton("My Flights");
	private JButton logout = new JButton("Logout");
	private JButton addUpdateFlight = new JButton("Add/Update Flight");
	
	public MainUI(Customer c1) {
		this.c1 = c1;
		initialize();
	}
	
	private void initialize() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,2));
		
		mainPanel.add(listFlights);
		listFlights.setPreferredSize(new Dimension(200, 80));
		listFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					ListFlight flight = new ListFlight(c1);
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Error");
					e1.printStackTrace();
				}
			}
		});
		
		mainPanel.add(myFlights);
		myFlights.setPreferredSize(new Dimension(200, 80));
		myFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ShowFlight window;
				
				try {
				/**
				 * This is running the ShowFlight page from cis3270.gui.ShowFlight;
				 */
					window = new ShowFlight(c1);
					//System.out.println(c1.getUsername()); testing to see if object is passing through;
					mainUI.setVisible(false);
				
				} catch (Exception ex) {
					ex.printStackTrace();
					
				}	
				
			}
		});
		
		mainPanel.add(logout);
		logout.setPreferredSize(new Dimension(200, 80));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login window;
				
				try {
				/**
				 * This is running the Login page from cis3270.gui.Login;
				 */
					window = new Login();
					window.frame.setVisible(true);
					mainUI.setVisible(false);
				
				} catch (Exception ex) {
					ex.printStackTrace();
					
				}	
				
			}
		});
		
		if(c1.getAdmin() == 1) {
			mainPanel.add(addUpdateFlight);
			addUpdateFlight.setPreferredSize(new Dimension(200, 80));
			addUpdateFlight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	
					FlightForm window;
					
					try {
					/**
					 * This is running the FlightForm page from cis3270.gui.FlightForm;
					 * @Samuel U
					 */
						window = new FlightForm(c1);
						window.fForm.setVisible(true);
						mainUI.setVisible(false);
					
					} catch (Exception ex) {
						ex.printStackTrace();
						
					}	
					
				}
			});
		}
		JPanel mainPanel2 = new JPanel();
		
		JPanel mainPanelUI = new JPanel();
		mainPanelUI.add(mainPanel, BorderLayout.SOUTH);
		mainPanelUI.add(mainPanel2, BorderLayout.CENTER);
		
		mainUI = new JFrame();
		mainUI.setSize(1000, 800);
		mainUI.setResizable(false);
		mainUI.setLocationRelativeTo(null);
		mainUI.add(mainPanelUI);
		mainUI.setVisible(true);
		mainUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		
		
		
		
		

	}
	
}
