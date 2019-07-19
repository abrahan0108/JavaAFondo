package libro.cap07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServerB {
	private static final int BUFFER_LENGTH = 3;

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		Socket s = null;
		ServerSocket ss = new ServerSocket(5433);
		
		while(true)
		{
			try 
			{
				// espero la conexion
				s = ss.accept();
				
				// informacion de consola
				System.out.println("Se conectaron desde la direccion IP: "+s.getInetAddress());
				
				// enmascaro la entrada y salida de bytes
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				bw = new BufferedWriter(new PrintWriter(s.getOutputStream()));
				
				// buffer para recibir información y enviar
				char bEnviar[];
				char bRecive[] = new char[BUFFER_LENGTH];
				
				StringBuffer sb = new StringBuffer();
				
				// leo el nombre que envía el cliente
				int n;
				while( (n = br.read(bRecive)) == BUFFER_LENGTH) {
					sb.append(bRecive);
				}
				sb.append(bRecive, 0, n);
				
				// armo el saludo personalizado que le quiero enviar
				String saludo = "Hola mundo ("+sb+") _"+System.currentTimeMillis();
				
				// envio el saludo al cliente
				bEnviar = saludo.toCharArray();
				bw.write(bEnviar);
				bw.flush();
				System.out.println("Saludo Enviado...");
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
				e.printStackTrace();
			} 
			finally
			{
				if(bw != null) bw.close();
				if(br != null) br.close();
				if(s != null) s.close();
				System.out.println("conexión cerrada!");
			}
		}

	}

}
