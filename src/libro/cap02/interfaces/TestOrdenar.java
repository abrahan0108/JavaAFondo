package libro.cap02.interfaces;

public class TestOrdenar {	
	
	public static void main(String[] args) {
		// Se define el array de alumno
		Alumno arr[] = { new Alumno("Juan", 20, 8.5)
					   , new Alumno("Pedro", 18, 5.3)
					   , new Alumno("Alberto", 19, 4.6)};
		//Util.ordenar(arr);
		muestraArray(arr);
		
		// defino, ordeno y muetro un array de strings
		String[] arr2 = {"Pablo", "Andrés", "Marcelo"};
		//Util.ordenar(arr2);
		muestraArray(arr2);
		
		// defino, ordeno y muestro un array de integers
		Integer[] arr3 = { new Integer(5)
						 , new Integer(3)
						 , new Integer(1)};
		///Util.ordenar(arr3);
		muestraArray(arr3);
	}

	@SuppressWarnings({"rawtypes"})
	private static void muestraArray(Comparable arr[]) {
		for(int i = 0; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}
	
}
