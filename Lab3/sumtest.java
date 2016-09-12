//Luke Lai
//1355154
//10/22/14
//SumTest.java
//Unit tests for Sum class

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class SumTest {
	
	@Test
	public void oneNumberTest() {
		Sum s = new Sum();
		s.add(11);
		assertEquals(11, s.getValue());
	}
	
	@Test
	public void twoNumberTest() {
		Sum s = new Sum();
		s.add(3);
		s.add(12);
		assertEquals(15, s.getValue());
	}
}
