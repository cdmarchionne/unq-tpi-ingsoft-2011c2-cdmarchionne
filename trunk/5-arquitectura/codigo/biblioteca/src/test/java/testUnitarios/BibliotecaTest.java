package testUnitarios;

import junit.framework.TestCase;

import modelo.Biblioteca;
import modelo.Libro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import org.mockito.Mockito.*;

import persistencia.Repositorio;
import persistencia.RepositorioUnitario;

/**
 * @author cristian
 *
 */
@SuppressWarnings("unchecked")
public class BibliotecaTest extends TestCase {

	private static final String MENSAJE_TEST_ADD_LIBRO = "Comprobacion de agregar un libro a la Biblioteca";

	/**
	 * Seteo el Repositorio
	 */
	@Before
	public void setUp() throws Exception {
		RepositorioUnitario<Biblioteca> repositorioBiblioteca = new RepositorioUnitario<Biblioteca>();
		repositorioBiblioteca.insertar(new Biblioteca());
		Repositorio.getInstancia().agregar(Biblioteca.BIBLIOTECA,repositorioBiblioteca);
	}
	
	/**
	 * Vacio la Biblioteca
	 */
	@After
	protected void tearDown() throws Exception {
		RepositorioUnitario<Biblioteca> repoBiblio = (RepositorioUnitario<Biblioteca>) Repositorio.getInstancia().obtener(Biblioteca.BIBLIOTECA);
		Biblioteca biblioteca = repoBiblio.obtenerElemento();
		
		for (Libro libro : biblioteca.obtenerTodosLosLibros()) {
			biblioteca.sacarLibro(libro);
		}
	}


	/**
	 * Test de ESCRITURA
	 * Test method for {@link modelo.Biblioteca#addLibro(modelo.Libro)}.
	 */
	@Test
	public void testAddLibro() {
		final String ISBN = "1234";

		RepositorioUnitario<Biblioteca> repoBiblio = (RepositorioUnitario<Biblioteca>) Repositorio.getInstancia().obtener(Biblioteca.BIBLIOTECA);
		Biblioteca biblioteca = repoBiblio.obtenerElemento();
		
		Libro libro = new Libro(ISBN, "El naufrago", "Desconocido", "Nautilus");
		biblioteca.agregarLibro(libro);
		
		assertEquals(MENSAJE_TEST_ADD_LIBRO, libro, biblioteca.obtenerLibroPorIsbn(ISBN));
	}

	/**
	 * Test de LECTURA
	 * Test method for {@link modelo.Biblioteca#buscarIsbn(java.lang.String)}.
	 */
	@Test
	public void testBuscarIsbn() {
		final String ISBN = "1234";
		
		RepositorioUnitario<Biblioteca> repoBiblio = (RepositorioUnitario<Biblioteca>) Repositorio.getInstancia().obtener(Biblioteca.BIBLIOTECA);
		Biblioteca biblioteca = repoBiblio.obtenerElemento();
		
		Libro libro = new Libro(ISBN, "El naufrago", "Desconocido", "Nautilus");
		biblioteca.agregarLibro(libro);
		
		assertFalse(MENSAJE_TEST_ADD_LIBRO, biblioteca.buscarIsbn(ISBN).isEmpty());
	}

}
