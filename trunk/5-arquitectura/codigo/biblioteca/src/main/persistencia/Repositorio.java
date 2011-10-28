package persistencia;

import java.util.HashMap;
import java.util.Map;

/**
 * Repositorio Persistente
 * 
 * @author cristian
 *
 */
public class Repositorio {
	
	private static Repositorio instancia = null;

	private Map<String,RepositorioUnitario<?>> repositorios;
	
	public Repositorio() {
		super();
		this.repositorios = new HashMap<String,RepositorioUnitario<?>>();
	}

	public static final Repositorio getInstancia() {
		if(instancia == null) {
			instancia = new Repositorio();
		}
		return instancia;
	}

	public boolean agregar(String nombre,RepositorioUnitario<?> repositorio) {
		boolean noContieneElElemento = !this.contiene(nombre);
		
		if(noContieneElElemento)
			this.repositorios.put(nombre, repositorio);
		
		return noContieneElElemento;
	}
	
	public boolean sacar(String nombre) {
		boolean contieneElElemento = this.contiene(nombre);
		
		if(contieneElElemento)
			this.repositorios.remove(nombre);
		
		return contieneElElemento;
	}
	
	public RepositorioUnitario<?> obtener(String nombre) {
		return this.repositorios.get(nombre);
	}
	
	public boolean contiene(String nombre) {
		return this.repositorios.containsKey(nombre);
	}
	
}
