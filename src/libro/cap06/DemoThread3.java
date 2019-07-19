package libro.cap06;

public class DemoThread3 {
	
	public static void main(String[] args) {
		MiThread t1 = new MiThread("Pedro");
		MiThread t2 = new MiThread("Pablo");
		
		// se puede asignar prioridad mediante el método
		// setPriority con constantes Thread.MAX_PRIORITY
		// y Thread.MIN_PRIORITY
		t1.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
	}
	
	static class MiThread extends Thread{
		String nom;
		
		public MiThread(String nom) {
			this.nom = nom;
		}
		
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(nom+"-"+i);
				yield();
			}
		}
	}

}
