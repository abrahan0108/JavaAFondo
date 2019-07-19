package libro.cap04;

import java.util.Collection;

public class TestDeptDAO {
	public static void main(String[] args) {
		// instancia un DTO
		DeptDAO dept = new DeptDAO();
		
		// le pido la colección de todos los departamentos
		Collection<DeptDTO> coll = dept.buscarTodos();
		
		// itero la coleccion y muestro cada departamento (cada dto)
		for(DeptDTO dto:coll) {
			System.out.println(dto);
		}
	}
}
