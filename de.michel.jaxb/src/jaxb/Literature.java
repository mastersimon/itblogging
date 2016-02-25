package jaxb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

// Angabe des Root Elements. Optional kann der namespace -sofern er vorhanden
// ist- angegeben werden.
@XmlRootElement(namespace = "http://www.itblogging.de/myNameSpace")
@XmlType(propOrder = {"currentTime", "bookList"})
public class Literature
{
  private List<Book> bookList;
  private Date currentTime;
  private String version;

  public Literature()
  {
    this.bookList = new ArrayList<Book>();
  }

  // Der Wrapper soll "booklist" heiﬂen
  @XmlElementWrapper(name = "booklist")
  // und die einzelnen Elemente jeweils "book"
  @XmlElement(name = "book")
  public List<Book> getBookList()
  {
    return bookList;
  }

  // explizite Typenangabe
  @XmlSchemaType(name = "dateTime")
  public Date getCurrentTime()
  {
    return currentTime;
  }

  public void setCurrentTime(Date currentTime)
  {
    this.currentTime = currentTime;
  }

  // Die Version soll ein Attribut des RootElements sein
  @XmlAttribute
  public String getVersion()
  {
    return version;
  }

  public void setVersion(String version)
  {
    this.version = version;
  }
}