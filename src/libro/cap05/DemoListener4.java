package libro.cap05;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DemoListener4 extends Frame{
	
	public DemoListener4() {
		super("Demo");
		
		// relaciono un WindowListener con el Frame
		addWindowListener(new EscuchaVentana());
		
		setSize(200,150);
		setVisible(true);
	}
	
	class EscuchaVentana implements WindowListener{
		// Se tienen que sobreescribir todos los métodos de la interface
		// aunque se tengan que dejar vacíos

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// para cerra la ventana y finalizar el programa
			// correctamente son tres pasos:
			// 1 - ocultar la ventana con setVisible(false);
			// 2 - liberarla con el metodo dispose();
			// 3 - finalizar el programa con System.exit();
			System.out.println("oculto..");
			setVisible(false);
			
			System.out.println("Libero...");
			dispose();
			
			System.out.println("Finalizo...");
			System.exit(0);
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		new DemoListener4();
	}

}
