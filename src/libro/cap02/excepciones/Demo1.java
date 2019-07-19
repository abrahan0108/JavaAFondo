package libro.cap02.excepciones;

public class Demo1 {
	public static void main(String[] args) {
		try {
			System.out.println("Hola, adios!");
			return;
		} catch (Exception e) {
			System.out.println("Entré al catch");
		} finally {
			System.out.println("Por quí siempre voy a pasar");
		}
	}

}
