import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Michal Hotovitz
 */
public class TestSetters {

	Triangle tr1;
	Triangle tr2;
	Triangle tr3;
	Triangle tr4;

	@Before
	public void setUp() {
		tr1 = new Triangle1();
		tr2 = new Triangle2();

		tr3 = new Triangle1(new Point(0, (double) -1 / 3), -1);
		tr4 = new Triangle2(new Point(-1 / (Math.sqrt(3)), 0), 2 / (Math.sqrt(3)), false);
	}

	@Test
	public void testSetCenter() {
		Point newCenter = new Point(1,1);
		tr1.setCenter(newCenter);
		assertTrue(HW2Utils.areEqual(tr1.height(),tr2.height()));
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(),tr2.getLengthEdge()));
		assertEquals(tr1.getCenter(), newCenter);
		
		tr2.setCenter(newCenter);
		assertTrue(HW2Utils.areEqual(tr1.height(),tr2.height()));
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(),tr2.getLengthEdge()));
		assertEquals(tr2.getCenter(), newCenter);
		
		//test copy on setCenter
		newCenter.moveHorizontal(1);
		assertNotEquals(tr1.getCenter(), newCenter);
		assertNotEquals(tr2.getCenter(), newCenter);
	}

	@Test
	public void testInverse() {
		tr1.inverse();
		tr2.inverse();
		assertFalse(tr1.isUpTriangle());
		assertFalse(tr2.isUpTriangle());
		
		tr3.inverse();
		tr4.inverse();
		assertTrue(tr3.isUpTriangle());
		assertTrue(tr4.isUpTriangle());
	}

	@Test
	public void testSetHeight() {
		tr1.updateHeight(2);
		assertTrue(HW2Utils.areEqual(tr1.height(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
		
		tr2.updateHeight(2);
		assertTrue(HW2Utils.areEqual(tr2.height(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
		
		tr1.updateHeight(-1);
		assertTrue(HW2Utils.areEqual(tr1.height(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
		
		tr1.updateHeight(0);
		assertTrue(HW2Utils.areEqual(tr1.height(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
		
		tr2.updateHeight(-1);
		assertTrue(HW2Utils.areEqual(tr2.height(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
		
		tr2.updateHeight(0);
		assertTrue(HW2Utils.areEqual(tr2.height(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
	}

	@Test
	public void testSetLengthEdge() {	
		tr1.updateLengthEdge(2);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
		
		tr2.updateLengthEdge(2);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
		
		tr1.updateLengthEdge(-1);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
		
		tr1.updateLengthEdge(0);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
		
		tr2.updateLengthEdge(-1);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
		
		tr2.updateLengthEdge(0);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(),2));
		assertEquals(tr1.getCenter(), tr2.getCenter());
	}

}
