package libro.cap02.estaticas;

public class TestGarbageCollector {
	
	private static int count = 0;
	
	public TestGarbageCollector() {
		count++;
		System.out.println(count);
	}
	
	public void finalize() {
		count--;
	}
	
	public static void main(String[] args) {
		while(true) {
			new TestGarbageCollector();
		}
	}

}
