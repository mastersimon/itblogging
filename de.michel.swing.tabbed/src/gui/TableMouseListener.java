package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableMouseListener implements MouseListener
{
	
	private TableRowSorter<TableModel> rowSorter = null;
	private JTable table = null;
	
	public TableMouseListener(TableRowSorter<TableModel> rowSorter, JTable table)
	{
		this.rowSorter = rowSorter;
		this.table = table;
	}

	@Override
	public void mouseClicked(MouseEvent e)
  {
    int convertedRowAtPoint = rowSorter.convertRowIndexToModel(table.rowAtPoint(e.getPoint()));
    int convertedColumAtPoint = table.convertColumnIndexToModel(table.columnAtPoint(e.getPoint()));
    System.out.println(rowSorter.getModel().getValueAt(convertedRowAtPoint,convertedColumAtPoint));
  }

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
