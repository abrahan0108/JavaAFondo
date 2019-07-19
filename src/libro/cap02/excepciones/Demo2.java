package libro.cap02.excepciones;

public class Demo2 {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			int i = Integer.parseInt("Estyo no es una cadena numérica...");
		} catch (Exception e) {
			System.out.println("Entré al catch!");
		} finally {
			System.out.println("Por aquí paso siempre...");
		}
	}
}
