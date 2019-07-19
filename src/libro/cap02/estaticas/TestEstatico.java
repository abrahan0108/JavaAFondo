package libro.cap02.estaticas;

public class TestEstatico {
	
	/*
	 * Para solucionar el error de acceso debemos definir la variable a y el método unMetodo como estáticos.
	 * La otra opción será crear dentro del método main una instancia de la clase y
	 * acceder a la variable y al método a través de esta,
	 * */
	
	private int a = 0;
	
	public void unMetodo() {
		System.out.println("Este es unMetodo();");
	}
	
	public static void main(String[] args) {
		
		// se define un objeto de la clase TestEstatico
		TestEstatico t = new TestEstatico();
		System.out.println("a vale: "+ t.a);
		t.unMetodo();
		
		/*
		
		// no se tiene aaceso a la variable a
		System.out.println("a vale: " + a);
		
		// no se tiene acceso al metodo unMetodo
		unMetodo();
		*/
		
	}

}
