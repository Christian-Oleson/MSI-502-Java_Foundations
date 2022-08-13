package OlesonChristian_Rectangle;

/*
@author Christian Oleson
@version 1.0
The Rectangle class which creates a rectangle
 */
public class Rectangle {
    private int height;
    private int width;
    private static int countRectanglesCreated = 0;

    public Rectangle(int height, int width) {
        setHeight(height);
        setWidth(width);
        countRectanglesCreated++;
    }

    /*
    @return the height of the Rectangle
     */
    public int getHeight() {
        return height;
    }

    /*
    @param height set the height of the Rectangle
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /*
    @return the width of the Rectangle
     */
    public int getWidth() {
        return width;
    }

    /*
    @param width set the width of the Rectangle
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /*
    @return the count of rectangles created
     */
    public static int getCountRectanglesCreated() {
        return countRectanglesCreated;
    }

    /*
    @return the surface area of the rectangle
     */
    public int computeSurfaceArea() {
        return getHeight() * getWidth();
    }

    /*
    @return the string representation of the rectangle
     */
    public String toString() {
        return "Rectangle [\n\theight = " + height + ", \n\twidth = " + width + "\n]";
    }
}
