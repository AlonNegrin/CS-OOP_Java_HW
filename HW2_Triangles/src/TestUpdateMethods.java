import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Michal Hotovitz
 */
public class TestUpdateMethods {

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
	public void testMoveHorizontalAndMoveVertical() {
		testMoveHorisontal();
		setUp();
		testMoveVertical();
	}
	
	private void testMoveHorisontal() {
		tr1.moveHorizontal(1);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), new Point(1, 0));

		tr2.moveHorizontal(1);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), tr2.getCenter());

		tr1.moveHorizontal(-0.5);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), new Point(0.5, 0));

		tr2.moveHorizontal(-0.5);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), tr2.getCenter());
	}

	private void testMoveVertical() {
		tr1.moveVertical(1);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), new Point(0, 1));

		tr2.moveVertical(1);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), tr2.getCenter());

		tr1.moveVertical(-0.5);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), new Point(0, 0.5));

		tr2.moveVertical(-0.5);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), tr2.getCenter());
	}

	@Test
	public void testMove() {
		Point movePoint = new Point(-0.2, 1);
		tr1.move(movePoint);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), new Point(-0.2, 1));

		tr2.move(movePoint);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), tr2.getCenter());
	}

	@Test
	public void testScale() {

		// scale with parametr<=0 (nothing is done).
		tr1.updateLengthEdge(-1);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), tr2.getCenter());

		tr1.updateLengthEdge(0);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), tr2.getCenter());

		tr2.updateLengthEdge(-1);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), tr2.getCenter());

		tr2.updateLengthEdge(0);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(), 1));
		assertEquals(tr1.getCenter(), tr2.getCenter());

		// test scale
		tr1.scale(0.3);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(), 0.3));
		assertEquals(tr1.getCenter(), tr2.getCenter());

		tr2.scale(0.3);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(), 0.3));
		assertEquals(tr1.getCenter(), tr2.getCenter());

		tr1.scale(3);
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(), 0.9));
		assertEquals(tr1.getCenter(), tr2.getCenter());

		tr2.scale(3);
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(), 0.9));
		assertEquals(tr1.getCenter(), tr2.getCenter());

	}

}
