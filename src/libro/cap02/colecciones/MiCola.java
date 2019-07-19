package libro.cap02.colecciones;

public class MiCola<T> {
	
	private static final int capacidadInicial = 5;
	private MiColeccionGen<T> coll = new MiColeccionGen<T>(capacidadInicial);
	
	public void encolar(T elem) {
		
		// Agregar el elemento al final de la colección
		coll.Agregar(elem);		
	}
	
	public T desencolar() {
		// Retorna y elimina de la colección el primer elemento
		return coll.eliminar(0);
	}

}
