package persistencia;

import java.util.ArrayList;
import java.util.List;

import utils.UserException;

public class RepositorioUnitario<T> {
	private List<T> elementos;
	
	public RepositorioUnitario() {
		super();
		this.elementos = new ArrayList<T>();
	}

	public boolean insertar(T elemento) {
		boolean noContieneElElemento = !this.contiene(elemento);
		
		if(noContieneElElemento)
			this.elementos.add(elemento);
		
		return noContieneElElemento;
	}
	
	public boolean actualizar(T elemento) {
		boolean contieneElElemento = this.contiene(elemento);
		
		if(contieneElElemento) {
			this.elementos.remove(elemento);
			this.elementos.add(elemento);
		}

		return contieneElElemento;
	}
	
	public void forzar(T elemento) {
		boolean contieneElElemento = this.contiene(elemento);
		
		if(contieneElElemento)
			this.actualizar(elemento);
		else
			this.insertar(elemento);
	}
	
	public boolean remover(T elemento) {
		boolean contieneElElemento = this.contiene(elemento);
		
		if(contieneElElemento)
			this.elementos.remove(elemento);
		
		
		return contieneElElemento;
	}
	
	public boolean contiene(T elemento) {
		return this.elementos.contains(elemento);
	}

	public T obtener(T elemento) {
		for (T elementoBuscado : this.elementos) {
			if (elemento.equals(elementoBuscado)) {
				return elementoBuscado;
			}
		}
		throw new UserException("El elemento buscado no existe en el Repositorio");
	}

}
