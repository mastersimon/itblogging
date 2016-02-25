package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PersonListInterface extends Remote
{
	/**
	 * Liefert die Personenliste in einer ArrayList.
	 * Diese Interface wird sowohl vom Server
	 * als auch vom Client angesprochen
	 */
	public ArrayList<String> getPersonList() throws RemoteException;
}