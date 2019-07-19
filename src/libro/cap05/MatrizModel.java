package libro.cap05;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MatrizModel implements TableModel{
	
	private Object[][] datos;
	
	public MatrizModel(Object[][] datos) {
		this.datos = datos;
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// retorna la cantidad de columnas
		return datos[0].length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// retorna el titulo (header) de la columna
		return datos[0][columnIndex].toString();
	}

	@Override
	public int getRowCount() {
		// retorna la cantidad de filas que sera uno menos que
		// el lenght porque la primera tiene los headers
		return datos.length-1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// la fila 0 corresponde a los header
		return datos[rowIndex][columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	

}
