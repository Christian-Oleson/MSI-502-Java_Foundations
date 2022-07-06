//*********************************************************************************************************************
// The program needs to get the following information from the user:
// - The length of the side of the square of land (in kilometers).
// - The length of the roads running through the square (in kilometers).
// - The number of kangaroos living in that square.
//*********************************************************************************************************************

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/** Christian Oleson
 * MSI-503
 * Assignment 1
 */
public class Program {
    public static final double AVG_AUSSIE_ROAD_WIDTH_KILOMETERS = .01;
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

    public static double calculateSquare(double sideOfSquare) {
        return Math.pow(sideOfSquare, 2);
    }

    public static double numberOfUnitsPerSquare(int numberOfUnits, double squareSpace) {
        return (double)numberOfUnits / squareSpace;
    }

    public static double calculateRoadSurfaceArea(double roadsThroughArea) {
        return (roadsThroughArea * AVG_AUSSIE_ROAD_WIDTH_KILOMETERS) * ROAD_KILL_PROBABILITY_CONSTANT;
    }

    public static double expectedKangarooKills(double lengthOfSquareLand, double roadLengthThroughLand, int numberKangaroos) {
        var squareSpace = calculateSquare(lengthOfSquareLand);
        var numberOfKangaroosPerArea = numberOfUnitsPerSquare(numberKangaroos, squareSpace);
        var roadSurfaceArea = calculateRoadSurfaceArea(roadLengthThroughLand);

        var numberOfKills =  numberOfKangaroosPerArea * roadSurfaceArea;

        var bigDecimal = new BigDecimal(Double.toString(numberOfKills));
        bigDecimal = bigDecimal.setScale(3, RoundingMode.CEILING);
        return bigDecimal.doubleValue();
    }
}
