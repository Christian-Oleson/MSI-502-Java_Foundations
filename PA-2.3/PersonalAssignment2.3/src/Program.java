import java.text.DecimalFormat;
import java.util.Scanner;

/** Christian Oleson
 * MSI-503
 * Programming Assignment 2.3
 * This program reads an input of temperature from the user in Fahrenheit and converts it to Celsius.
 * Once it is done, it prints the temperature in both Celsius and Fahrenheit to the console.
 * Likewise, it continues to iterate on potential values, incrementing the fahrenheit value by 10 each time for a total of 20 values.
 * @author Christian Oleson
 */
public class Program {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var fahrenheit = TemperatureConverter.readValidFahrenheitValue(input);

        var decimalFormatter = new DecimalFormat("#.##");
        var stringBuilder = new StringBuilder("\n");
        stringBuilder.append("Fahrenheit\tCelsius\n");

        for (var i = 0; i < 20; i++) {
            var operator = (i * 10) + fahrenheit;
            var celsius = TemperatureConverter.convertFahrenheitToCelsius(operator);
            stringBuilder.append(operator + "\t" + decimalFormatter.format(celsius) + "\n");
        }

        System.out.println(stringBuilder);
    }

}

/** TemperatureConverter class
 * @author Christian Oleson
 * @version 1.0
 * @see Program
 */
class TemperatureConverter {
    /** Converts a temperature in Fahrenheit to Celsius
     * @param fahrenheit integer value of temperature in Fahrenheit
     * @return temperature in Celsius as a double
     */
    public static double convertFahrenheitToCelsius(int fahrenheit) {
        return (fahrenheit - 32d) * 5d / 9d;
    }

    /** Reads a valid Fahrenheit value from the user
     * @param input Scanner object
     * @return valid Fahrenheit value
     */
    public static int readValidFahrenheitValue(Scanner input) {
        System.out.println("Enter the temperature in Fahrenheit. Temperatures should be integers in the range from -459 to 212 degrees: ");
        var fahrenheit = input.nextInt();
        while(fahrenheit < -459 || fahrenheit > 212) {
            System.out.println("Invalid temperature. Enter the temperature in Fahrenheit. Temperatures should range from -459 to 212 degrees: ");
            fahrenheit = input.nextInt();
        }

        return fahrenheit;
    }
}