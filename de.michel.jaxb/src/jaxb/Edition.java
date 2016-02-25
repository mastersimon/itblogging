package jaxb;

import javax.xml.bind.annotation.XmlElement;

public class Edition
{
  private String publisher;
  private int editionNo;
  private int publicationYear;

  public String getPublisher()
  {
    return publisher;
  }

  public void setPublisher(String publisher)
  {
    this.publisher = publisher;
  }

  public int getEditionNo()
  {
    return editionNo;
  }

  @XmlElement(name = "numberOfEdition")
  public void setEditionNo(int editionNo)
  {
    this.editionNo = editionNo;
  }

  public int getPublicationYear()
  {
    return publicationYear;
  }

  public void setPublicationYear(int publicationYear)
  {
    this.publicationYear = publicationYear;
  }
}
