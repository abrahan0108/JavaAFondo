package libro.cap02.fechas;

public class Fecha {
	
	private int dia;
	private int mes;
	private int anio;
	
	
	//Este es un métod que devolverá la fecha expresada en días
	private int fechaToDias() {
	return anio*360+mes*30+dia;
	}
	
	//Este método asigan la fecha expresada en días a los atributos
	private void diasToFecha(int i) {
		
		//Se divide entre 360 y se obtiene al año
		anio = (int)i/360;
		
		// del resto de la división se obtiene el mes y el día
		int resto = i % 360;
		
		//el mes es el resto dividido entre 30
		mes = (int) resto/30;
		
		//el resto de la división anterior son los días
		dia = resto % 30;
		
		
		//ajuste por si día quedó en 0
		if(dia == 0) {
			dia=30;
			mes--;
		}
		
		// ajuste por si el mes quedó en 0
		if(mes == 0) {
			mes = 12;
			anio--;
		}
	}
	
	//Este método sumará los días para obtener la nueva fecha
	
	public void addDias(int d) {
		//se convierte la fecha a días y se suma d
		int sum = fechaToDias()+d;
		
		//La fecha resultante la separo en día, mes y año
		diasToFecha(sum);
	}
	
	//Esta es la sobrecarga de un constructor que no recibe nada	
	public Fecha() {
		
	}
	
	// Aquí se realiza la declaración un constructor:
	// Si se declara un constructor explícitamente, deja de funcionar el
	// constructor que da por defecto
	public Fecha(int d, int m, int a) {
		dia = d;
		mes = m;
		anio = a;
	}
	
	//Esta es la sobrecarga de otro constructor al cual se le pasa un String como parámetro del tipo dd/mm/aaaa
	public Fecha(String s) {
		//Se tiene que buscar la primer coincidencia del índice del símbolo '/'
		int pos1 = s.indexOf('/');
		//se busca la última coincidencia del caracter '/'
		int pos2 = s.lastIndexOf('/');
		
		//proceso del día
		// se declara la parte de la fecha que se encuentra en una cadena, dando como parametros la posición
		//0 y la primer coincidencia de '/'
		String sDia = s.substring(0, pos1);
		dia = Integer.parseInt(sDia);
		//proceso del mes
		String sMes = s.substring(pos1+1,pos2);
		mes = Integer.parseInt(sMes);
		//proceso del año
		String sAnio = s.substring(pos2+1);
		anio = Integer.parseInt(sAnio);
		
	}	
	
	// En esta parte sobreescribo el método toString ya que al usar
	// System.out.println(f), no sabe de que manera va a devolver estos atributos
	// por lo que se ve obligado a imprimir algo como: poo.Fecha@15db9742
	public String toString() {
		return dia+"/"+mes+"/"+anio;
	}
	
	//Sobreescribo el método "equals" para saber si dos fechas son iguales o no
	public boolean equals(Object o) {
		Fecha otra = (Fecha)o;
		return (dia == otra.dia) && (mes == otra.mes) && (anio == otra.anio);
	}
	
	public int getDia() {
		//regresa el día
		return dia;
	}
	
	public void setDia(int dia) {
		//asigna el día
		this.dia = dia;
	}
	
	public int getMes() {
		//obtiene el mes
		return mes;
	}
	
	public void setMes(int mes) {
		//asigna un mes
		this.mes = mes;
	}
	
	public int getAnio() {
		// Asigna el año
		return anio;
	}
	
	public void setAnio(int anio) {
		this.anio = anio;
	}
	

}
