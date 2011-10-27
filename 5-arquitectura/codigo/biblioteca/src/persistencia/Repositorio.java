package persistencia;

import java.util.HashMap;
import java.util.Map;

import modelo.Biblioteca;

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
	
	public RepositorioUnitario<?> get(String nombre) {
		return this.repositorios.get(nombre);
	}
	
	public boolean contiene(String nombre) {
		return this.repositorios.containsKey(nombre);
	}
	
	@SuppressWarnings("unchecked")
	public void main(String[] args) {
		Repositorio.getInstancia().agregar(Biblioteca.BIBLIOTECA,new RepositorioUnitario<Biblioteca>());
		RepositorioUnitario<Biblioteca> repoBiblio = (RepositorioUnitario<Biblioteca>) Repositorio.getInstancia().get(Biblioteca.BIBLIOTECA);
		repoBiblio.insertar(new Biblioteca());
		Biblioteca biblioteca = repoBiblio.obtener(new Biblioteca());
		
		biblioteca.addLibro("1234","Las venas abiertas de América Latina", "Eduardo Galeano","editorial");
		biblioteca.addLibro("4521","Guerra y Paz", "León Tolstoy","editorial");
		biblioteca.addLibro("7845","Patas Arriba", "Eduardo Galeano","editorial");
		biblioteca.addLibro("1248","Historia del siglo XX", "Eric Hobsbawm","editorial");
		biblioteca.addLibro("7561","Ficciones", "Jorge Luis Borges","editorial");
		biblioteca.addLibro("3487","100 años de soledad", "Gabriel García Márquez","editorial");
		biblioteca.addLibro("6374","Sobre héroes y tumbas", "Ernesto Sábato","editorial");
	}

}
