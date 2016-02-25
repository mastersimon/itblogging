package de.michel.mysql.jList;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListDataListener;

public class Test extends JFrame
{
	
	public Test()
	{
		// Es werden alle Personen in einem Vektor gespeichert ...
		Vector<Person> persons = PersonList.getInstance().getPersons();
		
		// ... und der JList hinzugefügt
		JList lstPersons = new JList(persons);
		
		// Für die besser Uebersicht wird eine Scrollbar hinzugefuegt
		JScrollPane scroller = new JScrollPane(lstPersons);
		
		JComboBox cmb = new JComboBox(new ComboBoxModel() {
			
			@Override
			public void removeListDataListener(ListDataListener l)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getSize()
			{
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getElementAt(int index)
			{
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addListDataListener(ListDataListener l)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setSelectedItem(Object anItem)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Object getSelectedItem()
			{
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(cmb);
//		add(scroller);
		pack();
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new Test();
	}
}
