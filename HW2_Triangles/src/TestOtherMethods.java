import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Michal Hotovitz
 */
public class TestOtherMethods {

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
	public void testAreaAndPermeter() {
		assertTrue(HW2Utils.areEqual(tr1.getArea(), Math.sqrt(3) / 4));
		assertTrue(HW2Utils.areEqual(tr2.getArea(), Math.sqrt(3) / 4));
		assertTrue(HW2Utils.areEqual(tr3.getArea(), 1 / (Math.sqrt(3))));
		assertTrue(HW2Utils.areEqual(tr4.getArea(), 1 / (Math.sqrt(3))));

		assertTrue(HW2Utils.areEqual(tr1.getPerimeter(), 3));
		assertTrue(HW2Utils.areEqual(tr2.getPerimeter(), 3));
		assertTrue(HW2Utils.areEqual(tr3.getPerimeter(), 6 / (Math.sqrt(3))));
		assertTrue(HW2Utils.areEqual(tr4.getPerimeter(), 6 / (Math.sqrt(3))));
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
