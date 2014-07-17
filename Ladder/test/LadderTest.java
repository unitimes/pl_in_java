import org.junit.Assert;

import junit.framework.TestCase;


public class LadderTest extends TestCase {
	Ladder lad;
	@Override
	protected void setUp() throws Exception {
		lad = new Ladder(6, 15);
	}
	//lad멤버를 private로 변환하여 실행
//	public void testLinkCols() throws Exception {
//		int j = 0;
//		for (int k = 0; k < 6; k++) {
//			for (int i = 0; i < 12; i++) {
//				if(lad.lad[k][i].getR_node() != null)
//					j++;
//			}
//		}
//		Assert.assertEquals(15, j);
//	}
}
