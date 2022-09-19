package OlesonChristian_FinalProject;

import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;

/**
 * MSI-503 - Java Foundations - Final Assignment
 * @author Christian Oleson
 * This is the Picocli runner entrance for CLI application. This application is a baby name analyzer.
 * The user is given several options to analyze a specific name and either
 * 1. Find the best year for a given name
 * 2. Find the best rank for a given name
 * 3. Plot the rank for a name over 11 decades, starting with 1900
 * 4. Clear the plot
 * 5. Quit the application
 * The user must input an integer, otherwise they will be presented with a message indicating an issue (and to retry)
 * The name, if not found, will be logged as not found in the US Census data.
 */
@Command(name = "OlesonChristian_FinalProject", description = "...", mixinStandardHelpOptions = true)
public class OlesonChristian_FinalProject implements Runnable {

    /**
     * Injection of the NameSurfer class
     */
    @Inject
    NameSurfer nameSurfer;

    /**
     * Main method as typical entry
     * @param args
     */
    public static void main(String[] args) {
        PicocliRunner.run(OlesonChristian_FinalProject.class, args);
    }

    /**
     * Picocli entry
     */
    public void run() {
        nameSurfer.main();
    }
}
