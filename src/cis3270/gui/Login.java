package cis3270.gui;

import java.awt.EventQueue;

import javax.swing.*;

import cis3270.user.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login extends JFrame {

	public JFrame frame;
	protected JTextField userNameInputBox;
	private JTextField passwordInputBox;
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 970, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblReservationSystem = new JLabel("Reservation System");
		lblReservationSystem.setBounds(327, 40, 286, 71);
		lblReservationSystem.setFont(new Font("Tahoma", Font.BOLD, 28));
		frame.getContentPane().add(lblReservationSystem);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(61, 166, 124, 42);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(61, 251, 124, 42);
		frame.getContentPane().add(lblPassword);
		
		userNameInputBox = new JTextField();
		userNameInputBox.setBounds(227, 166, 286, 42);
		frame.getContentPane().add(userNameInputBox);
		userNameInputBox.setColumns(10);
		
		passwordInputBox = new JTextField();
		passwordInputBox.setColumns(10);
		passwordInputBox.setBounds(227, 251, 286, 42);
		frame.getContentPane().add(passwordInputBox);
		
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					frame.setVisible(false);
					frame = null;
					ForgotPassword lookupPass = new ForgotPassword();
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Error");
					
				}
			}
		});
		btnForgotPassword.setBounds(582, 361, 124, 33);
		btnForgotPassword.setSize(200,50);
		frame.getContentPane().add(btnForgotPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Customer c1 = new Customer(userNameInputBox.getText());
					c1.getInformation();
					
					if(c1.getPassword().equals(passwordInputBox.getText())) {
						frame.setVisible(false);
						frame = null;
						MainUI mainUI = new MainUI();
					} else {
						
						JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.INFORMATION_MESSAGE);
						
					}
				
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
				}
			}
		});
		btnLogin.setBounds(227, 345, 286, 56);
		btnLogin.setSize(200,50);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					frame.setVisible(false);
					frame = null;
					NewRegister registerForm = new NewRegister();
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Error");
					
				}
			}
		});
		btnRegister.setBounds(582, 306, 124, 33);
		btnRegister.setSize(200,50);
		frame.getContentPane().add(btnRegister);

	}
	
}


