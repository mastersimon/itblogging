package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface CustomerInterface extends Remote
{
	/**
	 * Liefert die Kundenliste
	 * @return Kundenliste
	 * @throws RemoteException
	 */
	public Vector<Customer> getCustomer() throws RemoteException;
}
