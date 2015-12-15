package cis3270.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cis3270.user.Customer;

/**
 * This class is used to find forgotten password
 * @author Samuel U
 *
 */
public class ForgotPassword extends Customer{
	
	public JFrame fp1;
	
	private JButton btnOK, btnCancel;
	private JLabel lblInformation;
	private JTextField inputAns;
	
	private JPanel p1;
	
	private GridLayout g1;
	private FlowLayout f1;
	
	
	public ForgotPassword() {
		
		initialize();
		
	}
	
	public void initialize() {
		
		fp1 = new JFrame();
		
		btnOK = new JButton("OK");
		btnCancel = new JButton("Cancel");
		
		lblInformation = new JLabel("Enter username: ");
		
		inputAns = new JTextField();
		
		p1 = new JPanel();
		g1 = new GridLayout(1,1);
		f1 = new FlowLayout();
		
		p1.setLayout(g1);
		p1.add(lblInformation);
		p1.add(inputAns);
		/**
		 * this is going to check if the username, security answer are valid
		 * @author Samuel U
		 */
		p1.add(btnOK);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Customer c1 = new Customer(inputAns.getText());
				
				try{
					
					c1.getInformation();
					if (c1.getSSN() != 0) {
					
						System.out.println(c1.getUsername());
						System.out.println(inputAns.getText());
						lblInformation.setText(c1.getSecurityQuestion());
							
							
						btnOK.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							
								if (inputAns.getText().equals(c1.getSecurityAnswer())) {
									
									JOptionPane.showMessageDialog(null, c1.getPassword());
									
								} else {
									
									JOptionPane.showMessageDialog(null, "Incorrect Answer");
									
									
								}
							
							}
							
						});  
					
					} else {
						
						JOptionPane.showMessageDialog(null, "Username does not exist");
						
					}
					
				} catch (Exception ex) {

					ex.printStackTrace();
					
				}
				
			}
		});
		
		p1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login window;
				
				try {
				/**
				 * This is running the Login page from cis3270.gui.Login;
				 */
					window = new Login();
					window.frame.setVisible(true);
					fp1.setVisible(false);
				
				} catch (Exception ex) {
					ex.printStackTrace();
					
				}	
				
			}
		});
		
		fp1.setLayout(f1);
		fp1.add(p1);
		fp1.setSize(1000,800);
		fp1.setVisible(true);
		
		
		
		
	}
	
	
	

}
