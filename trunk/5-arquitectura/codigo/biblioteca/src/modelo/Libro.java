package modelo;

import java.util.Observable;

import utils.UserException;
import utils.Utiles;


public class Libro extends Observable  {

	public static final String ISBN = "isbn";
	public static final String TITULO = "titulo";
	public static final String AUTOR = "autor";
	public static final String EDITORIAL = "editorial";
	
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	
//	public Libro() {
//		super();
//		this.isbn = "";
//		this.titulo = "";
//		this.autor = "";
//		this.editorial= "";
//	}
//	
	public Libro(String isbn, String titulo, String autor, String editorial) {
		super();
		if(Utiles.stringValido(isbn)){
			throw new UserException("El libro debe tener un codigo ISBN");				
		}
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial= editorial;
	}

	public String getIsbn() {
		return this.isbn;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public String getAutor() {
		return this.autor;
	}
	
	public String getEditorial() {
		return this.editorial;
	}
	
	
	
	public boolean isIsbn(String isbn) {
		return (isbn!=null) && (!isbn.isEmpty()) && (this.isbn.contains(isbn));
	}
	
	public boolean isTitulo(String titulo) {
		return (titulo!=null) && (!titulo.isEmpty()) && (this.titulo.contains(titulo));
	}
	
	public boolean isAutor(String autor) {
		return (autor!=null) && (!autor.isEmpty()) && (this.autor.contains(autor));
	}
	
	public boolean isEditorial(String editorial) {
		return (editorial!=null) && (!editorial.isEmpty()) && (this.editorial.contains(editorial));
	}

	@Override
	public String toString() {
		return this.isbn + " - '" + this.titulo + "' de " + this.autor + ". [" + this.editorial + "]";
	}
	
	
}
