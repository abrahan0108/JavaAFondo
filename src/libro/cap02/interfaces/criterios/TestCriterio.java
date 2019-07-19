package libro.cap02.interfaces.criterios;
import libro.cap02.interfaces.Alumno;
import libro.cap02.interfaces.Util;

public class TestCriterio {
	public static void main(String[] args) {
		Alumno arr[] = { new Alumno("Martin", 25, 7.2)
					   , new Alumno("Carlos", 23, 5.1)
					   , new Alumno("Anastacio", 20, 4.8)};
		
		Util.ordenar(arr, new CriterioAlumNombre());
		Util.imprimir(arr);
		
		Util.ordenar(arr, new CriterioAlumNotaProm());
		Util.imprimir(arr);
	}

}
