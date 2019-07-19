package libro.cap09;

import java.util.Collection;
import java.util.LinkedList;

public class TestHashTable2 {
	
	public static void main(String[] args) 
	{
		// Instancio un hashtable de mi clase Hashtable2		
		Hashtable2<Integer> ht = new Hashtable2<Integer>();
		
		// Agrego elementos a mi tabla
		ht.put("par", 2);
		ht.put("par", 4);
		ht.put("par", 6);
		ht.put("impar", 1);
		ht.put("par", 8);
		ht.put("impar", 3);
		ht.put("impar", 5);
		ht.put("par", 10);
		ht.put("impar", 7);
		ht.put("impar", 9);
		
		// guado todos los elementos pares en una lista enlazada
		// y lo recorro
		LinkedList<Integer> pares = ht.get("par");
		for(Integer i:pares) 
		{
			System.out.println(i);
		}
		
		// Guardo todos los elementos impares en una lista enlazada
		// y recorro la lista imprimiendolos en consola
		LinkedList<Integer> impares= ht.get("impar");
		for(Integer i: impares)
		{
			System.out.println(i);
		}
		
		// Genero una colección de los keys de mi Hashtable
		// y lo muestro por consola
		Collection<String> keys = ht.keys();
		for(String k:keys) 
		{
			System.out.println(k);
		}
	}
}
