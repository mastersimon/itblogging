package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import model.Customer;
import model.CustomerList;

public class ListView extends JLabel
{
	public ListView()
	{
		setLayout(new BorderLayout());
		
		/*
		 *  eine Liste mit Kunden wird geholt
		 *  der genaue Aufbau (Datenbank, Model, etc.) soll an dieser Stelle
		 *  keine Rolle spielen.
		 */
		ArrayList<Customer> customerList = CustomerList.getInstance().getCustomerList();
		// über toArray() wird die toString() Methode aufgerufen. Ausgegeben wird <Nachname, Vorname>
		JList list = new JList(customerList.toArray());
		// die Liste wird scrollbar an die view übergeben
		add(new JScrollPane(list));
	}

}
