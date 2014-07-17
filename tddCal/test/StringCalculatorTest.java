import org.junit.Assert;

import junit.framework.TestCase;


public class StringCalculatorTest extends TestCase {
	private StringCalculator cal;
	@Override
	protected void setUp() throws Exception {
		cal = new StringCalculator();
	}
	public void testSplitWhenComma() throws Exception {
		Assert.assertArrayEquals(new String[]{"1","2","3"}, cal.split("1,2,3"));
	}
	public void testSplitWhenEnter() throws Exception {
		Assert.assertArrayEquals(new String[]{"1","2","3"}, cal.split("1\n2\n3"));
	}
}
