package libro.cap09;

public class TestPila {
	public static void main(String[] args) 
	{
		// instancio una pila
		Pila<Integer> pila = new Pila<Integer>();
		
		// lleno la pila
		pila.apilar(3);
		pila.apilar(2);
		pila.apilar(1);
		
		// imprimo el contenido de la pila
		System.out.println(pila.desapilar().getInfo());
		System.out.println(pila.desapilar().getInfo());
		System.out.println(pila.desapilar().getInfo());
		
	}

}
