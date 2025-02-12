package ceLinearBinary;

import java.util.Objects;

/**
 * class Point
 * an instance of a Point will have an x value and a y, formatted as (x, y)
 */
public class Point implements Comparable<Point>{
	private int x;
	private int y;
	
	/**
	 * Constructor for class Point
	 * Instatiates the fields x and y
	 * @param x the x value
	 * @param y the y value
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * getter method for the field x
	 * @return x the x value
	 */
	public int getX() {
		return x;
	}

	/**
	 * getter method for the field y
	 * @return y the y value
	 */
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";	
	}
	
    @Override
    public int compareTo(Point other) {
        if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        }

        return Integer.compare(this.y, other.y);
    }

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
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
		return x == other.x && y == other.y;
	}
    
    
}
