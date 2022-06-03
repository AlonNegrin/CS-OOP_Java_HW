
public class HW2Utils {
	private static double PRECISION = 1.0e-2;
	
	/**
	 * @param height of the triangle
	 * @return the length of the edge of the triangle
	 */
	public static double getLengthEdgeFromHeight(double height) {
		return (height * 2) / (Math.sqrt(3));
	}

	/**
	 * @param lengthEdge of the triangle
	 * @return the height of the triangle
	 */
	public static double getHeightFromLengthEdge(double lengthEdge) {
		return (lengthEdge * Math.sqrt(3)) / 2;
	}

	/**
	 * @param leftPoint of the triangle
	 * @param lengthEdge of the triangle
	 * @param isUp - true, if the third vertex is higher than the other points. Otherwise, return false.
	 * @return the center point of the triangle.
	 */
	public static Point getCenterFromLeftPointLengthEdge(Point leftPoint, double lengthEdge, boolean isUp) {
		Point center = leftPoint.copy();
		double height = getHeightFromLengthEdge(lengthEdge);

		center.moveHorizontal(lengthEdge / 2);
		if (isUp)
			center.moveVertical(height / 3);
		else
			center.moveVertical(-height / 3);

		return center;
	}


	/**
	 * @param leftPoint of the triangle
	 * @param lengthEdge of the triangle
	 * @param isUp - true, if the third vertex is higher than the other points. Otherwise, return false.
	 * @return the left point of the triangle.
	 */
	public static Point getLeftPointFromCenterLengthEdge(Point center, double lengthEdge, boolean isUp) {

		Point leftPoint = center.copy();
		double height = getHeightFromLengthEdge(lengthEdge);

		leftPoint.moveHorizontal(-lengthEdge / 2);
		if (isUp)
			leftPoint.moveVertical(-height / 3);
		else
			leftPoint.moveVertical(height / 3);

		return leftPoint;
	}

	/**
	 * @param d : double
	 * @return String represents d with 2 places after the decimal point.
	 */
	public static String formatDouble(double d) {
		String res = String.format("%.2f", d);
		if (res.equals("-0.00"))
			res = "0.00";
		return res;
	}
	
	public static boolean areEqual(double d1, double d2) {
		return Math.abs(d1 - d2) < PRECISION;
	}
}
