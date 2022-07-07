/**
 * Sphere class
 * @author Christian Oleson
 * @version 1.0
 */
public class Sphere {
    private double radius;
    private double volume;
    private double surfaceArea;

    public Sphere(double radius) {
        this.radius = radius;
        this.volume = calculateVolume();
        this.surfaceArea = calculateSurfaceArea();
    }

    /**
     * Gets the volume of the sphere
     * @return volume of a sphere
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Gets the surface area of the sphere
     * @return surface area of a sphere
     */
    public double getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * Calculates the volume of the sphere
     * @return volume of a sphere
     */
    private double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    private double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}
