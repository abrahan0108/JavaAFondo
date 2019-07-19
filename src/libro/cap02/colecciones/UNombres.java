package libro.cap02.colecciones;

import java.util.ArrayList;
import java.util.Collection;
//import java.util.Vector;

public class UNombres {
	
	public static Collection<String> obtenerLista(){
		
		ArrayList<String> v = new ArrayList<String>();
		/*Es posible implementar un ArrayList si no nos
		 * terminan de convencer lo métodos de la clase Vector
		 * Vector<String> v = new Vector<String>();*/
		v.add("Pablo");
		v.add("Juan");
		v.add("Carlos");
		return v;
	}

}
