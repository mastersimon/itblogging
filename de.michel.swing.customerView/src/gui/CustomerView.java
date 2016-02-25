package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Customer;

public class CustomerView extends JFrame
{
	
	private JList lstCustomer;
	
	public CustomerView()
	{
		setTitle("Mehr Tutorials auf www.itblogging.de");
		setLayout(new BorderLayout(10, 10));
		
		CustomerListModel customerList = new CustomerListModel();
		
		JLabel lblHeader = new JLabel(customerList.getSize() + " Kunden");
		lblHeader.setBorder(new EmptyBorder(10, 10, 0, 10));
		add(lblHeader, BorderLayout.NORTH);
		
		lstCustomer = new JList(customerList);
		add(new JScrollPane(lstCustomer), BorderLayout.CENTER);
		
		JButton btnDetails = new JButton("Details");
		btnDetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Customer customer = (Customer) lstCustomer.getSelectedValue();
				CustomerDetails.showCustomerDetails(customer);				
			}
		});
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setLayout(new BorderLayout());
		pnlSouth.add(btnDetails, BorderLayout.LINE_START);
		
		add(pnlSouth, BorderLayout.SOUTH);
		
		
		setSize(500, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args)
	{
		new CustomerView();
	}

}
