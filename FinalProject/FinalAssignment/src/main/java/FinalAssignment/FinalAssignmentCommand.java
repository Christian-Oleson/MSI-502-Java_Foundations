package FinalAssignment;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import jdk.jfr.Name;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.Arrays;
import java.util.HashMap;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Command(name = "FinalAssignment", description = "...",
        mixinStandardHelpOptions = true)
public class FinalAssignmentCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    /**
     * Injection of an HTTP Client
     */
    @Client("https://owd.tcnj.edu/~papamicd/name_data.txt")
    @Inject
    HttpClient httpClient;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(FinalAssignmentCommand.class, args);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }

        var httpRequest = HttpRequest
                .create(HttpMethod.GET, "https://owd.tcnj.edu/~papamicd/name_data.txt")
                .accept("text/plain");

        var results = httpClient
                .toBlocking()
                .retrieve(httpRequest)
                .split("\n");

        var nameHashMap = new HashMap<String, NameRecord>();

        for (var res = Arrays.stream(results).iterator(); res.hasNext();) {
            var nameRecord = new NameRecord(res.next());

            var name = nameRecord.getName();
            nameHashMap.put(name, nameRecord);
        }

        nameHashMap.toString();
    }
}
