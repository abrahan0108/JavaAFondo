package libro.cap02.colecciones;

import java.util.Scanner;

public class TestMiColeccion {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		// Esta colección no funciona ya que con la clase mi colección,
		// no se especifica el tipo de objeto que alojará el array
		// MiColeccion mc = new MiColeccion(5);
		
		System.out.println("Ingrese el primer nombre: ");
		String nom = scanner.next();
		
		// Se instancia una colección especializada en String
		MiColeccionGen<String> mc = new MiColeccionGen<String>(5);
		
		while(!nom.equals("FIN")) {
			
			mc.insertar(nom, 0);			
			nom = scanner.next();
			
		}
		
		String aux;
		
		for(int i = 0; i< mc.Cantidad(); i++) {
			// Ya no es necesario castear porque ya se especificó el tipo de retorno
			// ya se especificó
			//aux = (String) mc.obtener(i);			
			aux = mc.obtener(i);
			System.out.println(aux + " - " + aux.length() + " caracteres");
		}
		
	}

}
