package libro.cap07;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		Socket s = null;
		ServerSocket ss = new ServerSocket(5433);
		
		while(true) {
			try {
				// el ServerSocket me da el socket
				s = ss.accept();
				
				// informacion en la consola
				System.out.println("Se conectaron desde la IP: "+s.getInetAddress());
				
				// enmascaro la entrada y la salida de bytes
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
				
				// leo el nombre que envia el cliente
				String nom = (String)ois.readObject();
				
				// armo el saludo personalizado que le quiero enviar al cliente
				String saludo = "Gola Mundo("+nom+") _" +System.currentTimeMillis();
				
				// envio el saludo al cliente
				oos.writeObject(saludo);
				System.out.println("Seludo enviado...");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// como en las bases de datos se tiene que cerrar las conexiones
				if(oos != null) oos.close();
				if(ois != null) ois.close();
				if(s != null)s.close();
				System.out.println("Conexion cerrada!");
			}
		}

	}

}
