package libro.cap07.udp.abrahan;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPCliente 
{

	public static void main(String[] args) throws Exception 
	{
		// Instancio un DatagramSocket
		DatagramSocket socket = new DatagramSocket();
		
		// buffer con info a enviar
		byte[] bEnviar = "Abrahan".getBytes();
		
		// ip del server
		byte[] ip = {12,0,0,1};
		InetAddress address = InetAddress.getByAddress(ip);
		
		// paquete de informacion a enviar, ip + port(5433)
		DatagramPacket packet = new DatagramPacket(bEnviar, bEnviar.length, address, 5433);
		
		// envio el paquete
		socket.send(packet);
		
		// buffer para recibir la respuesta
		byte[] bRecibe = new byte[256];
		packet = new DatagramPacket(bRecibe, bRecibe.length, address, 5433);
		
		// recibo el saludo
		socket.receive(packet);
		
		// muestro el saludo
		String saludo = new String(packet.getData(),0,packet.getLength());
		System.out.println(saludo);
		socket.close();

	}

}
