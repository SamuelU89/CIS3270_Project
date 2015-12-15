package cis3270.mainApp;

import java.awt.EventQueue;

import javax.swing.*;

import cis3270.gui.Login;
import cis3270.gui.MainUI;

public class Project {
	
	public static void main(String[] args) {
		
		Login window;
		
		try {
		/**
		 * This is running the Login page from cis3270.gui.Login;
		 */
			window = new Login();
			window.frame.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}	 
		
	}
	
	}


