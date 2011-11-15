import junit.framework.TestCase;


public class HashTest extends TestCase {
	
	public void testShouldAssertIfHashANullValue(){
		Integer actual = Hash.obtenerHash(null);
		assertEquals(null, actual);
	}
	
	public void testShouldAssertIfHashTheSameWordEmpty(){
		Integer actual = Hash.obtenerHash("");
		assertEquals(Hash.obtenerHash(""), actual);
	}
	
}
