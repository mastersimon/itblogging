package model;

import java.util.Vector;

public class Book
{

	private String title;
	private Vector authores;
	private String publisher;
	private int edition;
	private int publicationYear;
	private String isbn;

	public Book(String title, String publisher, int edition, int publicationYear,
			String isbn)
	{
		this.title = title;
		this.authores = new Vector();
		this.publisher = publisher;
		this.edition = edition;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	public void addAuthor(Author a)
	{
		authores.add(a);
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Vector getAuthores()
	{
		return authores;
	}

	public void setAuthores(Vector authores)
	{
		this.authores = authores;
	}

	public String getPublisher()
	{
		return publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public int getEdition()
	{
		return edition;
	}

	public void setEdition(int edition)
	{
		this.edition = edition;
	}

	public int getPublicationYear()
	{
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear)
	{
		this.publicationYear = publicationYear;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public String toString()
	{
		String author = "";
		for (int i = 0; i < authores.size(); i++)
		{
			author += authores.get(i).toString();
			if (i < authores.size() - 1)
			{
				author += ", ";
			}
		}

		return author + "\n" + "'" + title + "'" + "\n" + publisher + ", " + edition
				+ ". Auflage (" + publicationYear + ")" + "\n" + "ISBN " + isbn;
	}
}
