package OlesonChristian_TestCheckup;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "OlesonChristian_TestCheckup", description = "...",
        mixinStandardHelpOptions = true)
public class TestCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        OlesonChristian_TestCheckup.main(args);
        PicocliRunner.run(TestCommand.class, args);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
