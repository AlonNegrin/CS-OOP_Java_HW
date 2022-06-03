import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Michal Hotovitz
 */
public class TestGetters {

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
	public void testGetCenter() {
		assertEquals(tr1.getCenter(), new Point(0, 0));
		assertEquals(tr2.getCenter(), new Point(0, 0));
		assertEquals(tr3.getCenter(), new Point(0, (double) -1 / 3));
		assertEquals(tr4.getCenter(), new Point(0, (double) -1 / 3));
		
		//test copy on getCenter
		tr3.getCenter().moveHorizontal(1);
		tr4.getCenter().moveHorizontal(1);
		assertEquals(tr3.getCenter(), new Point(0, (double) -1 / 3));
		assertEquals(tr4.getCenter(), new Point(0, (double) -1 / 3));
	}

	@Test
	public void testIsUpTriangle() {
		assertTrue(tr1.isUpTriangle());
		assertTrue(tr2.isUpTriangle());
		assertFalse(tr3.isUpTriangle());
		assertFalse(tr4.isUpTriangle());
	}

	@Test
	public void testHeight() {
		assertTrue(HW2Utils.areEqual(tr1.height(), 0.866));
		assertTrue(HW2Utils.areEqual(tr2.height(), 0.866));
		assertTrue(HW2Utils.areEqual(tr3.height(), 1));
		assertTrue(HW2Utils.areEqual(tr4.height(), 1));
	}

	@Test
	public void testLengthEdge() {
		assertTrue(HW2Utils.areEqual(tr1.getLengthEdge(), 1));
		assertTrue(HW2Utils.areEqual(tr2.getLengthEdge(), 1));
		assertTrue(HW2Utils.areEqual(tr3.getLengthEdge(), 2 / (Math.sqrt(3))));
		assertTrue(HW2Utils.areEqual(tr4.getLengthEdge(), 2 / (Math.sqrt(3))));
	}

	@Test
	public void testGetVertices() {
		Point[] verticesPoints = tr1.getVertices();
		assertEquals(verticesPoints[0], new Point(-0.5, -0.29));
		assertEquals(verticesPoints[1], new Point(0.5, -0.29));
		assertEquals(verticesPoints[2], new Point(0, 0.58));

		verticesPoints = tr2.getVertices();
		assertEquals(verticesPoints[0], new Point(-0.5, -0.29));
		assertEquals(verticesPoints[1], new Point(0.5, -0.29));
		assertEquals(verticesPoints[2], new Point(0, 0.58));

		verticesPoints = tr3.getVertices();
		assertEquals(verticesPoints[0], new Point(-1 / (Math.sqrt(3)), 0));
		assertEquals(verticesPoints[1], new Point(1 / (Math.sqrt(3)), 0));
		assertEquals(verticesPoints[2], new Point(0, -1));
		//test copy on getVertices
		verticesPoints[0].moveHorizontal(1);
		verticesPoints[1].moveHorizontal(1);
		verticesPoints[2].moveHorizontal(1);
		assertNotEquals(verticesPoints[0], new Point(-1 / (Math.sqrt(3)), 0));
		assertNotEquals(verticesPoints[1], new Point(1 / (Math.sqrt(3)), 0));
		assertNotEquals(verticesPoints[2], new Point(0, -1));

		verticesPoints = tr4.getVertices();
		assertEquals(verticesPoints[0], new Point(-1 / (Math.sqrt(3)), 0));
		assertEquals(verticesPoints[1], new Point(1 / (Math.sqrt(3)), 0));
		assertEquals(verticesPoints[2], new Point(0, -1));
		//test copy on getVertices
		verticesPoints[0].moveHorizontal(1);
		verticesPoints[1].moveHorizontal(1);
		verticesPoints[2].moveHorizontal(1);
		assertNotEquals(verticesPoints[0], new Point(-1 / (Math.sqrt(3)), 0));
		assertNotEquals(verticesPoints[1], new Point(1 / (Math.sqrt(3)), 0));
		assertNotEquals(verticesPoints[2], new Point(0, -1));
	}

	@Test
	public void testIsEqual() {
		assert tr1.isEqual(tr1);
		assert tr2.isEqual(tr2);
		assert tr3.isEqual(tr3);
		assert tr4.isEqual(tr4);

		assert tr1.isEqual(tr2);
		assert tr2.isEqual(tr1);
		assert tr1.isEqual(tr2);
		assert tr2.isEqual(tr1);

		System.out.println(tr3);
		System.out.println(tr4);
		assert tr3.isEqual(tr3);
		assert tr4.isEqual(tr4);
		assert tr3.isEqual(tr4);
		assert tr4.isEqual(tr3);

		assert !tr3.isEqual(tr1);
		assert !tr3.isEqual(tr2);
		assert !tr4.isEqual(tr1);
		assert !tr4.isEqual(tr2);
	}

}
