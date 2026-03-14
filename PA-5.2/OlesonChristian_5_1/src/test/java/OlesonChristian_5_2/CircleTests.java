package OlesonChristian_5_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircleTests {

    @Test
    public void constructor_setsCoordinatesAndRadius() {
        // Arrange & Act
        var circle = new Circle(2, 5, 3.0);

        // Assert
        assertEquals(2, circle.getX());
        assertEquals(5, circle.getY());
        assertEquals(3.0, circle.getRadius());
    }

    @Test
    public void setRadius_withPositiveValue_updatesRadius() {
        // Arrange
        var circle = new Circle(0, 0, 1.0);

        // Act
        circle.setRadius(5.5);

        // Assert
        assertEquals(5.5, circle.getRadius());
    }

    @Test
    public void setRadius_withZero_updatesRadius() {
        // Arrange
        var circle = new Circle(0, 0, 1.0);

        // Act
        circle.setRadius(0);

        // Assert
        assertEquals(0, circle.getRadius());
    }

    @Test
    public void setRadius_withNegativeValue_throwsIllegalArgumentException() {
        // Arrange
        var circle = new Circle(0, 0, 1.0);

        // Act & Assert
        var exception = assertThrows(IllegalArgumentException.class, () -> circle.setRadius(-5.0));
        assertEquals("All radii must be positive.", exception.getMessage());
    }

    @Test
    public void setRadius_withNegativeValue_doesNotChangeRadius() {
        // Arrange
        var circle = new Circle(0, 0, 3.0);

        // Act
        try {
            circle.setRadius(-1.0);
        } catch (IllegalArgumentException ignored) {
        }

        // Assert
        assertEquals(3.0, circle.getRadius());
    }

    @Test
    public void toString_containsCoordinatesAndRadius() {
        // Arrange
        var circle = new Circle(1, 2, 4.0);

        // Act
        var result = circle.toString();

        // Assert
        assertEquals("Circle [\n\tx = 1, \n\ty = 2, \n\tradius = 4.0\n]\n"
                + "Point [\n\tx = 1, \n\ty = 2\n]", result);
    }
}
