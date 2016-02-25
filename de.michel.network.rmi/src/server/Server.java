package server;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{

	/**
	 * Registriert den Server mit dem ihn 
	 * bekannten öffentlichen Methoden
	 */
	private static void createServer()
	{
		try
		{
			// Namensdienst (Registry) mit dem Standardport 1099 registrieren
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			System.out.println("Server : Registry wurde erzeugt.");

			// Personenliste wird in der Registry unter 
			// dem eindeutigen Namen "PersonList" angemeldet
			Naming.rebind("PersonList", new PersonListImplementation());
			System.out.println("Server : Personenliste registriert");

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		createServer();
	}
}