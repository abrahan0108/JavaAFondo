package libro.cap02.colecciones;

import java.util.Collection;

public class TestVector {
	
	public static void main(String[] args) {
		// El método obtener lista retorna una coleccion
		Collection<String> coll = UNombres.obtenerLista();
		
		// itero la colección de nombres y muestro cada elemento
		for(String nom: coll) {
			System.out.println(nom);
		}
		
		
		/*Este es el código anterior, ya no se usa porque
		 * se ha implementado una nueva clase que nos devuelve
		 * el vector
		 * Vector<String> v = new Vector<String>();
		v.add("Pablo");
		v.add("Juan");
		v.addElement("Carlos");
		
		String aux;
		
		// Se recorre el vector guardando en aux el valor
		// que contiene la localidad visitada
		for(int i = 0; i<v.size();i++) {
			aux = v.get(i);
			System.out.println(aux);
		} 
		 * 
		 * */
		
	}

}
