import java.io.File;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class FolderTableModel implements TableModel
{
	private File[] folder = null;
	private String[] header = {"Name", "Typ", "Zugriff", "Check"};
	
	public FolderTableModel(File path)
	{
		this.folder = path.listFiles();
		Arrays.sort(this.folder);
	}

	@Override
	public int getRowCount()
	{
		return folder.length;
	}

	@Override
	public int getColumnCount()
	{
		return header.length;
	}

	@Override
	public String getColumnName(int columnIndex)
	{
		return header[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex)
	{
		switch(columnIndex)
		{
			case 1: return ImageIcon.class; 
			case 3: return Boolean.class;
		}
		
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		if(columnIndex == 3) return true;
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		File activeFolder = folder[rowIndex];
		
		switch(columnIndex)
		{
			case 0: return activeFolder.getName();
			case 1: return getFileIcon(activeFolder);
			case 2: return getFileRights(activeFolder);
			case 3: return false;
		}

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	{}

	@Override
	public void addTableModelListener(TableModelListener l)
	{}

	@Override
	public void removeTableModelListener(TableModelListener l)
	{}
	
	private String getFileRights(File file)
	{
		String access = "";
		
		if (file.canRead())
		{
			access = "r";
		}
		else
		{
			access = "-";
		}
		if (file.canWrite())
		{
			access += "w";
		}
		else
		{
			access += "-";
		}
		if (file.canExecute())
		{
			access += "x";
		}
		else
		{
			access += "-";
		}
				
		return access;
	}
	
	private ImageIcon getFileIcon(File file)
	{
		ImageIcon icon = new ImageIcon();
		
		if (file.isFile())
		{
			icon = new ImageIcon("images/serverdok.gif");
		}
		else
		{
			icon = new ImageIcon("images/serverkap.gif");
		}
		
		return icon;
	}
}