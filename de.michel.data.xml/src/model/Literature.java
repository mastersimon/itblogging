package model;

import java.util.Vector;

public class Literature
{
	private Vector books;

	public Literature()
	{
		books = new Vector();
	}

	public void addBook(Book b)
	{
		books.add(b);
	}

	public Vector getBooks()
	{
		return books;
	}

	public String toString()
	{
		String result = "";
		for (int i = 0; i < books.size(); i++)
		{
			result += books.get(i) + "\n" + "\n";
		}
		return result;

	}
}
