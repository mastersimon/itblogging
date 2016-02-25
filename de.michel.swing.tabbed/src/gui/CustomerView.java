package gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class CustomerView extends JFrame
{
	public CustomerView()
	{
		setTitle("Kundenansicht - www.itblogging.de");
		
		// Erstellen einer Tabbed-Ansicht
		JTabbedPane tabber = new JTabbedPane();
		// ein Tab wird hinzugefügt und mit der Listenansicht gefüllt 
		tabber.add("Listenansicht", new ListView());
		// ein Tab wird hinzugefügt und mit der Tabellenansicht gefüllt
		tabber.add("Tabellenansicht", new TableView());
		// das TabbedPane wird der Oberfläche hinzufüget
		add(tabber);
		// die Größe des Fensters beträgt 400x300 ...
		setSize(400,300);
		// ... und soll natürlich sichtbar sein
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new CustomerView();
	}
}