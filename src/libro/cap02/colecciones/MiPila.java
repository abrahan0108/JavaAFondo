package libro.cap02.colecciones;

public class MiPila<T> {
	
	// Lacapacidad Incial la harcodeamos en esta constante
	public static final int capacidadInicial = 5;
	
	//Intancio la colección que mantendrá  los datos de la pila
	private MiColeccionGen<T> coll = new MiColeccionGen<T>(capacidadInicial);
	
	// el método apilar recibe un parametro de tipo T
	public void apilar(T elm) {
		coll.insertar(elm, 0);
	}
	
	//El método desapilar retorna un elemento de tipo T
	public T desapilar() {
		return coll.eliminar(0);
	}

}
