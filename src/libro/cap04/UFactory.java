package libro.cap04;

import java.util.Hashtable;
import java.util.ResourceBundle;

/**
 * @author abrahan
 *	Esta clase es forma parte de un patrón de diseño que usa un archivo 
 *	de tipo properties para buscar sobre cual base de datos trabajar
 */
public class UFactory {
	private static Hashtable<String,Object> instancias = new Hashtable<String, Object>();
	public static Object getInstancia(String objName) {
		try {
			// verifico si existe un objeto relacionado a objName
			// en el hashtable
			Object obj = instancias.get(objName);
			
			// si no existe entonces lo instancio y lo agrego
			if (obj == null) {				
				ResourceBundle rb = ResourceBundle.getBundle("factory");
				String sClassname = rb.getString(objName);
				obj = Class.forName(sClassname).newInstance();
				
				// agrego el objeto al hashtable
				instancias.put(objName, obj);
			}
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
