package barchart;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Chart extends JFrame
{
	public Chart()
	{
		// Titel
		setTitle("JFreeChart Tutorial - www.itblogging.de");

		// Daten für die spätere Verarbeitung des Tortendiagramms
		DefaultPieDataset pieDataset = getPieDataset();

		// Daten für die spätere Verarbeitung des Balkendiagramms
		DefaultCategoryDataset barDataset = getBarDataset();

		// Über die "ChartFactory" können neue Diagramme erstellt werden
		// 2D Tortendiagramm
		JFreeChart pieChart2D = ChartFactory.createPieChart(
				"Browsernutzung auf itblogging.de", pieDataset, true, true, true);
		// 3D Tortendiagramm
		JFreeChart pieChart3D = ChartFactory.createPieChart3D(
				"Browsernutzung auf itblogging.de", pieDataset, true, true, true);

		// Balkendiagramm mit vertikaler Ausrichtung
		JFreeChart barChartVertical3D = ChartFactory.createBarChart3D(
				"Besucherstatistik", "Monate", "Besucher", barDataset,
				PlotOrientation.VERTICAL, true, true, true);
		// Balkendiagramm mit horizontaler Ausrichtung
		JFreeChart barChartHorizontal3D = ChartFactory.createBarChart3D(
				"Besucherstatistik", "Monate", "Besucher", barDataset,
				PlotOrientation.HORIZONTAL, true, true, true);

		// ChartPanel mit dem vorhandenen 2D Tortendiagramm erstellen
		ChartPanel pieChartPanel2D = new ChartPanel(pieChart2D);
		// ChartPanel mit dem vorhandenen 3D Tortendiagramm erstellen
		ChartPanel pieChartPanel3D = new ChartPanel(pieChart3D);

		// ChartPanel mit dem vorhandenen vertikalen 3D Balkendiagramm erstellen
		ChartPanel barChartVerticalPanel3D = new ChartPanel(barChartVertical3D);
		// ChartPanel mit dem vorhandenen horizontalen 3D Balkendiagramm erstellen
		ChartPanel barChartHorizontalPanel3D = new ChartPanel(barChartHorizontal3D);

		// Registerkarten erstellen
		JTabbedPane tabber = new JTabbedPane();

		// 1.Registerkarte: 2D Tortendigramm
		tabber.add("PieChart2D", pieChartPanel2D);
		// 2.Registerkarte: 3D Tortendigramm
		tabber.add("PieChart3D", pieChartPanel3D);

		// 3.Registerkarte: 3D vertikales Balkendiagramm
		tabber.add("BarChart3D - Vertikal", barChartVerticalPanel3D);
		// 3.Registerkarte: 3D horizontales Balkendiagramm
		tabber.add("BarChart3D - Horizontal", barChartHorizontalPanel3D);

		// Registerkarten dem JFrame übergeben
		add(tabber);

		// Java Anwendung beim schließen beenden
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Applikation sichtbar schalten
		setVisible(true);
		// automatische Größenanpassung
		pack();
	}

	/**
	 * liefert die Daten für das Balkendiagramm
	 */
	private DefaultCategoryDataset getBarDataset()
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(591, "September", "");
		dataset.addValue(1119, "Oktober", "");
		dataset.addValue(1813, "November", "");
		dataset.addValue(1765, "Dezember", "");
		dataset.addValue(2756, "Januar", "");
		dataset.addValue(2603, "Februar", "");

		return dataset;
	}

	/**
	 * liefert die Daten für das Tortendiagramm
	 */
	private DefaultPieDataset getPieDataset()
	{
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Firefox", 62);
		dataset.setValue("Internet Explorer", 12);
		dataset.setValue("Chrome", 10);
		dataset.setValue("Opera", 8);
		dataset.setValue("Safari", 7);
		dataset.setValue("Alle andere", 1);

		return dataset;
	}

	public static void main(String[] args)
	{
		// neue Applikation erstellen
		new Chart();
	}
}
