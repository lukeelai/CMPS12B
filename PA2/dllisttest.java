// Luke Lai Gabriel Reyes
// 1355154 1348575
// luelai ghreyes
// 10/29/14
// dllistTest.java
// Unit tests for dllist

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class dllistTest {

    	@Test
    	public void startsEmptyTest() {
        	dllist lst = new dllist();
        	assertEquals(true, lst.isEmpty());
    	}
	
	@Test
	public void emptyTest(){
		dllist lst = new dllist();
		lst.insert("I am a robot", dllist.position.FIRST);
		assertEquals(false, lst.isEmpty());
	}
	
	@Test 
	public void insertLastTest(){
		dllist lst = new dllist();
		lst.insert("efgh", dllist.position.FIRST);
		lst.insert("abcd", dllist.position.FIRST);
		lst.insert("ijkl", dllist.position.LAST);
		assertEquals("ijkl", lst.getItem());
	}

	@Test
	public void insertLastTest2(){
		dllist lst = new dllist();
		lst.insert("I am a robot", dllist.position.LAST);
		assertEquals("I am a robot", lst.getItem());
	}

	@Test
	public void insertFirstTest(){
		dllist lst = new dllist();
		lst.insert("I am a robot", dllist.position.FIRST);
		lst.insert("I think", dllist.position.FIRST);
		assertEquals("I think", lst.getItem());
	}
	
	@Test
	public void insertFirstTest2(){
		dllist lst = new dllist();
		lst.insert("I am a robot", dllist.position.FIRST);
		lst.insert("...or am I...?", dllist.position.LAST);
		lst.insert("I think", dllist.position.FIRST);
		assertEquals("I think", lst.getItem());
	}

	@Test
	public void setPosTest(){
		dllist lst = new dllist();
		lst.insert("efgh", dllist.position.FIRST);
		lst.insert("abcd", dllist.position.FIRST);
		lst.insert("ijkl", dllist.position.LAST);
		lst.setPosition(dllist.position.FIRST);
		assertEquals("abcd", lst.getItem());
	}
	
	@Test
	public void setPosTest2(){
		dllist lst = new dllist();
		lst.insert("ijkl", dllist.position.FIRST);
		lst.insert("efgh", dllist.position.FIRST);
		lst.insert("abcd", dllist.position.FIRST);
		lst.setPosition(dllist.position.LAST);
		assertEquals("ijkl", lst.getItem());
	}
	
	@Test
	public void step16Part1Test(){
		dllist lst = new dllist();
		lst.insert("A", dllist.position.LAST);
		lst.insert("B", dllist.position.LAST);
		lst.insert("C", dllist.position.LAST);
		lst.insert("D", dllist.position.PREVIOUS);
		lst.setPosition(dllist.position.LAST);
		assertEquals("C", lst.getItem());
	}
		
	@Test
	public void step16Part2Test(){
		dllist lst = new dllist();
		lst.insert("A", dllist.position.FIRST);
		lst.insert("B", dllist.position.FIRST);
		lst.insert("C", dllist.position.FIRST);
		lst.insert("D", dllist.position.FOLLOWING);
		lst.setPosition(dllist.position.FIRST);
		assertEquals("C", lst.getItem());
	}

	@Test
	public void step17Test(){
		dllist lst = new dllist();
		lst.insert("A", dllist.position.FIRST);
		lst.insert("B", dllist.position.LAST);
		lst.insert("C", dllist.position.FOLLOWING);
		lst.insert("D", dllist.position.LAST);
		lst.setPosition(dllist.position.PREVIOUS);
		lst.setPosition(dllist.position.PREVIOUS);
		assertEquals("B", lst.getItem());
	}
	
	@Test
	public void step18Test(){
		dllist lst = new dllist();
		lst.insert("C", dllist.position.FIRST);
		lst.insert("A", dllist.position.FIRST);
		lst.setPosition(dllist.position.FOLLOWING);
		lst.insert("E", dllist.position.FOLLOWING);
		lst.insert("D", dllist.position.PREVIOUS);
		lst.setPosition(dllist.position.PREVIOUS);
		lst.setPosition(dllist.position.PREVIOUS);
		lst.setPosition(dllist.position.FOLLOWING);
		lst.insert("B", dllist.position.PREVIOUS);
		lst.setPosition(dllist.position.FIRST);
		assertEquals("A", lst.getItem());
		lst.setPosition(dllist.position.FOLLOWING);
		assertEquals("B", lst.getItem());
		lst.setPosition(dllist.position.FOLLOWING);
		assertEquals("C", lst.getItem());
		lst.setPosition(dllist.position.FOLLOWING);
		assertEquals("D", lst.getItem());
		lst.setPosition(dllist.position.FOLLOWING);
		assertEquals("E", lst.getItem());
	}

	@Test
	public void step20GetPositionTest(){
		dllist lst = new dllist();
		lst.insert("C", dllist.position.FIRST);
		assertEquals(1, lst.getPosition());
		lst.insert("A", dllist.position.FIRST);
		assertEquals(1, lst.getPosition());
		lst.setPosition(dllist.position.FOLLOWING);
		lst.insert("E", dllist.position.FOLLOWING);
		assertEquals(3, lst.getPosition());
		lst.insert("D", dllist.position.PREVIOUS);
		assertEquals(3, lst.getPosition());
		lst.setPosition(dllist.position.PREVIOUS);
		lst.setPosition(dllist.position.PREVIOUS);
		lst.setPosition(dllist.position.FOLLOWING);
		lst.insert("B", dllist.position.PREVIOUS);
		assertEquals(2, lst.getPosition());
	}
	
	@Test
	public void step22DeleteTest(){
		dllist lst = new dllist();
		lst.insert("A", dllist.position.FIRST);
		lst.insert("B", dllist.position.FOLLOWING);
		lst.insert("C", dllist.position.FOLLOWING);
		lst.insert("D", dllist.position.FOLLOWING);
		lst.insert("E", dllist.position.FOLLOWING);
		lst.delete();
		assertEquals(4, lst.getPosition());
		assertEquals("D", lst.getItem());
	}

	@Test
	public void step22DeleteTest2(){
		dllist lst = new dllist();
		lst.insert("A", dllist.position.FIRST);
		lst.insert("B", dllist.position.FOLLOWING);
		lst.insert("C", dllist.position.FOLLOWING);
		lst.insert("D", dllist.position.FOLLOWING);
		lst.insert("E", dllist.position.FOLLOWING);
		lst.setPosition(dllist.position.PREVIOUS);
		lst.setPosition(dllist.position.PREVIOUS);
		assertEquals(3, lst.getPosition());
		lst.delete();
		lst.setPosition(dllist.position.FIRST);
		assertEquals("A", lst.getItem());
		lst.setPosition(dllist.position.FOLLOWING);
		assertEquals("B", lst.getItem());
		lst.setPosition(dllist.position.FOLLOWING);
		assertEquals("D", lst.getItem());
		lst.setPosition(dllist.position.FOLLOWING);
		assertEquals("E", lst.getItem());
	}

	@Test(expected = Exception.class)
	public void step23error(){
		dllist lst = new dllist();
		lst.getPosition();
		
	}	

	@Test(expected = Exception.class)
	public void step23error2(){
		dllist lst = new dllist();
		lst.delete();
	}
}
