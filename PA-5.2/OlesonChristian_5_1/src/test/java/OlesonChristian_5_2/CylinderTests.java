package OlesonChristian_5_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CylinderTests {

    @Test
    public void constructor_setsAllProperties() {
        // Arrange & Act
        var cylinder = new Cylinder(1, 2, 3.0, 5.0);

        // Assert
        assertEquals(1, cylinder.getX());
        assertEquals(2, cylinder.getY());
        assertEquals(3.0, cylinder.getRadius());
        assertEquals(5.0, cylinder.getHeight());
    }

    @Test
    public void calculateVolume_returnsExpectedVolume() {
        // Arrange
        var cylinder = new Cylinder(0, 0, 3.0, 5.0);
        var expected = Math.PI * 9.0 * 5.0;

        // Act
        var result = cylinder.calculateVolume();

        // Assert
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void calculateVolume_afterSetHeight_reflectsNewHeight() {
        // Arrange
        var cylinder = new Cylinder(0, 0, 2.0, 3.0);
        cylinder.setHeight(10.0);
        var expected = Math.PI * 4.0 * 10.0;

        // Act
        var result = cylinder.calculateVolume();

        // Assert
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void calculateVolume_afterSetRadius_reflectsNewRadius() {
        // Arrange
        var cylinder = new Cylinder(0, 0, 2.0, 5.0);
        cylinder.setRadius(4.0);
        var expected = Math.PI * 16.0 * 5.0;

        // Act
        var result = cylinder.calculateVolume();

        // Assert
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void toString_containsVolumeCalculatedOnDemand() {
        // Arrange
        var cylinder = new Cylinder(0, 0, 1.0, 1.0);

        // Act
        var result = cylinder.toString();

        // Assert
        var expectedVolume = Math.PI;
        assertEquals(true, result.contains("volume = " + expectedVolume));
    }

    @Test
    public void setHeight_updatesHeight() {
        // Arrange
        var cylinder = new Cylinder(0, 0, 1.0, 2.0);

        // Act
        cylinder.setHeight(7.5);

        // Assert
        assertEquals(7.5, cylinder.getHeight());
    }
}
