package libro.cap07.udp.abrahan;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer 
{

	public static void main(String[] args) throws Exception
	{
		// creo el socket
		DatagramSocket socket = new DatagramSocket(5433);
		
		while(true)
		{
			System.out.println("Esperando conexion...");
			
			//buffer para recibir el nombre del cliente
			byte[] bRecibe = new byte[256];
			
			// recibo el nombre del cliente
			DatagramPacket packet = new DatagramPacket(bRecibe,bRecibe.length);
			
			socket.receive(packet);
			System.out.println("Conexion Establecida!");
			
			// preparo el saludo para enviar
			String nombre = new String(packet.getData(), 0, packet.getLength());
			String saludo = "Hola Mundo ("+nombre+") _"+System.currentTimeMillis();
			
			System.out.println("Voy a enviar: ["+saludo+"]...");
			
			// buffer para enviar el saludo
			byte[] bEnvia = saludo.getBytes();
			
			// envio el saludo
			InetAddress address = packet.getAddress();
			packet = new DatagramPacket(bEnvia, bEnvia.length, address, packet.getPort());
			
			socket.send(packet);
			System.out.println("Saludo Enviado!");
		}

	}

}
