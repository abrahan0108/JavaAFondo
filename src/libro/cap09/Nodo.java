package libro.cap09;

public class Nodo <T>{
	private T info;
	private Nodo<T> ref;
	// ...
	// setters y getters
	// ...
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public Nodo<T> getRef() {
		return ref;
	}
	public void setRef(Nodo<T> ref) {
		this.ref = ref;
	}	
}
