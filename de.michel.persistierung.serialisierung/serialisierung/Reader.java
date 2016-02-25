package serialisierung;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reader
{

	public static void main(String[] args)
	{
		try
		{
			// Serialisiertes Objekt
			FileInputStream inputStream = new FileInputStream("data.ser");
			// Deserialisierung
			ObjectInputStream objectInput = new ObjectInputStream(inputStream);
			// String auslesen
			String text = (String) objectInput.readObject();
			// Datum auslesen
			Date date = (Date) objectInput.readObject();
			// Datumsformatierer
			DateFormat formatter = new SimpleDateFormat(); 
			
			System.out.println(text);
			System.out.println("Diese Datei wurde erstellt am: " + formatter.format(date));
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

}