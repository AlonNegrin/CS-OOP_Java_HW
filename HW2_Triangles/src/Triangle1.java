public class Triangle1 extends absTriangle implements Triangle {

    Point center;
    double height;

    public Triangle1(Point center, double height) {

        if (height == 0) {
            this.center = new Point(0, 0);
            this.height = HW2Utils.getHeightFromLengthEdge(1);
        } else {
            this.center = center.copy();
            this.height = height;
        }
    }

    public Triangle1() {
        this.center = new Point(0, 0);
        this.height = HW2Utils.getHeightFromLengthEdge(1.0);
    }

    /**
     * @return an array of the three points of the circle.
     */
    public Point[] getVertices() {
        Point a = HW2Utils.getLeftPointFromCenterLengthEdge(getCenter(), getLengthEdge(), isUpTriangle());
        Point b = new Point(a.getX() + getLengthEdge(), a.getY());
        Point c = new Point(getCenter().getX(), a.getY() + this.height);
        return new Point[]{a, b, c};
    }

    /**
     * @return the center point. Note that this method should return a copy of the
     * center point, and not a reference to a field.
     */
    public Point getCenter() {
        return this.center.copy();
    }

    /**
     * @return the height of the triangle
     */
    public double height() {
        if (this.height > 0) {
            return this.height;
        } else {
            return this.height * (-1);
        }
    }

    /**
     * @return the length of an edge
     */
    public double getLengthEdge() {
        return HW2Utils.getLengthEdgeFromHeight(height());
    }


    /**
     * @return true if the thirs point is positive, otherwise return false
     */
    public boolean isUpTriangle() {
        return this.height > 0;
    }


    /**
     * @param p Move the center point of the triangle to be a copy of p. This method
     *          doesn't change the other parameters of the triangle. If p==null, then nothing is done.
     */
    public void setCenter(Point p) {
        if (p != null) {
            this.center = p.copy();
        }
    }

    /**
     * @param height update the height of the triangle without changing its center point, or its direction (up/down).
     *               If height<=0, then nothing is done.
     */
    public void updateHeight(double height) {
        if (height > 0) {
            if (this.height > 0) {
                this.height = height;
            } else {
                this.height = height * (-1);
            }
        }
    }

    /**
     * inverse the triangle, such that if the thirdVertex is upper that the others, it will be lower than them, and vice verse.
     */
    public void inverse() {
        this.height *= (-1);

    }

    /**
     * @param lengthEdge update the length of edge in the triangle without changing its center point, or its direction (up/down).
     *                   If lengthEdge<=0, then nothing is done.
     */
    public void updateLengthEdge(double lengthEdge){
        if (lengthEdge > 0){
            this.height = HW2Utils.getHeightFromLengthEdge(lengthEdge);

        }
    }

    /**
     * @param scalePar:double
     *            Multiply the edge's length of the triangle by scalePar (the center point is
     *            not changed). If scalePar<=0 then nothing is done.
     */
    public void scale(double scalePar){
        if (scalePar > 0){
            this.height = HW2Utils.getHeightFromLengthEdge(HW2Utils.getLengthEdgeFromHeight(this.height)) * scalePar;
        }
    }

    /**
     * @param delta:double
     *            Move the triangle (this) to the right by delta (Note that delta
     *            might be negative, and then the circle is moved to the left).
     */
    public void moveVertical(double delta);

    /**
     * @param delta:double
     *            Move up the triangle (this) by delta (Note that delta might be
     *            negative, and then the circle is moved down).
     */
    public void moveHorizontal(double delta);

    /**
     * @param delta:double
     *            Move the triangle (this) by delta.x horizontally, and by delta.y
     *            vertically. If delta==null, then nothing is done.
     */
    public void move(Point delta);

    /**
     * @param triangle:Triangle
     * @return True, if the "triangle" represents the same triangle as this. Otherwise return false.
     *         If triangle==null, then return false.
     *
     */
    public boolean isEqual(Triangle triangle);

    /**
     * @return the area (שטח) of the triangle
     */
    public double getArea();

    /**
     * @return the perimeter (היקף) of the triangle
     */
    public double getPerimeter();


    // A bonus of 8 points will be given for implementing the contains methods.

    /**
     * @param p:Point
     * @return True, if the triangle (this) contains the the point "p". Otherwise return false.
     *         If p==null, then return false.
     */
    public boolean contains(Point p);

    /**
     * @param triangle:Triangle
     * @return True, if the triangle (this) contains the parameter "triangle". Otherwise return false.
     *         If triangle==null, then return false.
     */
    public boolean contains(Triangle triangle);
}

