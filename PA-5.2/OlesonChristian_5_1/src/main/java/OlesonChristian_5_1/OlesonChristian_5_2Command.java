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
public class OlesonChristian_5_2Command implements Runnable {

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(OlesonChristian_5_2Command.class, args);
    }

    /** The runner method
     */
    public void run() {

        var scanner = new Scanner(System.in);
        var points = new ArrayList<Point>();
        System.out.println("Please input the coordinates in the format: X Y Radius Height");
        System.out.println("Use a single space between values.");

        for (int i = 0; i < 3; i++) {
            System.out.println("Value # " + (i + 1));
            var input = scanner.nextLine();
            var values = input.split("\\s", 5);
            var x = Integer.parseInt(values[0]);
            var y = Integer.parseInt(values[1]);
            var radius = Double.parseDouble(values[2]);
            var height = Double.parseDouble(values[3]);
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
