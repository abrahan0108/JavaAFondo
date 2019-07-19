package libro.cap02.instancias;

import libro.cap02.misclases.FechaDetallada;

public class TestPersona {
	
	public static void main (String[] args) {
		
		Persona persona1 = new Persona("Juan"
				,"21773823",new FechaDetallada(23, 3, 1971));
		Persona persona2 = new Persona("Pablo"
				,"192344552",new FechaDetallada(12,6,1968));
		
		System.out.println(persona1);
		System.out.println(persona1);
		System.out.println(persona1);
		
		System.out.println("----------");
		
		System.out.println(persona2);
		System.out.println(persona2);
		
		System.out.println("----------");
		
		System.out.println(persona1);
		System.out.println(persona1);
	}

}
