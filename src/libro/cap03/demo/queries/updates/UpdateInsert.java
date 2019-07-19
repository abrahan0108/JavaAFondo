package libro.cap03.demo.queries.updates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Abrahán
 * Esta  clase muestra la sintaxis para realizar un insert en una 
 * base de datos, para este caso "Oracle"
 *
 */
public class UpdateInsert {
	// Preparo la URL y el driver de la base de datos
	static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String URL_BASEDATOS = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static void main (String[] args) {
		// preparo las credenciales de acceso a la base de datos
		String usuario = "dbadmin";
		String contrasenia = "dbadmin";
		
		// Preparo la conexión, la sentencia y en donde se guardan los resultados de la consulta
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			// -----------
			// * Paso 1 *
			// -----------
			
			// Se levanta el driver
			Class.forName(DRIVER);

			// Se realiza la conexión
			con = DriverManager.getConnection(URL_BASEDATOS, usuario, contrasenia);
			
			// -----------
			// * Paso 2 *
			// -----------
			
			// Preparo los queries
			String query = "";
			// se prepara el query
			pst = con.prepareStatement(query);
			// se ejecuta el query
			rs = pst.executeQuery();
			
			// Imprimo lo que se guardó en el ResultSet
			while(rs.next()) {
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// ----------
			// * Paso 3 *
			// ----------
			
			// Se cierran cada uno de los recursos en el orden inverso al que fueron abiertos
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
		
	}

}
