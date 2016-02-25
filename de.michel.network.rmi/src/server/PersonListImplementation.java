package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PersonListImplementation 
	extends UnicastRemoteObject 
	implements PersonListInterface
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Standardkonstruktor muss vorhanden sein
	public PersonListImplementation() throws RemoteException
	{}

	/**
	 * Implementierung des "PersonListInterface"
	 * Clientanfragen greifen über das Interface auf
	 *  diese (entfernte) Methode zu
	 */
	@Override
	public ArrayList<String> getPersonList() throws RemoteException
	{
		ArrayList<String> personList = new ArrayList<String>();
		
		personList.add("Simon Michel");
		personList.add("Peter Pan");
		personList.add("Pippi Langstrumpf");
		
		return personList;
	}
}