package OlesonChristian_5_2;

// Write a class Circle. Since circles are described by a center point and a radius,
// the Circle class should extend the Point class. You need to add a private double for the radius.
// You should include a constructor, an accessor and a mutator method for the radius.
// The constructor should call the constructor of the parent.
// Negative radii are not permitted (check and print an error message in the mutator).
// You should override the toString method to print the coordinates of the point, the radius, and the area of the circle.
// The toString method should call the parent's toString() to retrieve the string with the coordinates of the point.

/**
 * @author christian.oleson
 * @version 0.1
 * The Circle class that inherits from the Point class
 */
public class Circle extends Point {
    private double _radius;

    public Circle(int x, int y, double radius) {
        super(x, y);
        _radius = radius;
    }

    /**
     * Gets the radius coordinate
     * @return double
     */
    public double getRadius() {
        return _radius;
    }

    /**
     * Sets the radius coordinate
     * @param radius
     */
    public void setRadius(double radius) {
        if (radius < 0){
            System.out.println("All radii must be positive.");
        }

        _radius = radius;
    }

    public String toString() {
        return "Circle [\n\tx = " + getX()
                + ", \n\ty = " + getY()
                + ", \n\tradius = " + _radius
                + "\n]\n"
                + super.toString();
    }
}
