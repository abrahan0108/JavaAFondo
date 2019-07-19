package libro.cap06.prodcons;

public class Monitor {
	private char[] buff = null;
	private int tope = 0;
	private boolean lleno = false;
	private boolean vacio = true;
	
	public Monitor(int capacidad) {
		buff = new char[capacidad];
	}
	
	public synchronized void poner(char c) throws Exception{
		// mientras el buffer esté lleno me bloqueo para darle la
		// posibiidad al consumidor de consumir algun caracter
		while(lleno) {
			wait();
		}
		
		// seccion critica
		buff[++tope] = c;
		
		vacio = false;
		lleno = tope >= buff.length;
		
		// este metodo notifica a todos los threads que ya no se está
		// bloqueando el metodo y los pasa a su estado de ready
		notifyAll();
	}
	
	public synchronized char sacar() throws Exception{
		// mientras el buffer este vacio me bloqueo para darle la 
		// posibilidad al productor de producir algun caracter
		while(vacio) {
			wait();
			}
		// seccion crítica
		char c = buff[--tope];
		
		lleno = false;
		vacio = tope <= 0;
		
		notifyAll();
		return c;
		
	}

}
