package OlesonChristian_5_1;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

/** Christian Oleson
 * MSI-503
 * Assignment 5.2
 */
@Command(name = "OlesonChristian_5_1", description = "...",
        mixinStandardHelpOptions = true)
public class OlesonChristian_5_1Command implements Runnable {

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(OlesonChristian_5_1Command.class, args);
    }

    public void run() {

        var scanner = new Scanner(in);
        var points = new ArrayList<Point>();

        for (int i = 0; i < 3; i++) {
            System.out.println("X Coordinate: ");
            var x = scanner.nextInt();
            System.out.println("Y Coordinate: ");
            var y = scanner.nextInt();
            System.out.println("Radius: ");
            var radius = scanner.nextDouble();
            System.out.println("Height: ");
            var height = scanner.nextDouble();
            var point = new Point(x, y);
            var circle = new Circle(x, y, radius);
            var cylinder = new Cylinder(x, y, radius, height);
            points.add(point);
            points.add(circle);
            points.add(cylinder);
        }

        System.out.println("---------------------------------------------------------------------------------------------");
        for (var point = points.iterator(); point.hasNext();) {
            var item = point.next();
            System.out.println("-------------------------------" + item.getClass() + "-------------------------------");
            System.out.println(item);
            System.out.println("---------------------------------------------------------------------------------------------");
        }
    }
}
