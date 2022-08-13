package OlesonChristian_Rectangle;

import java.util.Arrays;

/* Demo class
* @author Christian Oleson
* @version 1.0
* Demos the Rectangle and RectPrism classes, showing off all methods, getters, and setters.
 */
public class Demo {
    public static void main(String[] args) {
        var arrayOfRectangles = new Rectangle[]
            {
                new Rectangle(1, 1),
                new Rectangle(2, 2),
                new Rectangle(3, 3),
                new Rectangle(4, 4),
                new Rectangle(5, 5),
                new RectPrism(1, 2, 3),
                new RectPrism(2, 4, 6),
                new RectPrism(3, 6, 9),
                new RectPrism(4, 8, 12),
                new RectPrism(5, 10, 15)
            };
        var countRectangularPrisms = Arrays.stream(arrayOfRectangles).filter(rectangle -> rectangle instanceof RectPrism).count();
        // Show the count of each type in the array to compare with the count of each type in the Rectangle and RectPrism classes.
        System.out.println("There are " + arrayOfRectangles.length + " rectangles in the array.");
        System.out.println("There are " + countRectangularPrisms + " rectangular prisms in the array.");
        // Show that the count variables in the Rectangle and RectPrism classes have the correct values.
        System.out.println("The count of rectangles created is " + Rectangle.getCountRectanglesCreated());
        System.out.println("The count of rectPrisms created is " + RectPrism.getCountRectPrismsCreated());
        System.out.println("-------------------------------------------------------------------------------------");

        // Iterate through the objects to show everything works as expected.
        for (var rectangle : arrayOfRectangles) {
            System.out.println("Object: " + rectangle.hashCode());
            var height = rectangle.getHeight();
            var width = rectangle.getWidth();
            printValuesOfRectangle(rectangle, "Original");
            rectangle.setHeight(height * height);
            rectangle.setWidth(width * width);
            printValuesOfRectangle(rectangle, "Updated");
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }

    /* Prints the values of the rectangle.
     * @param rectangle The rectangle to print the values of.
     * @param message The message to print before the values of the rectangle.
     */
    private static void printValuesOfRectangle(Rectangle rectangle, String type) {
        System.out.println(type + " Surface Area: " + rectangle.computeSurfaceArea());
        System.out.println(type + " Height: " + rectangle.getHeight());
        System.out.println(type + " Width: " + rectangle.getWidth());
        if (rectangle instanceof RectPrism) {
            var depth = ((RectPrism) rectangle).getDepth();
            System.out.println(type + " Depth: " + depth);
            System.out.println(type + " Volume: " + ((RectPrism) rectangle).computeVolume());
            ((RectPrism) rectangle).setDepth(depth * depth);
        }
    }
}
