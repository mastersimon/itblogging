package dataStorage;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.Literature;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLLiterature
{
	public static void main(String[] args)
	{
		try
		{
			// eine neue factory erstellen
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// Leerzeichen werden entfernt
			factory.setIgnoringElementContentWhitespace(true);
			// bevor ein 'Document' erstellt werden kann wird ein 'DocumentBuilder' benötigt
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Speicherort der XML-Datei
			File file = new File("src/xml/literature.xml");
			Document document = builder.parse(file);

			// Erstellen eines Literatur-Objektes
			Literature literatur = XMLinObject.createLiterature(document.getDocumentElement());
			
			// Ausgabe des XML-Dokumentes in Objekte
			System.out.println(literatur);
		} catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		} catch (SAXException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
