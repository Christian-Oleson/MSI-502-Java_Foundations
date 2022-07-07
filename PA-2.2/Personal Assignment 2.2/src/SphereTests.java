import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SphereTests {
    @Test
    public void Sphere_HasRadius_ReturnsExpectedVolume() {
        // Arrange
        Sphere sphere = new Sphere(5);
        var expectedVolume = 523.59878;

        // Act
        var result = sphere.getVolume();

        // Assert
        assertEquals(expectedVolume, result, 0.001);
    }

    @Test
    public void Sphere_HasSurfaceArea_ReturnsExpectedSurfaceArea() {
        // Arrange
        Sphere sphere = new Sphere(10);
        var expectedSurfaceArea = 1256.637;

        // Act
        var result = sphere.getSurfaceArea();

        // Assert
        assertEquals(expectedSurfaceArea, result, 0.001);
    }
}
