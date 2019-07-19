package libro.cap05;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DemoListener6 extends Frame{
	
	private TextField tf;
	private Label lab;
	
	public DemoListener6() {
		super("Key Listener");
		
		// defino el layout principal
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new Label("Ingrese texto:"));
		
		tf = new TextField(15);
		add(tf);
		
		lab = new Label();
		add(lab);
		
		// agrego los listeners al TextField
		tf.addKeyListener(new EscuchaTecla());
		tf.addActionListener(new EscuchaEnter());
		
		setSize(350, 100);
		setVisible(true);
		
		// mando el cursor al TextField
		tf.requestFocus();
		
		addWindowListener(new EscuchaVentana());
	}
	
	class EscuchaTecla implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// por cada tecla presionada tomo el caracter
			char c = arg0.getKeyChar();
			
			// seteo el caracter como texto en el Label
			lab.setText(Character.toString(c));
			
		}
		// se tienen que sobreescribir los otros métodos aunque
		// se queden vacios
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class EscuchaEnter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// tomo el texto ingresado en el TextField
			String texto = tf.getText();
			
			// lo seteo como texto en el Label
			lab.setText(texto);
			
			// refresco los componentes de la ventana
			validate();
			
			// combierto a mausculas el texto del TextField
			tf.setText(texto.toUpperCase());
			
			// lo selecciono todo
			tf.selectAll();
			
			}
		}
	
	class EscuchaVentana implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// 1 - oculto
			System.out.println("Oculto...");
			setVisible(false);
			
			// 2 - libero
			System.out.println("Libero");
			dispose();
			
			// finalizo
			System.out.println("Finalizo");
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
			
		}}
	
	public static void main(String[] args) {
		new DemoListener6();
	}
}
