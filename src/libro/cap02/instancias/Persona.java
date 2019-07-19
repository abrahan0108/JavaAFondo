package libro.cap02.instancias;

import libro.cap02.fechas.Fecha;
import libro.cap02.misclases.FechaDetallada;

public class Persona {
	
	private String nombre; //atributo
	private String dni; //atributo
	private Fecha fechaNacimiento; //atributo
	
	private int cont = 0; // variable de estado 
	
	public Persona(String nombre, String dni, FechaDetallada fechaNacimiento) {
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String toString() {
		cont++;
		return nombre + ", DNI" + dni
				+ ", nacido el: " + fechaNacimiento
				+ "(" + cont + ")";
	}
}
