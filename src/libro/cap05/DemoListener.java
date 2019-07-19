package libro.cap05;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoListener extends Frame{
	
	private Button boton;
	
	public DemoListener() {
		super("Demo");
		setLayout(new FlowLayout());
		
		boton = new Button();
		
		// agrego un listener al botón
		boton.addActionListener(new EscuchaBoton());
		
		add(boton);
		
		setSize(200,150);
		setVisible(true);
	}
	
	class EscuchaBoton implements ActionListener{
		public void actionPerformed(ActionEvent e ) {
			// imprime por consola cuando se presiona el botón
			// System.out.println("Se ha presionado un botón");
			
			// dimension de la ventana
			Dimension dimVentana = getSize();
			
			// Dimension de la pantalla
			Dimension dimScreen = getToolkit().getScreenSize();
			
			// nuevas coordenadad aleatorias para reubicar la ventana
			int x = (int) (Math.random() * (dimScreen.width-dimVentana.width));
			int y = (int) (Math.random() * (dimScreen.height-dimVentana.height));
			
			// cambio la ubicación de la ventana
			setLocation(x, y);
			}
	}
	
	public static void main(String[] args) {
		new DemoListener(); 
	}

}
