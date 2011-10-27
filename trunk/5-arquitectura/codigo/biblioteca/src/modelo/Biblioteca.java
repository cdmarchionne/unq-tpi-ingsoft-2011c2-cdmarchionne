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
	
	public void ejemplos() {
		this.addLibro("1234","Las venas abiertas de América Latina", "Eduardo Galeano","editorial");
		this.addLibro("4521","Guerra y Paz", "León Tolstoy","editorial");
		this.addLibro("7845","Patas Arriba", "Eduardo Galeano","editorial");
		this.addLibro("1248","Historia del siglo XX", "Eric Hobsbawm","editorial");
		this.addLibro("7561","Ficciones", "Jorge Luis Borges","editorial");
		this.addLibro("3487","100 años de soledad", "Gabriel García Márquez","editorial");
		this.addLibro("6374","Sobre héroes y tumbas", "Ernesto Sábato","editorial");
	}

	public void addLibro(String isbn, String titulo, String autor, String editorial) {
		this.addLibro(new Libro(isbn, titulo, autor, editorial));
	}
	
	public void addLibro(Libro libro) {
		if(isLibroExiste(libro.getIsbn())){
			throw new UserException("El libro ya Existe");
		}
		
		this.libros.add(libro);
	}
	
	private boolean isLibroExiste(String isbn) {
		return	!buscarIsbn(isbn).isEmpty();
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
	
	public List<Libro> getLibros() {
		List<Libro> seleccionDeLibros = new ArrayList<Libro>();
		for (Libro libro : this.libros) {
			seleccionDeLibros.add(libro);
		}
		return seleccionDeLibros;
	}
	
}
