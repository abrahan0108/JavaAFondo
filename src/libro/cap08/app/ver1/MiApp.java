package libro.cap08.app.ver1;

import java.util.Collection;
import java.util.Scanner;

import libro.cap04.DeptDTO;
import libro.cap04.EmpDTO;
import libro.cap04.Facade;
import libro.cap04.UFactory;

public class MiApp {

	public static void main(String[] args) {
		// instancio el facade a través del factory method
		Facade facade = (Facade)UFactory.getInstancia("FACADE");
		Collection<DeptDTO> collDepts = facade.obtenerDepartamentos();
		_mostrarDepartamentos(collDepts);
		
		Scanner scanner = new Scanner(System.in);
		int deptno = scanner.nextInt();
		
		Collection<EmpDTO> collEmps = facade.obtenerEmpleados();
		_mostrarEmpleados(collEmps, deptno);

	}
	
	private static void _mostrarDepartamentos(Collection<DeptDTO> collDepts)
	{
		System.out.println("Departamentos: ");
		System.out.println("-------------------->");
		for(DeptDTO dto: collDepts)
		{
			System.out.print("| "+dto.getDeptno()+"\t");
			System.out.print("| "+dto.getDname()+"\t");
			System.out.println("| "+dto.getLoc()+"\t|");
		}
		System.out.println("<--------------------");
		System.out.print("Ingrese deptno: ");
		
	}	
	
	private static void _mostrarEmpleados(Collection<EmpDTO> collEmps, int deptno)
	{
		System.out.println("Empleados del departamento: "+deptno);
		System.out.println("-------------------->");
		for(EmpDTO dto: collEmps)
		{
			System.out.print("| "+dto.getEmpno()+"\t");
			System.out.print("| "+dto.getEname()+"\t");
			System.out.println("| "+dto.getHiredate()+"\t|");
		}
		System.out.println("<--------------------");
	}

}
