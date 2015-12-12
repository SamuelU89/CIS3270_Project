package cis3270.mainApp;

import java.sql.*;
import javax.swing.*;
import cis3270.user.Customer;

/* Use this Class to test your code */
public class Test {
	
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Customer dan = new Customer("Sam", "U",  "19th street", "GA", 12343, "27ieor", 263099098, "doh?", "doh", "ddn", "u", 1);
		
		dan.add();
		
		
	}

}
