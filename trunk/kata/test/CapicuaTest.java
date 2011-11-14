import junit.framework.TestCase;


public class CapicuaTest extends TestCase {
	
	public void testShouldAssertIfExampleAnana(){
		assertTrue(Capicua.comprobar("ANANA"));
	}
	
	public void testShouldFailIfExampleBanana(){
		assertFalse(Capicua.comprobar("BANANA"));
	}
	
	public void testShouldAssertIfExampleEmpty(){
		assertTrue(Capicua.comprobar(""));
	}
	
	public void testShouldAssertIfExampleEven(){
		assertTrue(Capicua.comprobar("22"));
	}
	
	public void testShouldAssertIfExampleOdd(){
		assertTrue(Capicua.comprobar("111"));
	}
	
}
