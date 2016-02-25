package serialisierung;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;

public class Writer
{

	public static void main(String[] args)
	{
		OutputStream outputStream = null;
		try
		{
			// Byteorientierten Ausgabekanal Öffnen
			outputStream = new FileOutputStream("data.ser");

			// Objektausgabekanal für Serialisierung Öffnen
			ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);

			// String-Objekt serialisiert in Datei ausgeben
			objectOutput.writeObject("Java ist die Zukunft!");
			objectOutput.writeObject(new Date());

			// Ausgabekanal schließen
			objectOutput.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				outputStream.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}