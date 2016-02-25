package gui;

import java.util.Vector;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import model.Customer;
import model.CustomerList;

public class CustomerListModel implements ListModel
{
	private Vector<Customer> customerList;

	public CustomerListModel()
	{
		 customerList = CustomerList.getInstance().getCustomerList();
	}

	@Override
	public int getSize()
	{
		return customerList.size();
	}

	@Override
	public Object getElementAt(int index)
	{
		Customer customer = customerList.get(index);
		return customer;
	}

	@Override
	public void addListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub

	}

}
