import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/** Christian Oleson
 * MSI-503
 * Assignment 2.1
 */
public class Program {
    /** This constant is the average road width in Kilometers. 1 Km = 1000 m */
    public static final double AVG_AUSSIE_ROAD_WIDTH_KILOMETERS = .01;
    /** This constant is probability coefficient that a kangaroo will be killed. */
    public static final double ROAD_KILL_PROBABILITY_CONSTANT = 1.47;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter the side length of the square of land (in kilometers): ");
        var sideOfSquare = scanner.nextDouble();
        System.out.print("Enter the road length running through the square (in kilometers): ");
        var roadsThroughSquare = scanner.nextDouble();
        System.out.print("Enter number of kangaroos living in the square: ");
        var numberOfKangaroos = scanner.nextInt();

        var expectedKangarooKills = expectedKangarooKills(sideOfSquare, roadsThroughSquare, numberOfKangaroos);
        System.out.println("Expected number of kills: " + expectedKangarooKills);
    }

    /** This method calculates the square of a double.
     * @param sideOfSquare The side of the square. We assume we only have square land.
     * @return The square of the input.
     * */
    public static double calculateSquare(double sideOfSquare) {
        return Math.pow(sideOfSquare, 2);
    }

    /** This method finds the amount of kangaroos per square "space".
     * We use space to indicate that any value could be used.
     * In the future, we could make this more generic, so we don't care if it is
     * Kangaroos, or apples, or snakes.
     * @param numberOfKangaroos The number of kangaroos living in the square.
     * @param squareSpace The square area of the land.
     * */
    public static double numberOfKangaroosPerSquareKilometer(int numberOfKangaroos, double squareSpace) {
        return (double)numberOfKangaroos / squareSpace;
    }

    /** This method calculates the road surface area.
     * @param roadsThroughArea The length of the roads running through the square.
     * @return The total surface area of the roads.
     * */
    private static double calculateRoadSurfaceArea(double roadsThroughArea) {
        return (roadsThroughArea * AVG_AUSSIE_ROAD_WIDTH_KILOMETERS) * ROAD_KILL_PROBABILITY_CONSTANT;
    }

    /** This method calculates how many kangaroos we expected to be killed within a specific area
     * @param lengthOfSquareLand  the length of the square side of the land in kilometers (double)
     * @param roadLengthThroughLand the length of the road through the land in kilometers (double)
     * @param numberKangaroos the number of kangaroos in the area (integer)
     * @return the expected number of kangaroos to be killed
     * */
    public static double expectedKangarooKills(double lengthOfSquareLand, double roadLengthThroughLand, int numberKangaroos) {
        var squareSpace = calculateSquare(lengthOfSquareLand);
        var numberOfKangaroosPerArea = numberOfKangaroosPerSquareKilometer(numberKangaroos, squareSpace);
        var roadSurfaceArea = calculateRoadSurfaceArea(roadLengthThroughLand);

        var numberOfKills =  numberOfKangaroosPerArea * roadSurfaceArea;

        var bigDecimal = new BigDecimal(Double.toString(numberOfKills));
        bigDecimal = bigDecimal.setScale(3, RoundingMode.CEILING);
        return bigDecimal.doubleValue();
    }
}
