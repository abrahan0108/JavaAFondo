package libro.cap04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import libro.cap03.demo.UConnection;

public abstract class EmpDAO {
	// cada implementación debe de sobrescribir este metodo
	// y retornar el SQL propietario
	protected abstract String queryBuscarUltimosEmpleados();

	// este metodo ya no necesita se abstracto porque
	// puede obtener el query invocando al metodo
	// abstracto queryBuscarUltimosEmpleados
	public Collection<EmpDTO> buscarUltimosEmpleados(int n){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con  = UConnection.getConnection();
			
			String sql = queryBuscarUltimosEmpleados();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, n);
			
			rs = pstm.executeQuery();
			
			Vector<EmpDTO> ret = new Vector<EmpDTO>();
			EmpDTO dto = null;
			
			while(rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setDeptno(rs.getInt("deptno"));
				ret.add(dto);
			}
			return ret;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e); 
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}	
	
	public Collection<EmpDTO> buscarXDept(int deptno){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = UConnection.getConnection();
			String sql = "";
			sql+="SELECT empno, ename, hiredate, deptno ";
			sql+="FROM emp ";
			sql+="WHERE deptno = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, deptno);
			rs = pstm.executeQuery();
			
			Vector<EmpDTO> ret = new Vector<EmpDTO>();
			EmpDTO dto = null;
			
			while (rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setDeptno(rs.getInt("deptno"));
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
