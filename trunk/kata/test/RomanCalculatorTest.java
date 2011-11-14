import java.security.InvalidParameterException;

import junit.framework.TestCase;


public class RomanCalculatorTest extends TestCase {
	
	public void testShouldFailIfConvertZero(){
		Boolean fail = false;
		try {
			RomanConversor.convert(0);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
			fail = true;
		}
		assertTrue(fail);
	}
	
	public void testShouldFailNegativeNumber(){
		Boolean fail = false;
		try {
			RomanConversor.convert(-1);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
			fail = true;
		}
		assertTrue(fail);
	}
	
	public void testShouldConvertOneToI (){
		assertEquals("I", RomanConversor.convert(1));
	}
}
