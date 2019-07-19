package libro.cap05;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DemoListener5 extends Frame{
	private Button bAgregar;
	private TextField tfItem;
	private List lista;
	
	public DemoListener5() {
		super("Action Listener");
		// defino el layout principal
		setLayout(new BorderLayout());
		
		// al norte
		Panel pn = _crearNorte();
		add(pn, BorderLayout.NORTH);
		
		// al centro
		lista = new List();
		add(lista, BorderLayout.CENTER);
		
		// seteo los listeners
		bAgregar.addActionListener(new EscuchaAgregar());
		tfItem.addActionListener(new EscuchaAgregar());
		lista.addActionListener(new EscuchaDobleClick());
		this.addWindowListener(new EscuchaVentana());
		
		setSize(300, 300);
		setVisible(true);
		
		// el cursor aparecerá por defecto en el TextField
		tfItem.requestFocus();
		
	}
	
	class EscuchaAgregar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// tomo el texto ingresado en el TextField
			String item = tfItem.getText();
			
			// lo agrego a la lista
			lista.add(item);
			
			// selecciono todo el texto en el TextField
			tfItem.requestFocus();
			
		}
	}
	
	class EscuchaDobleClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// tomo la posicion del item seleccionado
			int idx = lista.getSelectedIndex();
			
			// seteo el item seleccionado en el TextField
			tfItem.setText(lista.getSelectedItem());
			
			// lo remuevo de la lista
			lista.remove(idx);
			
			// selecciono todo el texto del TextField
			tfItem.selectAll();
			
			// seteo el foco en el TextField
			tfItem.requestFocus();
			
		}}
	
	private Panel _crearNorte() {
		Panel p = new Panel(new FlowLayout(FlowLayout.LEFT));
		p.add(new Label("Item:"));
		
		tfItem = new TextField(15);
		p.add(tfItem);
		
		bAgregar = new Button("Agregar");
		p.add(bAgregar);
		
		return p;
		
	}
	
	class EscuchaVentana implements WindowListener{

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// para cerra la ventana y finalizar el programa
			// correctamente son tres pasos:
			// 1 - ocultar la ventana con setVisible(false);
			// 2 - liberarla con el metodo dispose();
			// 3 - finalizar el programa con System.exit(0);
			System.out.println("Oculto...");
			setVisible(false);
			
			System.out.println("Libero ...");
			dispose();
			
			System.out.println("Finalizo...");
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		new DemoListener5();
	}

}
