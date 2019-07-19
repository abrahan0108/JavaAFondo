package libro.cap11.demo;

public class Test {
	public static void main(String[] args) throws Exception
	{
		String sClass = "libro.cap11.demo.Demo";
		Class<?> clazz = Class.forName(sClass);
		
		HolaMundo a = clazz.getMethod("unMetodo").getAnnotation(HolaMundo.class);
		System.out.println("nombre = "+a.nombre());
	}
	
	
}
