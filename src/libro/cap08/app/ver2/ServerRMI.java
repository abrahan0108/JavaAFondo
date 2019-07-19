package libro.cap08.app.ver2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {
	public static void main(String[] args) throws Exception {
		FacadeRemotoImple f = new FacadeRemotoImple();
		Registry registry = LocateRegistry.getRegistry(1099);
		
		registry.rebind("FacadeRemoto", f);
	}

}
