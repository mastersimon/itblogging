import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JTable;


public class FolderMouseListener implements MouseListener
{
	private JTable table = null;
	public FolderMouseListener(JTable table)
	{
		this.table = table;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getComponent().isEnabled() && e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2)
    {
      Point p = e.getPoint();
      int row = table.rowAtPoint(p); 
      int column = table.columnAtPoint(p);

      String path = FolderInfo.txtFolderInvisible;
      if(!path.equals("/"))
      {
      	path = path + "/"; 
      }
      path += table.getModel().getValueAt(row, column);
      
      File f = new File(path);
      if(f.isDirectory())
      {
      	table.setModel(new FolderTableModel(f));
      	FolderInfo.txtFolderInvisible = path;
      	FolderInfo.txtFolder.setText(path);    
      }
    }
	}

	@Override
	public void mousePressed(MouseEvent e)
	{}

	@Override
	public void mouseReleased(MouseEvent e)
	{}

	@Override
	public void mouseEntered(MouseEvent e)
	{}

	@Override
	public void mouseExited(MouseEvent e)
	{}

}
