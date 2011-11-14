import junit.framework.TestCase;


public class CapicuaTest extends TestCase {
	
	public void testShouldAssetIfExampleAnana(){
		assertTrue(Capicua.comprobar("ANANA"));
	}
	
	public void testShouldFailIfExampleBanana(){
		assertFalse(Capicua.comprobar("BANANA"));
	}
	
}
