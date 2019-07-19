package libro.cap07;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DemoCliente {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Socket s = null;
		
		try {
			// instancio el server con la IP y el PORT
			s = new Socket("127.0.0.1",5433);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			
			// envio un nombre
			oos.writeObject("Abrahán");
			
			// recibo la respuesta (el saludo personalizado)
			String ret = (String)ois.readObject();
			
			// muestro la respuesta que envio el SERVER
			System.out.println(ret);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(ois != null) ois.close();
			if(oos != null) oos.close();
			if(s != null) s.close();
		}

	}

}
