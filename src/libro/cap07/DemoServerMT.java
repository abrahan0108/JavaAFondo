package libro.cap07;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServerMT {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket s = null;
		ServerSocket ss = new ServerSocket(5433);
		
		while(true) {
			try {
				// ServerSocket me da el socket
				s = ss.accept();
				// instancio un thread
				(new Tarea(s)).start();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}
	
	static class Tarea extends Thread
	{
		private Socket s = null;
		private ObjectInputStream ois = null;
		private ObjectOutputStream oos = null;
		
		public Tarea(Socket socket) 
		{
			this.s = socket;
		}
		
		public void run()
		{
			try 
			{
				// informacion de la consola 
				System.out.println("Se conectaron desde la IP: "+s.getInetAddress());
				
				// enmascaro la entrada y la salida de  bytes
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
				
				// leo el nombre que envia el cliente
				String nom = (String)ois.readObject();
				
				// armo el saludo personalizado que le quiero enviar
				String saludo = "Hola Mundo: ("+nom+") _"+System.currentTimeMillis();
				
				// envio el saludo al cliente
				oos.writeObject(saludo);
				System.out.println("saludo enviado...");
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
				e.printStackTrace();
			} 
			finally 
			{
				try {
					if(oos != null) oos.close();
					if(ois != null) ois.close();
					if(s != null) s.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}

}
