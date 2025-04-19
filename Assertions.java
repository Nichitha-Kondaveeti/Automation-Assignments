package Com.Day2_Assignments;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;
 
public class Assertions {
	CalculatorAdd caladd=new CalculatorAdd();
	int result = caladd.add(2, 3);

 
	@Test
	public void assertion1() {
		assertEquals(10, caladd.add(5,5));
	}
	@Test
	public void assertion2() {
		assertNotEquals(10,caladd.add(5, 6));
	}

	@Test
	public void assertion3() {
		assertTrue(result>0,"Test result is not positive");
	}
	@Test
	public void assertion4() {
		assertFalse(result<0,"Test result is positive");
		
	}
	@Test
	public void assertion5() {
		assertNull(null,"null");
	}
	@Test
	public void assertion6() {
		assertNull(null,"Text is not null");
	}
	@Test
	public void assertion7() {
		assertSame(2, 2);
	}
	@Test
	public void assertion8() {
		assertNotSame(11, caladd.add(5, 5));
	}

}