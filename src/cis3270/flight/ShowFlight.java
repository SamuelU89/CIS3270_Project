package cis3270.flight;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

import cis3270.gui.MainUI;
import cis3270.user.Customer;

public class ShowFlight extends Flight{
	
	Customer c1;
	public JFrame show;
	private JLabel list;
	private JButton btnOK;
	JPanel p1;
	GridLayout g1;
	FlowLayout f1;
	
	public ShowFlight(Customer c1) {
		
		this.c1 = c1;
		initialize();
		
	}
	
	private void initialize() {
	
		show = new JFrame();
		
		list = new JLabel();
		try{
			list.setText(c1.getFlight());
		} catch(SQLException | ClassNotFoundException ex) {
			
			list.setText("No flights available");
			
		}
		
		btnOK = new JButton("OK");
		
		p1 = new JPanel();
		g1 = new GridLayout();
		f1 = new FlowLayout();
		
		p1.setLayout(g1);
		p1.add(list);
		p1.add(btnOK);
		btnOK.setPreferredSize(new Dimension(200, 80));
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainUI window;
				
				try {

					window = new MainUI(c1);
					window.mainUI.setVisible(true);
					show.setVisible(false);
				
				} catch (Exception ex) {
					ex.printStackTrace();
					
				}	
			
			}
		});
		
		show.setLayout(f1);
		show.add(p1);
		show.setSize(1000, 800);
		show.setResizable(false);
		show.setLocationRelativeTo(null);
		show.setVisible(true);
		show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
