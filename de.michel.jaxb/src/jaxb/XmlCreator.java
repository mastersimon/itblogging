package jaxb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.xml.bind.JAXB;

public class XmlCreator
{
  public static void main(String[] args) throws IOException
  {
    Literature literature = createLiterature();

    // Konsolenausgabe
    JAXB.marshal(literature, System.out);

    // Dateiname (wird in dem Projektverzeichnis hinterlegt)
    String fileName = "literatur.xml";

    // Speicherung in Datei
    Writer fileWriter = new FileWriter(fileName);
    JAXB.marshal(literature, fileWriter);
    fileWriter.close();

    // Aus Datei lesen
    Literature backToObject = JAXB.unmarshal(new File(fileName), Literature.class);

    System.out.println("\nVersion: " + backToObject.getVersion());
    System.out.println("Datum: " + backToObject.getCurrentTime());
    System.out.println("---");
    for(Book book : backToObject.getBookList())
    {
      System.out.println("Titel: " + book.getTitle());
      System.out.println("ISBN: " + book.getIsbn());
      // ....
    }
  }

  // Erzeugt das Literaturverzeichnis
  private static Literature createLiterature()
  {
    Literature literature = new Literature();
    literature.setCurrentTime(new Date());
    literature.setVersion("0.1");

    // Book
    Book book = new Book();
    book.setIsbn("3-89842-488-X");
    book.setTitle("Einstieg in XML");

    // Edition
    Edition edition = new Edition();
    edition.setEditionNo(2);
    edition.setPublicationYear(2004);
    edition.setPublisher("Galileo Computing");
    book.setEdition(edition);

    // Author
    Author author = new Author();
    author.setFirstName("Helmut");
    author.setLastName("Vonhoegen");
    book.getAuthors().add(author);

    // Buch hinzufügen
    literature.getBookList().add(book);

    return literature;
  }
}
