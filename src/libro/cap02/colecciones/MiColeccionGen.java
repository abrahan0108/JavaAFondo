package libro.cap02.colecciones;

public class MiColeccionGen<T>{
	
	private Object datos[] = null;
	private int len = 0;
	
	// en el constructor se especifica la cantidad inicial
	public MiColeccionGen(int capacidadInicial) {
		datos = new Object[capacidadInicial];
	}
	
	// retorna el i-esimo elemento de la colección
	@SuppressWarnings("unchecked")
	public T obtener(int i) {
		return (T)datos[i];
	}
	
	// Indica cuantos elemtos tiene la colección
	public int Cantidad() {
		return len;
	}
	
	public void insertar(T elm, int i) {
		if(len == datos.length) {
			Object aux[] = datos;
			datos = new Object[datos.length*2];
			for(int j = 0;  j<len; j++) {
				datos[j] = aux[j];
			}
			aux = null;
		}
		
		for(int j=len-1; j>=i; j--) {
			datos[j+1] = datos[j];
		}
		
		datos[i]=elm;
		len++;
		
	}
	
	public int Buscar(T elm) {
		int i = 0;
		
		// Mientras no me pase del tope y mientras no se encuentre...
		for(;i<len && !datos[i].equals(elm); i++);
			
		// Si no me pase, etonces encontré, si no... no encontre
		return i<len ? i: -1;
	}
	
	public void Agregar(T elm) {
		insertar(elm, len);
	}
	
	// elimina un elemento desplazando los demas hacia arriba
	@SuppressWarnings("unchecked")
	public T eliminar(int i) {
		Object aux = datos[i];
		for(int j=i ; j<len-1 ; j++) {
			datos[j] = datos[j+1];
		}
		len--;
		return (T)aux;
	}

}
