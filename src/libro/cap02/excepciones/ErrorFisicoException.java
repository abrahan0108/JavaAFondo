package libro.cap02.excepciones;

@SuppressWarnings("serial")
public class ErrorFisicoException extends Exception{
	
	public ErrorFisicoException(Exception e) {
		super("ocurrió un error Físico: ",e);
	}
	
}
