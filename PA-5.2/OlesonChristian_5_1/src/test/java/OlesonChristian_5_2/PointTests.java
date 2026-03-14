package OlesonChristian_5_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTests {

    @Test
    public void constructor_setsCoordinates() {
        // Arrange & Act
        var point = new Point(3, 7);

        // Assert
        assertEquals(3, point.getX());
        assertEquals(7, point.getY());
    }

    @Test
    public void setX_updatesXCoordinate() {
        // Arrange
        var point = new Point(0, 0);

        // Act
        point.setX(5);

        // Assert
        assertEquals(5, point.getX());
    }

    @Test
    public void setY_updatesYCoordinate() {
        // Arrange
        var point = new Point(0, 0);

        // Act
        point.setY(10);

        // Assert
        assertEquals(10, point.getY());
    }

    @Test
    public void toString_returnsExpectedFormat() {
        // Arrange
        var point = new Point(4, 8);

        // Act
        var result = point.toString();

        // Assert
        assertEquals("Point [\n\tx = 4, \n\ty = 8\n]", result);
    }
}
