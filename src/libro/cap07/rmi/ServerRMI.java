package libro.cap07.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI 
{

	public static void main(String[] args) throws Exception
	{
		ObjetoRemotoImple obj = new ObjetoRemotoImple();
		Registry registry = LocateRegistry.getRegistry(1099);
		registry.rebind("OBJRemoto", obj);

	}

}
