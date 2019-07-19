package libro.cap05;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class DemoJList extends JFrame{
	
	public DemoJList() {
		super("Demo JList");
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		
		// obtengo el vector  con los datos que vamos a mostrar
		Vector<Object> datos = _obtenerVectorDatos();
		
		// el constructor de JList recibe una instancia de ListModel
		JList lista = new JList(new VectorModel(datos));
		
		// el scrollPane agrega barras de scroll si es necesario
		JScrollPane scrollLista = new JScrollPane(lista);
		
		content.add(scrollLista, BorderLayout.CENTER);
		setVisible(true);
	}
	
	private Vector<Object> _obtenerVectorDatos(){
		Vector<Object> v = new Vector<Object>();
		v.add("John Lenon");
		v.add("Paul Macartney");
		v.add("Gerorge HArrison");
		v.add("Ringo Star");
		v.add("Sandro (Roberto Sanchez)");
		v.add("Charly Garcia");
		v.add("Caetano Veloso");
		
		return v;
	}
	
	public static void main(String[] args) {
		new DemoJList();
	}
	
}
