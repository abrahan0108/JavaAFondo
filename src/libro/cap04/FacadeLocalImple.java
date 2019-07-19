package libro.cap04;

import java.util.Collection;

/**
 * @author abrahan
 *	cuenta con dos métodos, los cuales obtienen departamentos y empleados de 
 *	departamento, el Facade accede a los DAO para no acceder directamente
 *	a la base de datos, se delega esta tarea a estos DAO (Data Access Object)
 */
public class FacadeLocalImple {
	
	public Collection<EmpDTO> obtenerUltimosEmpleados(int n){
		EmpDAO empDAO = (EmpDAO) UFactory.getInstancia("EMP");
		return empDAO.buscarUltimosEmpleados(n);
	}
	
	public Collection<DeptDTO> obtenerDepartamentos(){
		DeptDAO deptDAO = (DeptDAO) UFactory.getInstancia("DEPT");
		return deptDAO.buscarTodos();
	}
	
	public Collection<EmpDTO> obtenerEmpleados(int deptno){
		EmpDAO empDAO = (EmpDAO) UFactory.getInstancia("EMP");
		return empDAO.buscarXDept(deptno);
	}
}
