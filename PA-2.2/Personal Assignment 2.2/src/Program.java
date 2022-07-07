import java.util.Scanner;

/** Christian Oleson
 * MSI-503
 * Programming Assignment 2.2
 */
public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the radius of the sphere: ");
        double radius = input.nextDouble();

        Sphere sphere = new Sphere(radius);
        System.out.println("The volume of your sphere is: " + sphere.getVolume());
        System.out.println("The surface area of your sphere is: " + sphere.getSurfaceArea());
    }
}
