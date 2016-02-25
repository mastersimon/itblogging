package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Customer;

public class CustomerDetails extends JDialog
{
	public CustomerDetails(Customer customer)
	{
		super(new JFrame(), customer.getFirstName() + " " + customer.getLastName());
		setLayout(new BorderLayout());
		
		JPanel pnlDetailsLeft = new JPanel(new GridLayout(0,1));
		pnlDetailsLeft.add(new JLabel("Name"));
		pnlDetailsLeft.add(new JLabel("Vorname"));
		
		JPanel pnlDetailsRight = new JPanel(new GridLayout(0,1));
		pnlDetailsRight.add(new JTextField(customer.getLastName()));
		pnlDetailsRight.add(new JTextField(customer.getFirstName()));
		
		add(pnlDetailsLeft, BorderLayout.WEST);
		add(pnlDetailsRight, BorderLayout.EAST);
		
		setModalityType(ModalityType.APPLICATION_MODAL);
		pack();
		setVisible(true);
	}
	
	public static void showCustomerDetails(Customer customer)
	{
		new CustomerDetails(customer);
	}

}
