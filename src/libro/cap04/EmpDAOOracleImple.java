package libro.cap04;

public class EmpDAOOracleImple extends EmpDAO{
	@Override
	protected String queryBuscarUltimosEmpleados() {
		// TODO Auto-generated method stub
		String sql = "";
		sql+="SELECT empno, ename, hiredate, deptno, ROWNUM AS rn ";
		sql+="FROM (SELECT empno, ename, hiredate, deptno ";
		sql+="		FROM emp ";
		sql+="		ORDER BY hiredate DESC) ";
		sql+="WHERE rm <=?";
		return sql;
	}
}
