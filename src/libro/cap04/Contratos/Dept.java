package libro.cap04.Contratos;

import java.util.Collection;

import libro.cap04.DeptDTO;

public interface Dept {
	public Collection<DeptDTO> buscarTodos();
}
