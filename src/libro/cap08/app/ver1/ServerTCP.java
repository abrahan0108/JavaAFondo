package libro.cap08.app.ver1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

import libro.cap04.DeptDAO;
import libro.cap04.DeptDTO;
import libro.cap04.EmpDAO;
import libro.cap04.EmpDTO;
import libro.cap04.UFactory;

public class ServerTCP extends Thread
{
	public static final int OBTENER_DEPARTAMENTOS = 1;
	public static final int OBTENER_EMPLEADOS = 2;
	
	private Socket socket = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;

	public ServerTCP(Socket s) 
	{
		this.socket = s;
	}

	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(5433);
		Socket s;
		
		while(true) {
			s = ss.accept();
			new ServerTCP(s).start();
		}

	}
	
	public void run() 
	{
		try 
		{
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			// leo el código de servicio
			int codSvr = dis.readInt();
			switch (codSvr) 
			{
			case OBTENER_DEPARTAMENTOS:
				_obtenerDepartamentos(dis,dos);
				break;
			case OBTENER_EMPLEADOS:
				_obtenerEmpleados(dis,dos);
				break;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			try {
				if(dis != null) dis.close();
				if(dos != null) dos.close();
				if(socket != null) socket.close(); 
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
	
	public void _obtenerDepartamentos(DataInputStream dis, DataOutputStream dos) 
	{
		try {
			DeptDAO dao = (DeptDAO) UFactory.getInstancia("DEPT");
			// obtengo la coleccion de departamentos
			Collection<DeptDTO> coll = dao.buscarTodos();
			// envio el size al cliente
			int size = coll.size();
			dos.writeInt(size);
			
			// envio la coleccion de departamentos
			for(DeptDTO dto: coll) 
			{
				dos.writeUTF(dto.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void _obtenerEmpleados(DataInputStream dis, DataOutputStream dos) 
	{
		try {
			EmpDAO dao = (EmpDAO)UFactory.getInstancia("EMP");
			
			// leo el deptno
			int deptno = dis.readInt();
			
			// obtengo la coleccion de empleados
			Collection<EmpDTO> coll = dao.buscarXDept(deptno);
			
			// envio el size al cliente
			int size = coll.size();
			dos.writeInt(size);
			
			// envio la coleccion de empleados
			for(EmpDTO dto: coll)
			{
				dos.writeUTF(dto.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
