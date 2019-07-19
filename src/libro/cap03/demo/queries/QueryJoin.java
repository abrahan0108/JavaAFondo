package libro.cap03.demo.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryJoin {
	
	// Preparo los datos de la base de Oracle
	static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static void main(String[] args) {
		// Declaro las credenciales de acceso a la base de datos
		String usuario = "dbadmin";
		String contrasenia = "dbadmin";
		// Preparo los datos de conexión
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			
			// ------------
			// ** Paso 1 **
			// ------------
			
			// Levanto de Driver
			Class.forName(DRIVER);
			
			// Realizo la conexión a la base de datos
			connection = DriverManager.getConnection(URL, usuario, contrasenia);
			//System.out.println("Base de datos conectada");
			
			// ------------
			// ** Paso 2 **
			// ------------
			
			// Preparo los queries que se vayan a ejecutar
			String sql  = "SELECT EMP.EMPNO, EMP.ENAME , EMP.DEPTNO , DEPT.DNAME , DEPT.LOC FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO";
					/*sql += "SELECT ";
					sql += "E.EMPNO AS Numero_Empleado, ";
					sql += "E.ENAME AS Nombre_Empleado, ";
					sql += "E.DEPTNO AS Numero_Departamento, ";
					sql += "D.DNAME AS Nombre_Departamento, ";	
					sql += "D.LOC AS Localizacion_Departamento";
					sql += " FROM EMP E, DEPT D ";
					sql += "WHERE E.DEPTNO = D.DEPTNO";*/
			// Se prepara la sentencia
			pStatement = connection.prepareStatement(sql);
			// Se ejecuta y se obtienen los resultados
			resultSet = pStatement.executeQuery();
			
			// Se recorre lo que se recuperó en el resultset
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("EMPNO") + ", ");
				System.out.print(resultSet.getString("ENAME") + ",\t ");
				System.out.print(resultSet.getInt("DEPTNO") + ",\t ");
				System.out.print(resultSet.getString("DNAME") + ",\t ");
				System.out.println(resultSet.getString("LOC") );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			
			// ------------
			// ** Paso 3 **
			// ------------
			
			// hay que cerrar todos lo recursos en el orden iincerso al que fueron abiertos
			try {
				if(resultSet != null) resultSet.close();
				if(pStatement != null) pStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
			
		}
	}

}
