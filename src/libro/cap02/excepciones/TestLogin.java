package libro.cap02.excepciones;

public class TestLogin {
	public static void main(String[] args) {
		try {
			Aplicacion app = new Aplicacion();
			
			// intento el login
			Usuario u = app.login("juan", "juan123sito");
			
			if(u == null) {
				System.out.println("Usuario o password incorrectos");
			}else {
				System.out.println("Felicidades, lo lograste");
				System.out.println("nombre: " +u.getNombre());
				System.out.println("Email: " + u.getEmail());
			}
			
			// muestro el resultado
			System.out.println(u);
			} catch (ErrorFisicoException e) {
			// Ocurrió un error
				System.out.println("Servicio temporalmente interrumpido :");
				System.out.println(e.getMessage());
		}
	}

}
