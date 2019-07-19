package libro.cap05;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class Calculadora extends Frame{
	private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
	private Button bDec, bMas, bMenos, bPor, bDiv, bIgual, bBorrar;
	private TextField tfDisplay;
	
	public Calculadora() {
		super();
		setLayout(new BorderLayout());
		
		// en el norte se ubica el textfield
		tfDisplay = new TextField();
		add(tfDisplay, BorderLayout.NORTH);
		
		// en el centro ubico el teclado
		Panel pTeclado = _crearTeclado();
		add(pTeclado, BorderLayout.CENTER);
		
		// este metodo dimensiona y setea el tamaño
		// exacto para contener todos los componentes
		
	}
	
	private Panel _crearTeclado() {
		// crea los 16 botones
		b0 = new Button("0");
		b1 = new Button("1");
		b2 = new Button("2");
		b3 = new Button("3");
		b4 = new Button("4");
		b5 = new Button("5");
		b6 = new Button("6");
		b7 = new Button("7");
		b8 = new Button("8");
		b9 = new Button("9");
		bDec = new Button(".");
		bMas = new Button("+");
		bMenos = new Button("-");
		bPor = new Button("*");
		bDiv = new Button("/");
		bIgual = new Button("=");
		
		// instancio un Panel (un container) con GridLayout de 4 x4
		Panel p = new Panel(new GridLayout(4,4));
		
		// agrego los botones al panel
		
		// Fila 0 (la de mas arriba)
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bDiv);
		
		// fila 1 la segunda comenzando de arriba
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bPor);
		
		// fila 2 la tercera comenzando de arriba
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(bMenos);
		
		// fila 3 (la cuarta comenzando desde arriba)
		p.add(bDec);
		p.add(b0);
		p.add(bIgual);
		p.add(bMas);
		
		// retorno el Panel con todos los botones agregados 
		return p;
						
	}
	
	public static void main(String[] args) {
		Calculadora c = new Calculadora();
	}

}
