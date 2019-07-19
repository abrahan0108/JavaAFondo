package libro.cap07.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI 
{

	public static void main(String[] args) throws Exception
	{
		// obtengo la referencia a la registry del servido (IP+PORT)
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
		
		 // ubico el objeto remoto identifificado por "OBJRemoto"
		ObjetoRemoto objRemoto;
		objRemoto = (ObjetoRemoto)reg.lookup("OBJRemoto");
		
		// invoco sus metodos como lo hago con cualquier otro objeto
		String saludo = objRemoto.obtenerSaludo("Abrahan");
		System.out.println(saludo);

	}

}
