package libro.cap06;

public class DemoThread implements Runnable{
	private String nombre;
	
	public DemoThread(String nombre) {
		this.nombre = nombre;
	}
	
	public void run() {
		try {
			int x = (int) (Math.random()*5000);
			Thread.sleep(x);
			System.out.println("Soy: "+nombre+" ("+x+")");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread (new DemoThread("Pedro"));
		Thread t2 = new Thread (new DemoThread("Pablo"));
		Thread t3 = new Thread (new DemoThread("Juan"));
		
		t1.start();
		t2.start();
		t3.start();
		
		// esperamos la finalización de los tres hilos
		// esto se realiza con el metodo join()
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final del programa!");
	}
}
