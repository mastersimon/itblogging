package lookAndFeel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.UIManager.*;

public class LookAndFeelTest extends JFrame {

	public LookAndFeelTest()
	{
		// Titel setzen
		setTitle("www.itblogging.de");

		// Look-and-Feel dem Betriebssystem entsprechend setzen.
		String systemClassName = getSystemLookAndFeelClassName();
		try {
			setLookAndFeel(systemClassName);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Menü mit installierten Look-and-Feels erzeugen.
		JMenu menuLookAndFeel = new JMenu("Look and Feel");

		// Auswahlmenügruppe erzeugen
		ButtonGroup buttonGroup = new ButtonGroup();

		// installierte LookAndFeels holen
		LookAndFeelInfo[] infos = getInstalledLookAndFeels();

		// durch alle Looks iterieren
		for (LookAndFeelInfo info : infos)
		{

			// Der Menüeintrag entsprechend beschriftet.
			JRadioButtonMenuItem menueItem = new JRadioButtonMenuItem(
					info.getName());
			final String className = info.getClassName();
			if (className.equals(systemClassName))
			{
				menueItem.setSelected(true);
			}

			// wenn eine Auswahl getroffen wurde, muss gehandelt werden
			menueItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae) {
					try {
						// Das ausgewählte Look-and-Feel wird mit Hilfe
						// des Klassennamens gesetzt.
						setLookAndFeel(className);
					} catch (Exception e) {
						System.out.println(e);
					}
					// Bedienelemente aktualisieren
					SwingUtilities.updateComponentTreeUI(LookAndFeelTest.this);
				}
			});
			// Menüeintrag hinzufügen
			menuLookAndFeel.add(menueItem);
			buttonGroup.add(menueItem);
		}

		// Menü erzeugen
		JMenuBar menuBar = new JMenuBar();
		// Items hinzufügen
		menuBar.add(menuLookAndFeel);
		setJMenuBar(menuBar);
		// Oberflächenelemente erzeugen
		String[] starSign = { "Steinbock", "Wassermann", "Fische",
				"Widder", "Stier", "Zwillinge", "Krebs", "Löwe", "Jungfrau",
				"Waage", "Skorpion", "Schütze" };
		setLayout(new GridLayout(1, 2));

		// linkes Panel erzeugen und Items hinzufügen
		JPanel pnlLeft = new JPanel();
		pnlLeft.add(new JCheckBox("JCheckBox"));
		pnlLeft.add(new JComboBox(starSign));
		pnlLeft.add(new JButton("JButton"));
		pnlLeft.add(new JLabel("JLabel"));
		pnlLeft.add(new JTextField("JTextField"));

		add(pnlLeft);

		// Scrollbar erzeugen und hinzufügen
		add(new JScrollPane(new JList(starSign)));
		//
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LookAndFeelTest();
	}
}
