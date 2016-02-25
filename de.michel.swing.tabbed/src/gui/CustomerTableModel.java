package gui;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Customer;
import model.CustomerList;

public class CustomerTableModel implements TableModel 
{
	ArrayList<Customer> customerList = null;
	
	public CustomerTableModel()
	{
		/*
		 *  getCustomerList() liefert eine ArrayList mit Kunden
		 *  der genaue Aufbau (Datenbank, Model, etc.) soll an dieser Stelle
		 *  keine Rolle spielen. 
		 */
		customerList = CustomerList.getInstance().getCustomerList();
	}

	/**
	 * Liefert die Anzahl der gelisteten Kunden
	 */
	@Override
	public int getRowCount()
	{
		return customerList.size();
	}

	/**
	 * setzt die Anzahl der Spalten 
	 * hier: Vorname,Nachname,eMail = 3
	 */
	@Override
	public int getColumnCount()
	{
		return 4;
	}

	/**
	 * setzt die Spaltennamen
	 */
	@Override
	public String getColumnName(int columnIndex)
	{
		switch (columnIndex)
		{
			case 0: return "Vorname";
			case 1: return "Nachname";
			case 2: return "E-Mail";
			case 3: return "Aktiv";
			default: break;
		}
		return null;
	}

	/**
	 * setzt den Typ des Inhalts einer Tabellenzelle
	 * hier: es handelt sich immer um Strings
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex)
	{
		if(columnIndex == 3) return Boolean.class;
		return String.class;
	}

	/**
	 * kann spezifische Zellen editierbar setzen
	 * hier: alle Zellen sind nicht editierbar
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return false;
	}

	/**
	 * liefert den Inhalt der einzelnen Zellen
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		switch (columnIndex)
		{
			case 0: return customerList.get(rowIndex).getFirstName();
			case 1: return customerList.get(rowIndex).getLastName();
			case 2: return customerList.get(rowIndex).geteMail();
			case 3: return customerList.get(rowIndex).isActive();
			
			default: break;
		}
		return null;
	}

	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	{
		// wenn die Zellen editierbar sind können die neuen Inhalte hier geschrieben werden
	}

	@Override
	public void addTableModelListener(TableModelListener l)
	{}

	@Override
	public void removeTableModelListener(TableModelListener l)
	{}
	
}