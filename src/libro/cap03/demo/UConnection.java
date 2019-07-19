package libro.cap03.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class UConnection {
	
	private static Connection con = null;
	
	public static Connection getConnection() {
		try {
			if( con == null ) {
				// con esto determinamos cuando finalize el programa
				Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
				
				ResourceBundle rb = ResourceBundle.getBundle("jdbc");
				String driver = rb.getString("driver");
				String url = rb.getString("url");
				String pwd = rb.getString("pwd");
				String usr = rb.getString("usr");
				
				Class.forName(driver);
				con = DriverManager.getConnection(url, usr, pwd);
			}
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("Error al crear la conexión", e);
		}
	}
	
	static class MiShDwnHook extends Thread{
		// justo antes de finalizar el programa, la JVM invocará
		// a este método donde podemos cerrar la conexión
		public void run() {
			try {
				Connection con = UConnection.getConnection();
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}
	}

}
