package libro.cap05;

import java.util.Vector;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class VectorModel implements ListModel{
	private Vector<Object> datos;
	
	public VectorModel(Vector<Object> datos) {
		this.datos = datos;
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return datos.get(arg0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return datos.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
