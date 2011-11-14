import junit.framework.TestCase;


public class HashTest extends TestCase {
	
	public void testShouldAssertIfHashTheSameWordEmpty(){
		int actual = Hash.obtenerHash("");
		assertEquals(Hash.obtenerHash(""), actual);
	}
	
}
