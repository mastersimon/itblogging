package dataStorage;

import model.Author;
import model.Book;
import model.Literature;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Klasse zur Erzeugung der model-Objekte aus der XML Datei
 */
public class XMLinObject
{
	/**
	 * Erzeugt ein Literatur-Objekt aus dem entsprechenden XML-Knoten.
	 */
	public static Literature createLiterature(Element literatureXML)
	{
		Literature literature = new Literature();
		// Wir holen uns das Element 'book' aus dem XML-DOM ..
		NodeList bookList = literatureXML.getElementsByTagName("book");
		// .. und fügen alle Bücher der Literaturliste hinzu
		for (int i = 0; i < bookList.getLength(); i++)
		{
			Element currentBook = (Element) bookList.item(i);
			// neues Buch aus dem XML-Knoten erstellen
			Book book = createBook(currentBook);
			// Buch dem Literaturvektor hinzufügen
			literature.addBook(book);
		}
		return literature;
	}

	/**
	 * Erzeugt ein Buch-Objekt aus dem entsprechenden XML-Knoten.
	 */
	public static Book createBook(Element bookXML)
	{
		// Wir holen uns Inhalt des 'title' Knotens (die restlichen Informationen
		// werden analog aus dem XML Knoten gezogen)
		String title = bookXML.getElementsByTagName("title").item(0)
				.getTextContent().trim();
		String publisher = bookXML.getElementsByTagName("publisher").item(0)
				.getTextContent().trim();
		int edition = Integer.parseInt(bookXML.getElementsByTagName("editionNo")
				.item(0).getTextContent().trim());
		int publicationYear = Integer.parseInt(bookXML
				.getElementsByTagName("publicationYear").item(0).getTextContent()
				.trim());
		String isbn = bookXML.getElementsByTagName("ISBN").item(0).getTextContent()
				.trim();
		// das neue Buch wird mit den neuen Informationen erstellt
		Book buch = new Book(title, publisher, edition, publicationYear, isbn);

		// Nun ist der Autor an der Reihe
		NodeList authoreList = bookXML.getElementsByTagName("author");
		for (int i = 0; i < authoreList.getLength(); i++)
		{
			// Autor holen und erstellen ..
			Element autor = (Element) authoreList.item(i);
			// .. und dem Buch hinzufügen
			buch.addAuthor(createAutor(autor));
		}
		return buch;
	}

	/**
	 * Erzeugt einen neuen Author aus dem XML-Knoten
	 * 
	 * @param autorXML
	 * @return neuer Author
	 */
	public static Author createAutor(Element autorXML)
	{
		// Hier wird der Vorname über die Methode getChildNodes() (Alternative zu
		// getElementsByTagName()) besorgt
		String firstName = autorXML.getChildNodes().item(0).getTextContent();
		String lastName = autorXML.getChildNodes().item(1).getTextContent();
		Author autor = new Author(firstName, lastName);

		return autor;
	}
}
