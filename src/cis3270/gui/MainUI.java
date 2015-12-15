package cis3270.gui;

import java.awt.*;
import javax.swing.*;

public class MainUI extends JFrame{

	public JFrame mainUI;
	private JButton mainMenu = new JButton("Main Menu");
	private JButton searchFlights = new JButton("Search Flight");
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
		mainPanel.add(searchFlights);
		searchFlights.setPreferredSize(new Dimension(200, 80));
		mainPanel.add(myFlights);
		myFlights.setPreferredSize(new Dimension(200, 80));
		mainPanel.add(logout);
		logout.setPreferredSize(new Dimension(200, 80));
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
