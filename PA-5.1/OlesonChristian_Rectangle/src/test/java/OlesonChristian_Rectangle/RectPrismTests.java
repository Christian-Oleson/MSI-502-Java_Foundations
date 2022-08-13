package OlesonChristian_Rectangle;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectPrismTests {

    @Test
    public void countRectPrismsCreated_shouldBeZero_whenNoRectPrismsHaveBeenCreated() {
        // Arrange
        int initialCountRectPrisms = RectPrism.getCountRectPrismsCreated();
        final int expected = 0;

        // Act
        var result = RectPrism.getCountRectPrismsCreated();

        // Assert
        assertEquals(expected + initialCountRectPrisms, result);
    }

    @Test
    public void countRectPrismsCreated_shouldBeExpectedCount_whenRectPrismHasBeenCreated() {
        // Arrange
        int initialCountRectPrisms = RectPrism.getCountRectPrismsCreated();
        final int countRectPrisms = 10;
        for (int i = 0; i < countRectPrisms; i++) {
            new RectPrism(0, 0, 0);
        }

        // Act
        var result = RectPrism.getCountRectPrismsCreated();

        // Assert
        assertEquals(countRectPrisms + initialCountRectPrisms, result);
    }

    @Test
    public void computeSurfaceArea_returnsExpectedSurfaceArea() {
        // Arrange
        final int height = 10;
        final int width = 10;
        final int depth = 10;
        var rectPrism = new RectPrism(height, width, depth);

        // Act
        var result = rectPrism.computeSurfaceArea();

        // Assert
        assertEquals(height * width, result);
    }

    @Test
    public void computeVolume_returnsExpectedVolume() {
        // Arrange
        final int height = 10;
        final int width = 10;
        final int depth = 10;
        var rectPrism = new RectPrism(height, width, depth);

        // Act
        var result = rectPrism.computeVolume();

        // Assert
        assertEquals(height * width * depth, result);
    }

    @Test
    public void toString_ReturnsExpectedString() {
        // Arrange
        final int height = 10;
        final int width = 10;
        final int depth = 10;
        var rectPrism = new RectPrism(height, width, depth);
        var expectedString = "RectPrism[height=" + height + ", width=" + width + ", depth=" + depth + "]";

        // Act
        var result = rectPrism.toString();

        // Assert
        assertEquals(expectedString, result);
    }
}