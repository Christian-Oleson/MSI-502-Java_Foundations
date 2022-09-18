package FinalAssignment;

import java.util.Random;

/**
 * A class to extend the Java.Awt.Color class without inheritance.
 */
public class Color {

    /**
     * Randomly selects the major colors found in the java.awt.Color class
     */
    public static java.awt.Color getRandomColor() {
        var upperBound = 12;
        var random = new Random();
        var randomNum = random.nextInt(upperBound);

        switch (randomNum) {
            case 1:
                return java.awt.Color.black;
            case 2:
                return java.awt.Color.blue;
            case 3:
                return java.awt.Color.cyan;
            case 4:
                return java.awt.Color.darkGray;
            case 5:
                return java.awt.Color.gray;
            case 6:
                return java.awt.Color.green;
            case 7:
                return java.awt.Color.magenta;
            case 8:
                return java.awt.Color.orange;
            case 9:
                return java.awt.Color.pink;
            case 10:
                return java.awt.Color.red;
            case 11:
                return java.awt.Color.yellow;
            default:
                return java.awt.Color.lightGray;
        }
    }
}
