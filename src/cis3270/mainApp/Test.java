package cis3270.mainApp;

import java.sql.*;

import javax.swing.*;

import cis3270.user.Customer;
import cis3270.user.User;

/* Use this Class to test your code */
public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		User dan = new Customer("sam1");
		
		dan.getInformation();
		
		System.out.println(dan.getPassword());
		
	}

}
