
package libro.cap07.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetoRemotoImple extends UnicastRemoteObject implements ObjetoRemoto
{
	public ObjetoRemotoImple() throws RemoteException 
	{
		super();
	}

	@Override
	public String obtenerSaludo(String nombre) throws RemoteException {
		// TODO Auto-generated method stub
		return "Hola mundo RMI - "+nombre;
	}

}
