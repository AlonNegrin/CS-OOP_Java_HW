/**
 * @author Michal Hotovitz
 */
public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		this(0, 0);
	}

	public Point(Point p) {
		this(p.x, p.y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Point copy() {
		return new Point(this);
	}

	public void moveHorizontal(double delta) {
		x += delta;
	}

	public void moveVertical(double delta) {
		y += delta;
	}

	public void move(Point delta) {
		x += delta.x;
		y += delta.y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (!HW2Utils.areEqual(x, other.x))
			return false;
		if (!HW2Utils.areEqual(y, other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + HW2Utils.formatDouble(x) + ", y=" + HW2Utils.formatDouble(y) + "]";
	}

}
