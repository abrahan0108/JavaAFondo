package libro.cap06;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDemora extends Frame{
	private Button boton;
	private Choice combo;
	
	public VentanaDemora() {
		setLayout(new FlowLayout());
		add(boton = new Button("Esto va a demorar..."));
		boton.addActionListener(new EscuchaBoton());
		add(combo = new Choice());
		combo.addItem("Item 1");
		combo.addItem("Item 2");
		combo.addItem("Item 3");
		
		setSize(300,300);
		setVisible(true);
	}
	
	class EscuchaBoton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// inhabilito el boton mientras dure el proceso
			boton.setEnabled(false);
			
			// instancio y lanzo el thread que lleva a cabo la tarea
			TareaBoton t = new TareaBoton();
			t.start();
		}
		
	}
	
	class TareaBoton extends Thread{
		public void run() {
			try {
				// hago aquí lo que antes hacia en el actionPerformed
				Thread.sleep(10000);
				System.out.println("Termino el tiempo de espera...!");
				
				// cuando finalizo la tarea vuelvo a habilitar el boton
				boton.setEnabled(true);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void main(String[] args) {
		new VentanaDemora();
	}
}
