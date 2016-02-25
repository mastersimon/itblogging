import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FolderInfo extends JFrame
{
	private JTable table = new JTable();
	public static JTextField txtFolder;
	public static String txtFolderInvisible = "";

	public FolderInfo()
	{
		setTitle("www.itblogging.de");

		JPanel pnlContent = new JPanel(new BorderLayout(20, 20));
		add(pnlContent, BorderLayout.CENTER);
		pnlContent.setBorder(new EmptyBorder(20, 20, 20, 20));

		JPanel pnlHeader = new JPanel(new BorderLayout(10, 10));
		pnlContent.add(pnlHeader, BorderLayout.NORTH);
		JLabel lblFolder = new JLabel("Ordner : ");
		pnlHeader.add(lblFolder, BorderLayout.WEST);
		txtFolder = new JTextField("/");
		pnlHeader.add(txtFolder, BorderLayout.CENTER);
		JButton btnBrowse = new JButton("...");
		pnlHeader.add(btnBrowse, BorderLayout.EAST);
		
		table.setModel(new FolderTableModel(new File("/")));
		pnlContent.add(new JScrollPane(table), BorderLayout.CENTER);

		table.addMouseListener(new FolderMouseListener(table));

		//
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		//
		btnBrowse.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					JFileChooser fileChooser = new JFileChooser("/");
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					if (fileChooser.showOpenDialog(FolderInfo.this) == JFileChooser.APPROVE_OPTION)
					{
						File file = fileChooser.getSelectedFile();
						txtFolder.setText(file.getPath());
						txtFolderInvisible = file.getPath();
						table.setModel(new FolderTableModel(file));
					}
				} catch (NullPointerException b)
				{
					JOptionPane.showMessageDialog(null, "Keine Daten vorhanden");
				}
			}
		});
		//
		txtFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String folderName = txtFolder.getText();
				File folder = new File(folderName);
				if (folder.exists() && folder.isDirectory())
				{
					table.setModel(new FolderTableModel(folder));
					txtFolderInvisible = txtFolder.getText();
				} else
				{
					JOptionPane.showMessageDialog(null, "Kein gültiger Ordnername.");
				}
			}
		});
	}

	public static void main(String[] args)
	{
		new FolderInfo();
	}
}
