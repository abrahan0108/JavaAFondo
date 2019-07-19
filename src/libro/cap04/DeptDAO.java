package libro.cap04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import libro.cap03.demo.UConnection;

/**
 * @author abrahan
 *	Los DAO (Data Access Object) generan la coneccion a la base de datos (encapsula los SQL)
 *	ejecutando un query dentro de esta; en este caso genera todo el proceso de la coneccion
 *	invocando una clase que ya generó en un paquete anterior UConnection, que está
 *	escrito con un patrón Singleton Pattern que hace una sola conexión, únicamente se
 *	reutiliza.
 *	con try se ejecuta la conección, la ejecución de los queries y retorna el resultado en
 *	forma de un vector.
 *	El catch muestra si existe un error
 *	El finally cierra el resultset y nuestras sentencias sql si están abiertas
 */
public class DeptDAO {
	public Collection<DeptDTO> buscarTodos(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = UConnection.getConnection();
			String sql =  "SELECT deptno, dname, loc FROM dept";
			
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			Vector<DeptDTO> ret = new Vector<DeptDTO>();
			DeptDTO dto = null;
			
			while(rs.next()) {
				dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				ret.add(dto);
			}
			
			return ret;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}

}
