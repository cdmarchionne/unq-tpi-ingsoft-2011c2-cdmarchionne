package modelo;

import persistencia.Repositorio;
import persistencia.RepositorioUnitario;
import vista.Logger;

public class Ejemplo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Repositorio.getInstancia().agregar(Biblioteca.BIBLIOTECA,new RepositorioUnitario<Biblioteca>());
		RepositorioUnitario<Biblioteca> repoBiblio = (RepositorioUnitario<Biblioteca>) Repositorio.getInstancia().obtener(Biblioteca.BIBLIOTECA);
		repoBiblio.insertar(new Biblioteca());
		Biblioteca biblioteca = repoBiblio.obtenerElemento();
		
		biblioteca.cargarEjemplos();
		
		for (Libro libro : biblioteca.obtenerTodosLosLibros()) {
			Logger.getInstancia().mostrar("Libro: " + libro);
		}
	}

}
