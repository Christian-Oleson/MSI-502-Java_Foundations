//*********************************************************************************************************************
// Coutdown.java    Java Foundations
//
// Demonstrates the difference between print and println.
//*********************************************************************************************************************
/**
 Christian Oleson
 MSI-503
 Assignment 1
 **/
public class Countdown {
    //-----------------------------------------------------------------------------------------------------------------
    // Prints two lines of output representing a rocket countdown
    //-----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.print("Three...");
        System.out.print("Two...");
        System.out.print("One...");
        System.out.print("Zero...");

        System.out.println("Liftoff!");

        System.out.println("Houston, we have a problem!");

        // I'm doing a print here with a newline character because the assignment says
        // "insert three additional print statements with any message you prefer."
        // But if I don't add a return, it's rather hard to read. So ¯\_(ツ)_/¯
        System.out.print("println(\"This is how you would print a line in Kotlin\")\n");
        System.out.print("print(\"And this is how you just print in Kotlin\")\n");
        System.out.print("Console.WriteLine(\"\"This is how you would print a line in C#\"\")\n");
    }
}
