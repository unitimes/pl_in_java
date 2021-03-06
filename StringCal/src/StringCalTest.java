import static org.junit.Assert.*;

import org.junit.Test;


public class StringCalTest {

	StringCal cal = new StringCal();
	@Test
	public void testSplit() {
		assertArrayEquals(new String[]{"a", "b"}, cal.split("a,b"));
	}

	@Test
	public void testConvert() {
		assertArrayEquals(new int[]{3,4}, cal.convert(new String[]{"3","4"}));
	}

	@Test
	public void testSum() {
		assertEquals(7, cal.sum(new int[]{3,4}));
	}

	@Test
	public void testAdd() {
		assertEquals(7, cal.add("3,4"));
	}

	
}
