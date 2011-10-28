package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import utils.UserException;


public class Biblioteca extends Observable {
	
	public static final String BIBLIOTECA = "biblioteca";
	public static final String LIBROS = "libros";
	
	private List<Libro> libros = new ArrayList<Libro>();

	public Biblioteca() {
		super();
		this.libros = new ArrayList<Libro>();
	}
	
	public void cargarEjemplos() {
		this.agregarLibro("1234","Las venas abiertas de América Latina", "Eduardo Galeano","editorial");
		this.agregarLibro("4521","Guerra y Paz", "León Tolstoy","editorial");
		this.agregarLibro("7845","Patas Arriba", "Eduardo Galeano","editorial");
		this.agregarLibro("1248","Historia del siglo XX", "Eric Hobsbawm","editorial");
		this.agregarLibro("7561","Ficciones", "Jorge Luis Borges","editorial");
		this.agregarLibro("3487","100 años de soledad", "Gabriel García Márquez","editorial");
		this.agregarLibro("6374","Sobre héroes y tumbas", "Ernesto Sábato","editorial");
	}

	public void agregarLibro(String isbn, String titulo, String autor, String editorial) {
		this.agregarLibro(new Libro(isbn, titulo, autor, editorial));
	}
	
	public void agregarLibro(Libro libro) {
		if(existeLibro(libro.getIsbn())){
			throw new UserException("El libro ya Existe");
		}
		
		this.libros.add(libro);
	}
	
	public void sacarLibro(Libro libro) {
		if(existeLibro(libro.getIsbn())){
			this.libros.remove(libro);
		}
	}
	
	public boolean existeLibro(String isbn) {
		return	!(obtenerLibroPorIsbn(isbn)==null);
	}
	
	public Libro obtenerLibroPorIsbn(String isbn) {
		for (Libro libro : this.libros) {
			if (libro.isIsbn(isbn)) {
				return libro;
			}
		}
		return null;
	}
	
	public List<Libro> buscarIsbn(String isbn) {
		List<Libro> seleccionDeLibros = new ArrayList<Libro>();
		for (Libro libro : this.libros) {
			if (libro.isIsbn(isbn)) {
				seleccionDeLibros.add(libro);
			}
		}
		return seleccionDeLibros;
	}
	
	public List<Libro> buscarTitulo(String titulo) {
		List<Libro> seleccionDeLibros = new ArrayList<Libro>();
		for (Libro libro : this.libros) {
			if (libro.isTitulo(titulo)) {
				seleccionDeLibros.add(libro);
			}
		}
		return seleccionDeLibros;
	}

	public List<Libro> buscarAutor(String autor) {
		List<Libro> seleccionDeLibros = new ArrayList<Libro>();
		for (Libro libro : this.libros) {
			if (libro.isAutor(autor)) {
				seleccionDeLibros.add(libro);
			}
		}
		return seleccionDeLibros;
	}
	
	public List<Libro> buscarEditorial(String editorial) {
		List<Libro> seleccionDeLibros = new ArrayList<Libro>();
		for (Libro libro : this.libros) {
			if (libro.isEditorial(editorial)) {
				seleccionDeLibros.add(libro);
			}
		}
		return seleccionDeLibros;
	}
	
	public List<Libro> obtenerTodosLosLibros() {
		List<Libro> seleccionDeLibros = new ArrayList<Libro>();
		for (Libro libro : this.libros) {
			seleccionDeLibros.add(libro);
		}
		return seleccionDeLibros;
	}
	
}
