package FinalAssignment;

import java.util.Random;

/**
 * A class to extend the Java.Awt.Color class without inheritance.
 */
public class Color {

    private Color() {}

    /**
     * Randomly selects the major colors found in the java.awt.Color class
     */
    public static java.awt.Color getRandomColor() {
        var upperBound = 12;
        var random = new Random();
        var randomNum = random.nextInt(upperBound);

        return switch (randomNum) {
            case 1 -> java.awt.Color.black;
            case 2 -> java.awt.Color.blue;
            case 3 -> java.awt.Color.cyan;
            case 4 -> java.awt.Color.darkGray;
            case 5 -> java.awt.Color.gray;
            case 6 -> java.awt.Color.green;
            case 7 -> java.awt.Color.magenta;
            case 8 -> java.awt.Color.orange;
            case 9 -> java.awt.Color.pink;
            case 10 -> java.awt.Color.red;
            case 11 -> java.awt.Color.yellow;
            default -> java.awt.Color.lightGray;
        };
    }
}
