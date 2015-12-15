package cis3270.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlightForm {

	private JFrame frame;
	private JTextField textFieldFlightID;
	private JTextField textFieldPlaneID;
	private JTextField textFieldFlightFrom;
	private JTextField textFieldFlightTo;
	private JTextField textFieldDepartureTime;
	private JTextField textFieldArrivalTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightForm window = new FlightForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FlightForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 934, 803);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Flight Form for Administrator");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitle.setBounds(263, 44, 417, 70);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblFlightId = new JLabel("Flight ID:");
		lblFlightId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFlightId.setBounds(137, 145, 79, 28);
		frame.getContentPane().add(lblFlightId);
		
		JLabel lblPlaneId = new JLabel("Plane ID:");
		lblPlaneId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlaneId.setBounds(137, 227, 79, 28);
		frame.getContentPane().add(lblPlaneId);
		
		JLabel lblFlightFrom = new JLabel("Flight From:");
		lblFlightFrom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFlightFrom.setBounds(113, 307, 103, 28);
		frame.getContentPane().add(lblFlightFrom);
		
		JLabel lblFlightTo = new JLabel("Flight To:");
		lblFlightTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFlightTo.setBounds(127, 384, 89, 28);
		frame.getContentPane().add(lblFlightTo);
		
		JLabel lblDepartureTime = new JLabel("Departure Time:");
		lblDepartureTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDepartureTime.setBounds(82, 460, 134, 28);
		frame.getContentPane().add(lblDepartureTime);
		
		JLabel lblArrivalTime = new JLabel("Arrival Time:");
		lblArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArrivalTime.setBounds(113, 534, 103, 33);
		frame.getContentPane().add(lblArrivalTime);
		
		textFieldFlightID = new JTextField();
		textFieldFlightID.setBounds(244, 146, 163, 33);
		frame.getContentPane().add(textFieldFlightID);
		textFieldFlightID.setColumns(10);
		
		textFieldPlaneID = new JTextField();
		textFieldPlaneID.setColumns(10);
		textFieldPlaneID.setBounds(244, 228, 163, 33);
		frame.getContentPane().add(textFieldPlaneID);
		
		textFieldFlightFrom = new JTextField();
		textFieldFlightFrom.setColumns(10);
		textFieldFlightFrom.setBounds(244, 308, 283, 33);
		frame.getContentPane().add(textFieldFlightFrom);
		
		textFieldFlightTo = new JTextField();
		textFieldFlightTo.setColumns(10);
		textFieldFlightTo.setBounds(244, 384, 283, 33);
		frame.getContentPane().add(textFieldFlightTo);
		
		textFieldDepartureTime = new JTextField();
		textFieldDepartureTime.setColumns(10);
		textFieldDepartureTime.setBounds(244, 461, 163, 33);
		frame.getContentPane().add(textFieldDepartureTime);
		
		textFieldArrivalTime = new JTextField();
		textFieldArrivalTime.setColumns(10);
		textFieldArrivalTime.setBounds(244, 537, 163, 33);
		frame.getContentPane().add(textFieldArrivalTime);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//the submit button submits the form
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(244, 629, 210, 48);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				//the cancel button cancels the form
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(555, 629, 210, 48);
		frame.getContentPane().add(btnCancel);
	}
}
