package OlesonChristian_Rectangle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTests {

    @Test
    public void countRectanglesCreated_shouldBeZero_whenNoRectanglesHaveBeenCreated() {
        // Arrange
        int initialCountRectangles = Rectangle.getCountRectanglesCreated();
        final int expected = 0;

        // Act
        var result = Rectangle.getCountRectanglesCreated();

        // Assert
        assertEquals(expected + initialCountRectangles, result);
    }

    @Test
    public void countRectanglesCreated_shouldBeExpectedCount_whenRectangleHasBeenCreated() {
        // Arrange
        int initialCountRectangles = Rectangle.getCountRectanglesCreated();
        final int countRectangles = 10;
        for (int i = 0; i < countRectangles; i++) {
            new Rectangle(0, 0);
        }

        // Act
        var result = Rectangle.getCountRectanglesCreated();

        // Assert
        assertEquals(countRectangles + initialCountRectangles, result);
    }

    @Test
    public void computeSurfaceArea_returnsExpectedSurfaceArea() {
        // Arrange
        final int height = 10;
        final int width = 10;
        var rectangle = new Rectangle(height, width);

        // Act
        var result = rectangle.computeSurfaceArea();

        // Assert
        assertEquals(height * width, result);
    }

    @Test
    public void toString_ReturnsExpectedString() {
        // Arrange
        final int height = 10;
        final int width = 10;
        var rectangle = new Rectangle(height, width);
        var expectedString = "Rectangle [\n\theight = " + height + ", \n\twidth = " + width + "\n]";

        // Act
        var result = rectangle.toString();

        // Assert
        assertEquals(expectedString, result);
    }
}