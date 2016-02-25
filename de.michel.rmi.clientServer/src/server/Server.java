package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server 
{
	public static void main(String[] args) throws RemoteException 
	{
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        System.out.println("Server: Registry erfolgreich erzeugt.");
        
        
        
		
	}

}
