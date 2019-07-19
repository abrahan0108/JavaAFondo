package libro.cap09;

import java.util.Enumeration;
import java.util.Hashtable;

public class TestHashTable 
{
	public static void main(String[] args) 
	{
		// instancio tres personas
		Persona p1 = new Persona("Pablo", 33, "Argentino");
		Persona p2 = new Persona("Juan", 25, "Mexicano");
		Persona p3 = new Persona("Pedro", 18, "Español");
		
		// Creo el HashTable como una tabla
		Hashtable<String, Persona> tabla = new Hashtable<String, Persona>();
		
		// Agrego las personas a la tabla
		tabla.put(p1.getNombre(), p1);
		tabla.put(p2.getNombre(), p2);
		tabla.put(p3.getNombre(), p3);
		
		// Acceso a cada elemento através de su nombre
		System.out.println(tabla.get("Pablo"));
		System.out.println(tabla.get("Juan"));
		System.out.println(tabla.get("Pedro"));
		
		// Acceso a un elemento que no existe para saber que devuelve (null)
		System.out.println(tabla.get("Rolo"));
		
		// obtengo una enumeracion de las clave existentes en la tabla,
		// la recorro y por cada una accedo al elemento asociado para
		// mostrar "clave = valor"
		String aux;
		Enumeration<String> keys = tabla.keys();
		
		while(keys.hasMoreElements()) 
		{
			aux = keys.nextElement();
			System.out.println(aux+" = "+tabla.get(aux));
		}
	}
}
