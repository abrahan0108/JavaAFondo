package libro.cap05;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Ventana1 extends Frame {
	public Button b1, b2,b3;
	
	public Ventana1() {
		// el constructor del padre recibe el titulo de la ventana
		super("Esta es la ventana 1");
		
		// defino el layout que va a tener la ventana: FlowLayout
		// sepuede pasar un parámetro a la clase FlowLayout para
		// alinear de acuerdo a la necesidad: FlowLayout.LEFT
		setLayout(new FlowLayout());
		
		// instancio el primer boton y lo agrego al container
		b1 = new Button("Botón 1");
		add(b1);
		
		// instancio el primer boton y lo agrego al container
		b2 = new Button("Botón 2");
		add(b2);
		
		// instancio el primer boton y lo agrego al container
		b3 = new Button("Botón 3");
		add(b3);
		
		// defino el tamaño de la ventana y la hago visible
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Ventana1 v1 = new Ventana1();
		
	}

}
