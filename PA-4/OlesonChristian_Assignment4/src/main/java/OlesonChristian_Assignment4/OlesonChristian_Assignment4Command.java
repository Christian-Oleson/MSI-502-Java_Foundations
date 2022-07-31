package OlesonChristian_Assignment4;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine;

import java.text.DecimalFormat;
import java.util.Scanner;

/** Christian Oleson
 MSI-503
 Assignment 4
 */
@CommandLine.Command(name = "OlesonChristian_Assignment4Command", description = "...",
        mixinStandardHelpOptions = true)
public class OlesonChristian_Assignment4Command implements Runnable {

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(OlesonChristian_Assignment4Command.class, args);
    }

    /**
     * Run the application. This is the main entrypoint of the Micronaut CLI application. Here we request input from the
     * user and pass it to the application. Then, we process the results and display them to the user.
     */
    public void run() {
        var scanner = new Scanner(System.in);
        System.out.println("How many values do you want to enter? (must be an integer)");
        var arrayLength = scanner.nextInt();
        var numberArray = requestArrayOfIntFromUser(new float[arrayLength], scanner);
        var decimalFormat = new DecimalFormat("#.00");

        var mean = calculateMean(numberArray);
        System.out.println("The mean is " + decimalFormat.format(mean));
        var standardDeviation = calculateStandardDeviation(numberArray, mean);
        System.out.println("The standard deviation is " + decimalFormat.format(standardDeviation));
    }

    /**
     * Request an array of float from the user. While we are requesting integer values, we cast them to decimal values.
     * This helps keep the results more precise.
     * @param numberArray
     * @param scanner
     * @return
     */
    private float[] requestArrayOfIntFromUser(float[] numberArray, Scanner scanner) {
        System.out.println("Enter the values of the array as integers!");
        for (int i = 0; i < numberArray.length; i++) {
            System.out.println("Enter a value for index " + i + ":");
            numberArray[i] = scanner.nextInt();
        }

        return numberArray;
    }

    /**
     * Calculate the mean of an array of float.
     * @param numbers Array of integers.
     * @return float the mean of the array.
     */
    public float calculateMean(float[] numbers) {
        var sum = 0.0f;
        for (var i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum / numbers.length;
    }

    /**
     * Calculate the mean of an array of integers.
     * @param numbers Array of float.
     * @param mean The already calculated mean
     * @return float standard deviation
     */
    public float calculateStandardDeviation(float[] numbers, float mean) {
        var sum = 0f;
        for (var i = 0; i < numbers.length; i++) {
            sum += Math.pow(numbers[i] - mean, 2);
        }

        return (float)Math.sqrt(sum / numbers.length);
    }
}
