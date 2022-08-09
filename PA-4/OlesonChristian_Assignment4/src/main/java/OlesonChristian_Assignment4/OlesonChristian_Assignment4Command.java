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
     * user and pass it to the application. Then, we process the results and display them to the user. While we have
     * individual methods that do work, this is essentially the business logic of the application. Likewise, if the
     * user at any point inputs anything aside from an integer, we will throw an exception. The requirements say nothing
     * about supporting error handling. In the end, we are just trying to make the application as simple as possible.
     * However, in the future we could iterate on this by wrapping the application in a try/catch block and handling
     * the error, hopefully just requesting the input be correct.
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
     * Requests the array values from the user, depending on the initial input indicating how long the array will be.
     * While we are requesting integer values, we cast them to decimal values, helps keep the results more precise and
     * also meets the requirements of the assignment.
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
