package libro.cap02.misclases;

public class FechaHora extends FechaDetallada{
	
	private int hora;
	private int minuto;
	private int segundo;
	
	public FechaHora(String sFecha, int hora, int minuto, int segundo) {
		
		super(sFecha);
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		
	}
	
	public String toString() {
		
		//Se invoca el método toString del padre de esta clase
		return super.toString() + " ("+hora+":"+minuto+":"+segundo+")";
		
	}

}
