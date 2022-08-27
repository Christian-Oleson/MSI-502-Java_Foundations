package OlesonChristian_5_2;

//Write a class Cylinder. Since cylinders are circles with heights, the Cylinder class should extend the Circle class.
// Add the appropriate instance variable and include a constructor (again calling the constructor of the parent), an
//  accessor and a mutator method. Override the toString method to print the coordinates of the point, the radius, the
//  height and the volume of the cylinder, once again utilizing the parent’s toString().

/**
 * @author christian.oleson
 * @version 0.1
 * The Cylinder class that inherits from the Circle class
 */
public class Cylinder extends Circle {
    private double _height;
    private double _volume;

    public Cylinder(int x, int y, double radius, double height) {
        super(x, y, radius);
        _height = height;
        _volume = calculateVolume();
    }

    /**
     * Gets the height
     * @return double
     */
    public double getHeight() {
        return _height;
    }

    /**
     * Sets the height
     * @param height
     */
    public void setHeight(double height) {
        _height = height;
    }

    /**
     * Calculates the volume of the cylinder
     * @return
     */
    public double calculateVolume() {
        return Math.PI * getRadius() * getRadius() * getHeight();
    }

    public String toString() {
        return "Cylinder [\n\tx = " + getX()
                + ", \n\ty = " + getY()
                + ", \n\tradius = " + getRadius()
                + ", \n\tvolume = " + _volume
                + ", \n\theight = " + _height + "\n]\n"
                + super.toString();
    }
}
