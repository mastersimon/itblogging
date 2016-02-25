package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableView extends JLabel
{
	public TableView()
	{
		setLayout(new BorderLayout());
		
		CustomerTableModel model = new CustomerTableModel();
		
		// eine neue Tabelle wird erstellt..
		final JTable table = new JTable();
		// ..und das Model gesetzt..
		table.setModel(model);
		// ..bevor es der view hinzugefügt wird (wichtig ist, das die Tabell scrollbar ist)
		
		
		final TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(rowSorter);
		
		table.addMouseListener(new TableMouseListener(rowSorter, table));
		
		add(new JScrollPane(table));
	}
}