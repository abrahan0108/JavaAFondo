package libro.cap04;

/**
 * @author abrahan
 *	Esta clase de objetos tienen como función representar los atributos de 
 *	las tablas de las bases de datos a la cuales accedemos con el DAO, tiene los
 *	mismos atributos que cada tabla de la base de datos y además debe de contar con sus 
 *	métodos getters y setters
 */
public class DeptDTO {
	
	private int deptno;
	private String dname;
	private String loc;
	
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String toString() {
		return deptno + ", " +dname+ ", " +loc;
	}

}
