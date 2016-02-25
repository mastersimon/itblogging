package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Client-Klasse mit Benutzeroberfl�che f�r Kommunikation mit Echo-Server.
 * 
 * @author Michael Buchner
 * @version Version 1, 20.12.2005
 */
public class EchoClient extends JFrame
{
   // Eingabeelemente mit klassenweitem Zugriff.
   private JTextField txtEingabe = new JTextField(30);
   private JTextField txtAusgabe = new JTextField(30);
   
   public EchoClient()
   {
      // Beschriftung der Kopfzeile der Benutzungsoberfl�che.
      super("EchoClient");
      
      // Anwendung wird bei Schlie�en der Oberfl�che beendet.
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      // FlowLayout zur Erzeugung eines 20 Pixel breiten Au�enrandes.
      setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
      
      JPanel pnlInhalt = new JPanel(new BorderLayout(10, 10));
      add(pnlInhalt);

      // Linke Spalte mit Beschriftungen.
      JPanel pnlBeschriftung = new JPanel(new GridLayout(2, 1, 5, 5));
      pnlInhalt.add(pnlBeschriftung, BorderLayout.WEST);
      pnlBeschriftung.add(new JLabel("Eingabe : ", JLabel.RIGHT));
      pnlBeschriftung.add(new JLabel("Ausgabe : ", JLabel.RIGHT));
      
      // Rechte Spalte mit Ein-/Ausgabeelementen.
      JPanel pnlEingabe = new JPanel(new GridLayout(2, 1, 5, 5));
      pnlInhalt.add(pnlEingabe, BorderLayout.EAST);
      pnlEingabe.add(txtEingabe);
      // Registrierung des Ereignisverarbeiters, wird ausgel�st bei
      // Bet�tigung der ENTER-Taste.
      txtEingabe.addActionListener(new Sender());
      pnlEingabe.add(txtAusgabe);
      
      // Gr��e der Oberfl�che festlegen und sichtbar machen.
      pack();
      setVisible(true);
   }
   
   /**
    * Startmethode f�r Client des Echo-Servers.
    * 
    * @param args Kommandozeilenparameter, werden nicht verwendet.
    */
   public static void main(String[] args)
   {
      // Client-Objekt mit Benutzungsoberfl�che erzeugen.
      new EchoClient();
   }
   
   /**
    * Innere Klasse f�r Ereignisverarbeitung mit Zugriff auf die Eingabeelemente
    * der Benutzungsoberfl�che.
    *
    * @author Michael Buchner
    * @version Version 1, 20.12.2005
    */
   private class Sender implements ActionListener
   {
      /**
       * Callback-Methode, wird bei Bet�tigung der ENTER-Taste im Eingabefeld aufgerufen.
       * 
       * @param e Das Ereignisobjekt, wird nicht verwendet.
       * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
       */
      public void actionPerformed(ActionEvent e)
      {
         try
         {
            // Aufbau der Verbindung zum Server.
            // Der Server wird auf demselben Rechner erwartet.
            Socket socket = new Socket(InetAddress.getLocalHost(), EchoServer.SERVERPORT);
            System.out.println("EchoClient: Socket erzeugt");
            
            // Ausgabestrom vom Socket abholen, wird verbunden mit dem Eingabestrom
            // auf Server-Seite.
            OutputStream ausgabeStrom = socket.getOutputStream();
            // Objekt-Ausgabestrom erzeugen.
            ObjectOutputStream objektAusgabeStrom = new ObjectOutputStream(ausgabeStrom);
            // Zu sendenden String vom Textfeld abholen.
            String zuSenden = txtEingabe.getText();
            System.out.println("EchoClient: zu senden : " + zuSenden);
            // String-Objekt an Server serialisiert versenden.
            objektAusgabeStrom.writeObject(zuSenden);
            // Objekt-Ausgabestrom nachsp�len um dden Puffer zu entleeren und
            // das Objekt vollst�ndig zum Server zu versenden.
            objektAusgabeStrom.flush();
            
            // Eingabestrom vom Socket abholen, wird verbunden mit dem Ausgabestrom
            // auf Server-Seite.
            InputStream eingabeStrom = socket.getInputStream();
            // Objekt-Eingabestom erzeugen.
            ObjectInputStream objektEingabeStrom = new ObjectInputStream(eingabeStrom);
            // String-Objekt vom Server abholen.
            String empfangen = (String) objektEingabeStrom.readObject();
            System.out.println("EchoClient: empfangen : " + empfangen);
            // String-Objekt in Textfeld schreiben.
            txtAusgabe.setText(empfangen);
            
            // Verbindung mit Server schlie�en.
            socket.close();
         }
         catch(UnknownHostException exc)
         {
            exc.printStackTrace();
         }
         catch(IOException exc)
         {
            exc.printStackTrace();
         }
         catch(ClassNotFoundException exc)
         {
            exc.printStackTrace();
         }
      }
   }
}
