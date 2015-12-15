package cis3270.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cis3270.flight.ListFlight;

public class MainUI extends JFrame{

	public JFrame mainUI;
	private JButton mainMenu = new JButton("Main Menu");
	private JButton listFlights = new JButton("List Flight");
	private JButton myFlights = new JButton("My Flights");
	private JButton logout = new JButton("Logout");
	private JButton addUpdateFlight = new JButton("Add/Update Flight");
	
	
	public MainUI() {
		initialize();
	}
	
	private void initialize() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,2));
		
		mainPanel.add(mainMenu);
		mainMenu.setPreferredSize(new Dimension(200, 80));
		
		mainPanel.add(listFlights);
		listFlights.setPreferredSize(new Dimension(200, 80));
		listFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					ListFlight flight = new ListFlight();
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Error");
					e1.printStackTrace();
				}
			}
		});
		
		mainPanel.add(myFlights);
		myFlights.setPreferredSize(new Dimension(200, 80));
		
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
		
		
		mainPanel.add(addUpdateFlight);
		addUpdateFlight.setPreferredSize(new Dimension(200, 80));
		
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
