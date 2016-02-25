package jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

// Property Reihenfolge mit "propOrder" bestimmen
@XmlType(propOrder = {"title", "isbn", "edition", "authors"})
public class Book
{
    private String title;
    private List<Author> authors;
    private Edition edition;
    private String isbn;

    public Book()
    {
      this.authors = new ArrayList<Author>();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void addAuthor(Author a)
    {
        authors.add(a);
    }

    @XmlElementWrapper(name = "authorlist")
    @XmlElement(name = "author")
    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setEdition(Edition edition)
    {
      this.edition = edition;
    }

    @XmlElement(name = "editionInfo")
    public Edition getEdition()
    {
        return edition;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
}
