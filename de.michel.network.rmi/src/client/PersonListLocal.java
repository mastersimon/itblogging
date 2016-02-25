package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import server.PersonListInterface;

public class PersonListLocal
{
	private static PersonListLocal instance;
	private PersonListInterface personList;

	/**
	 * mit Hilfe des Singleton Pattern wird 
	 * lediglich eine Instanz dieser Klasse erzeugt
	 */
	public static PersonListLocal getInstance()
	{
		if (instance == null)
		{
			instance = new PersonListLocal();
		}

		return instance;
	}

	private PersonListLocal()
	{
		try
		{
			// wir schauen uns nach dem lokal laufenden
			// Server mit dem Standardport 1099 um
			// da der Server lokal läuft, würde an 
			// dieser Stelle auch getRegistry() ausreichen
			Registry registry = LocateRegistry.getRegistry("localhost",
					Registry.REGISTRY_PORT);

			// die Personenliste wird über ihren eindeutigen
			// Namen aus der Registry abgerufen
			personList = (PersonListInterface) registry.lookup("PersonList");
		} catch (RemoteException e)
		{
			e.printStackTrace();
		} catch (NotBoundException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Liefert die auf dem Server befindliche Personenliste
	 */
	public ArrayList<String> getPersonList()
	{
		if (instance != null)
		{
			try
			{
				// über das Interface wird die Personenliste von dem Server geladen
				return personList.getPersonList();
			} catch (RemoteException e)
			{
				e.printStackTrace();
			}
		}

		// für den (unwahrscheinlichen) Fall das keine Instanz
		// existiert, wird eine leere Liste geliefert
		return new ArrayList<String>();
	}
}