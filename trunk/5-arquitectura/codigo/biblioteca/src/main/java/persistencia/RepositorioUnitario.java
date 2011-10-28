package persistencia;

/**
 * Clase que se encaga de guardar un unico elemento
 * 
 * @author cristian
 *
 * @param <T> Clase del elemento que va a persistir.
 */
public class RepositorioUnitario<T> {
	private T elemento;
	
	public RepositorioUnitario() {
		super();
		this.elemento = null;
	}

	public boolean insertar(T elemento) {
		boolean estaVacio = this.estaVacio(elemento);
		
		if(estaVacio)
			this.elemento=elemento;
		
		return estaVacio;
	}
	
	public boolean actualizar(T elemento) {
		boolean noEstaVacio = !this.estaVacio(elemento);
		
		this.elemento=elemento;

		return noEstaVacio;
	}
	
	public boolean remover(T elemento) {
		boolean noEstaVacio = !this.estaVacio(elemento);
		
		if(noEstaVacio)
			this.elemento=null;
		
		return noEstaVacio;
	}
	
	public boolean estaVacio(T elemento) {
		return (this.elemento==null);
	}

	public T obtenerElemento() {
		return this.elemento;
	}

}
