package libro.cap02.excepciones;

import java.util.ResourceBundle;

public class Aplicacion {
	public Usuario login(String usrname, String password) throws ErrorFisicoException {
		
		try {
			// Se lee el archivo de propiedades que debe estar ubicado en el 
			// package root
			ResourceBundle rb = ResourceBundle.getBundle("usuario");
			
			// leemos el valor de la propiedad usrname
			String usr = rb.getString("usrname");
			
			// leemos el valor de la propiedad password
			String pwd = rb.getString("password");
			
			// Se define una variable de retorno
			Usuario u = null;
			
			//si coinciden los datos proporcionados con los leidos
			if(usr.equals(usrname) && pwd.equals(password)) {
				
				//intancio y seteo todos los datos
				u = new Usuario();
				u.setUsuario(usr);
				u.setPassword(pwd);
				u.setNombre(rb.getString("nombre"));
				u.setEmail(rb.getString("email"));
			}
			
			// retorno la instancia o null si no entró al if
			return u;
			
			}catch (Exception e) {
			// Cualquier error "salgo por excepcion"
				throw new RuntimeException("Error verificando datos", e);
		}		
	}

}
