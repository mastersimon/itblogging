package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server-Klasse f�r einen Echo-Server auf Basis des TCP-Protokolls.
 * 
 * @author Michael Buchner
 * @version Version 1, 20.12.2005
 */
public class EchoServer
{
   /** gemeinsame Portnummer f�r Server und Client */
   public static int SERVERPORT = 3000;

   /**
    * Startmethode f�r den Server-Teil des Echo-Servers.
    * 
    * @param args Kommandozeilenparameter, werden nicht verwendet
    */
   public static void main(String[] args)
   {
      try
      {
         // Einmalig ServerSocket erzeugen.
         ServerSocket serversocket = new ServerSocket(SERVERPORT);
         
         // Endlosschleife �ber die Client-Anfragen.
         while(true)
         {
            System.out.println("EchoServer: warte auf Nachricht");
            // Anfrage vom Client annehmen.
            Socket socket = serversocket.accept();
            
            // Eingabestrom vom Socket holen
            InputStream eingabeStrom = socket.getInputStream();
            // Objekt-Eingabestrom f�r serialisiertes Objekt erzeugen.
            ObjectInputStream objektEingabeStrom = new ObjectInputStream(eingabeStrom);
            // Serialisiertes String-Objekt abholen, dabei warten,
            // bis das Objekt geschickt wurde.
            String eingabe = (String) objektEingabeStrom.readObject();
            System.out.println("EchoServer: empfangen : " + eingabe);
            
            // Im vom Client empfangenen String alle Kleinbuchstaben
            // in Gro�buchstaben umwandeln.
            String ausgabe = eingabe.toUpperCase();
            // Ausgabestrom vom Socket holen.
            OutputStream ausgabeStrom = socket.getOutputStream();
            // Objekt-Ausgabestrom f�r serialisiertes Objekt erzeugen.
            ObjectOutputStream objektAusgabeStrom = new ObjectOutputStream(ausgabeStrom);
            // String-Objekt serialisiert versenden.
            objektAusgabeStrom.writeObject(ausgabe);
            // Ausgabekanal nachsp�len.
            objektAusgabeStrom.flush();
            System.out.println("EchoServer: versendet : " + ausgabe);
            
            // Socket schlie�en.
            socket.close();
         }
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
      catch(ClassNotFoundException e)
      {
         e.printStackTrace();
      }
   }
}
