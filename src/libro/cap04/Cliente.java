package libro.cap04;

import java.util.Collection;
import java.util.Scanner;

/**
 * @author abrahan
 *	Esta clase Cliente muestra al usuario los departamentos y pide
 *	que seleccione un departamento para que muestre los empleados, cuenta con dos 
 *	metodos uno para obtener todos los departamentos y otro para obtener
 *	todos los empleados del departamento seleccionado
 */
public class Cliente {
	public static void main(String[] args) {
		FacadeLocalImple facade = new FacadeLocalImple();
		Collection<DeptDTO> collsDept = facade.obtenerDepartamentos();
		
		// muestro los departamentos
		_mostrarDepartamentos(collsDept);
		
		// pido al usuario que ingrese un departamento
		Scanner scanner = new Scanner(System.in);
		int deptno = scanner.nextInt();
		
		Collection<EmpDTO> collsEmp = facade.obtenerEmpleados(deptno);
		// muestro los empleados del departamento seleccionado
		_mostrarEmpleados(collsEmp, deptno);
	}
	
	/**
	 * @param collsDept recibe como argumento una coleccion que se instancia
	 * desde el facade
	 * muestra en primera instancia a todos los departamentos que 
	 * tenemos en la base de datos, por último pide que al usuario
	 * que seleccione un departamentos
	 */
	private static void _mostrarDepartamentos(Collection<DeptDTO> collsDept) {
		System.out.println("Departamentos:");
		System.out.println("--------------->");
		
		for(DeptDTO dto : collsDept) {
			System.out.println("| "+dto.getDeptno()+"\t");
			System.out.println("| "+dto.getDname()+"\t");
			System.out.println("| "+dto.getLoc()+"\t|");
		}
		System.out.println("<---------------");
		System.out.println("Ingrese deptno: ");
		
	}
	
	/**
	 * @param collsEmp instanciado desde el facade invoca uno de sus metodos
	 * para obtener una coleccion de empleados
	 * @param deptno pasa el departamento seleccionado por el usuario
	 * 
	 * el metodo muestra los empleados del departamento que se ha seleccionado
	 */
	private static void _mostrarEmpleados(Collection<EmpDTO> collsEmp, int deptno) {
		System.out.println("Empleados del departamento: "+deptno);
		System.out.println("--------------->");
		for (EmpDTO dto: collsEmp) {
			System.out.println("| "+dto.getEmpno()+"\t");
			System.out.println("| "+dto.getEname()+"\t");
			System.out.println("| "+dto.getHiredate()+"\t|");
		}
		System.out.println("<---------------");
	}
}
