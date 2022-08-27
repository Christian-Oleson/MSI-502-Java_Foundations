package OlesonChristian_5_2;

// Create a class Point. Points are described as having an (x,y) location.
// Instance variables should be private.
// Your class should contain a constructor that takes two integer values to set the point, accessor and mutator methods
// for the private instance variables and a toString method that prints the coordinates of the point.

/**
 * @author christian.oleson
 * @version 0.1
 * The Point class
 */
public class Point {
    private int _x;
    private int _y;

    public Point(int x, int y) {
        _x = x;
        _y = y;
    }

    /**
     * Gets the x coordinate
     * @return int
     */
    public int getX() {
        return _x;
    }

    /**
     * Gets the y coordinate
     * @return int
     */
    public int getY() {
        return _y;
    }

    /**
     * Sets the x coordinate
     * @param x
     */
    public void setX(int x) {
        _x = x;
    }

    /**
     * Sets the y coordinate
     * @param y
     */
    public void setY(int y) {
        _y = y;
    }

    public String toString() {
        return "Point [\n\tx = " + _x
                + ", \n\ty = " + _y
                + "\n]";
    }
}