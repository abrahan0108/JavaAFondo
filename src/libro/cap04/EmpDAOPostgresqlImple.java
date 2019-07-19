package libro.cap04;

public class EmpDAOPostgresqlImple extends EmpDAO{
	@Override
	protected String queryBuscarUltimosEmpleados() {
		// TODO Auto-generated method stub
		String sql = "";
		sql+="SELECT empno, ename, hiredate, deptno ";
		sql+="FROM emp ";
		sql+="ORDER BY hiredate DESC ";
		sql+="LIMIT ?";
		return sql;
	}

}
