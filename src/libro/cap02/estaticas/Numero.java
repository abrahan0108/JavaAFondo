package libro.cap02.estaticas;

/**
 * @author Abrahán
 * En esta clase se muestran un método de clase y un
 * método de instancia
 *
 */
public class Numero {
	
	private double valor;
	
	/**Este es un método de instancia ya que "toca"
	 * el valor de la variable de instacia "valor"
	 * Esta es una versión sobrecargada del método "sumar"
	 * @param a
	 * @return
	 */
	public Numero sumar(double a) {
		valor += a;
		return this; // "this" retorna una referencia a la misma instancia
					// con la cual se está trabajando, esto permitirá
					// invocaciones sucesivas sobre el método sumar.
	}
	
	public Numero(double v) {
		this.valor = v;
	}
	
	public String toString() {
		return Double.toString(valor);
	}
	
	/**Este es un método de clase, de acuerdo con el libro son:
	 * “aquellos métodos cuyo valor de retorno será determinado
	 * exclusivamente en función de sus argumentos y, obviamente,
	 * no necesitan acceder a ninguna variable de instancia”.
	 * @param a
	 * @param b
	 * @return
	 */
	public static double sumar(double a, double b) {
		return a + b;
	}

}
