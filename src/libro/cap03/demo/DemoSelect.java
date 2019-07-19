package libro.cap03.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoSelect {
	
	static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String URL_BASEDATOS = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static void main(String[] args) {
		// Se declaran los parámetos de la conexión
		String usr = "dbadmin";
		String pwd = "dbadmin";

		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			// --------------
			// ** PARTE 1 **
			// --------------
			// Se tiene que levantar el driver
			
			Class.forName(DRIVER);
						
			// Se establece la conexión
			
			con = DriverManager.getConnection(URL_BASEDATOS, usr, pwd);
			System.out.println("Base de datos conectada");
			// --------------
			// ** PARTE 2 **
			// --------------
			
			// Defino un query
			String sql = "SELECT * FROM emp";
			
			// Preparo la sentencia que se va a ejecutar
			pstm = con.prepareStatement(sql);
			
			// Ejecuto la sentencia y obtengo los resultados en rs
			rs = pstm.executeQuery();
			
			// Itero los resultados (los registros)
			while(rs.next()) {
				// Muestro los campos del registro actual
				System.out.print(rs.getInt("empno")+", ");
				System.out.print(rs.getString("ename")+", ");
				System.out.print(rs.getDate("hiredate")+", ");
				System.out.println(rs.getInt("deptno") );
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				// --------------
				// ** PARTE 3 **
				//
				
				// Cierro todos los recursos en orden inverso al que fueron adquiridos
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(con != null) con.close();
				} catch (Exception e2) {
				// TODO: handle exception
					e2.printStackTrace();
					throw new RuntimeException(e2);
			}
		}
	}

}
