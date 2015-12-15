package cis3270.mainApp;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.*;

import cis3270.flight.Flight;
import cis3270.gui.Login;
import cis3270.gui.MainUI;

public class Project {
	
	public static void main(String[] args) {
		
		Splash splash = new Splash("src\\cis3270\\image\\splash.jpg", new JFrame(), 1000);
		splash.setVisible(true);
		
		Login window;
		
		try {
			/**
		This is running the Login page from cis3270.gui.Login;
		*/
		 
			window = new Login();
			window.frame.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}	 
		
	} 
	
}



