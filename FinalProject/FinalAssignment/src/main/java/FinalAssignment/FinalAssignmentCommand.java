package FinalAssignment;

import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;

@Command(name = "FinalAssignment", description = "...",
        mixinStandardHelpOptions = true)
public class FinalAssignmentCommand implements Runnable {

    @Inject
    NameSurfer nameSurfer;

    public static void main(String[] args) {
        PicocliRunner.run(FinalAssignmentCommand.class, args);
    }

    public void run() {
        nameSurfer.main();
    }
}
