package libro.cap09;

import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @author abrahan
 * Clase que muestra como usar hashtable sin sobre escribir
 * datos de un elemento de la tabla que tiene la misma clave
 * @param <T>
 */
public class Hashtable2 <T>
{
	// atributos de la clase
	private Hashtable<String, LinkedList<T>> tabla;
	private Vector<String> claves;
	
	/**
	 * Constructor que instancia sus atributos
	 */
	public Hashtable2() {

		tabla = new Hashtable<String, LinkedList<T>>();
		claves = new Vector<String>();
	}
	
	public String toString()
	{
		return claves.toString();
	}
	

	/**
	 * Agregamos elementos a la tabla
	 * @param key nombre clave del elemento de la tabla
	 * @param elm tipo de elemento o clase en este caso son personas
	 * 
	 * Cada que se invoque al método put cun una nueva clave, el Hashtable no 
	 * tendrá ningún elemento de este, por lo que se verifica en el if
	 * si existe alguno con esta clave y luego se agrega el elemento
	 * y si no existe se instancia una linkedlist, se agrega a la tabla
	 * y luego se agrega el elemento
	 */
	public void put(String key, T elm) 
	{
		LinkedList<T> lst = tabla.get(key);
		if(lst == null) 
		{
			lst = new LinkedList<T>();
			tabla.put(key, lst);
			claves.add(key);
		}
		lst.addLast(elm);
	}
	
	/**
	 * @param key clave con el cual se va a regresar un elemento de la lista
	 * @return el elemento de la lista que se solicita
	 */
	public LinkedList<T> get(String key)
	{
		return tabla.get(key);
	}
	
	/** Con este metodo se evita que salgan en un orden distinto
	 * al que fueron metidos en la cola, por lo que se va guardando en 
	 * un vector el orden, cada se invoca a put y se ingrsa un conjunto de
	 * datos nuevos se agrega a este Vector claves
	 * @return regresa un vector que guarda el orden en que fueron 
	 * ingresados a la cola
	 */
	public Collection<String> keys()
	{
		return claves;
	}
}
