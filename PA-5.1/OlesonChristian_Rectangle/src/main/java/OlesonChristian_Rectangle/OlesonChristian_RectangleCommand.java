package OlesonChristian_Rectangle;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;

/** Christian Oleson
 * MSI-503
 * Assignment 5.1
 */
@Command(name = "OlesonChristian_Rectangle", description = "...",
        mixinStandardHelpOptions = true)
public class OlesonChristian_RectangleCommand implements Runnable {

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(OlesonChristian_RectangleCommand.class, args);
    }

    public void run() {
        var demo = new Demo();
        demo.main(new String[0]);
    }
}
