package libro.cap09;

public class TestCola {
	public static void main(String[] args) 
	{
		// instancio una cola
		Cola1<Integer> cola = new Cola1<Integer>();
		
		// Agrego elementos a la cola
		cola.encolar(1);
		cola.encolar(2);
		cola.encolar(3);
		cola.encolar(4);
		cola.encolar(5);
		
		// desencolo los elementos y los imprimo en consola
		System.out.println(cola.desencolar().getInfo());
		System.out.println(cola.desencolar().getInfo());
		System.out.println(cola.desencolar().getInfo());
		System.out.println(cola.desencolar().getInfo());
		System.out.println(cola.desencolar().getInfo());
	}

}
