package FinalAssignment;

import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


@Command(name = "FinalAssignment", description = "...",
        mixinStandardHelpOptions = true)
public class FinalAssignmentCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    @Inject
    NameSurfer nameSurfer;

    public static void main(String[] args) {
        PicocliRunner.run(FinalAssignmentCommand.class, args);
    }

    public void run() {
        try {
            nameSurfer.main();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
