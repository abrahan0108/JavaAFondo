package libro.cap05;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DemoJTable extends JFrame{
	public DemoJTable() {
		super("Demo JList");
		
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		
		Object[][] datos = _obtenerMatrizDatos();
		JTable tabla = new JTable(new MatrizModel(datos));
		
		JScrollPane scrollLista = new JScrollPane(tabla);
		content.add(scrollLista, BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
	}
	
	private Object[][] _obtenerMatrizDatos(){
		
		Object[][] mat = {
				{"Columna 0", "Columna 1", "Columna 2", "Columna 3"},
				{"Rojo", 	  "Verde", 	   "Azul", 	 	"Violeta"},
				{"Amarillo",  "Naranja",   "Blanco", 	"Gris"},
				{"Negro", 	  "Turquesa",  "Sepia", 	"Rosa"},
				{"Salmon", 	  "Maiz", 	   "Marron", 	"Fucsia"}
		};
		
		return mat;		
	}
	
	public static void main(String[] args) {
		new DemoJTable();
	}

}
