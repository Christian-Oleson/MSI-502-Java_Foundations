package FinalAssignment;

import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class NameSurfer {

    /**
     * Injection of an HTTP Client
     */
    @Client("https://owd.tcnj.edu/~papamicd/name_data.txt")
    @Inject
    HttpClient _httpClient;

    /**
     * A hash map of the name records, with the string key being the name and the NameRecord being the value
     * containing data of the name's rank over the decades.
     */
    private HashMap<String, NameRecord> _nameRecords;

    /**
     * The main method of the NameSurfer class, which requests input, displays output, and controls exiting
     * the program if the user requests.
     */
    public void main() {
        System.out.println(Messages.OPTIONS_FOR_USER);
        var nameDataArray = requestData();
        _nameRecords = convertStringArrayToNameRecords(nameDataArray);
        var parsedInt = 0;

        while (parsedInt == 0) {
            parsedInt = tryParseInteger();
        }

        runSelection(parsedInt);
    }

    /**
     * Don't trust a user to input what you need safely. Instead, let's make sure it is parseable and, if not
     * we want to display the problem to the user by returning the default integer (0).
     * @return
     */
    private Integer tryParseInteger() {
        var scanner = new Scanner(System.in);
        var input = scanner.next();
        var parsedInt = 0;
        try {
            parsedInt = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(Messages.INVALID_INPUT);
        }

        return parsedInt;
    }

    /**
     * Perhaps a bit unorthodox, but instead of shipping the name_data.txt with the program, we can just retrieve it
     * by using an HTTP client which is injected via DI. Then, in the future, if updated, we merely pull in the new data.
     * @return String[] array of strings from the name_data.txt file
     */
    private String[] requestData() {
        var httpRequest = HttpRequest
                .create(HttpMethod.GET, "https://owd.tcnj.edu/~papamicd/name_data.txt")
                .accept("text/plain");

        return _httpClient
                .toBlocking()
                .retrieve(httpRequest)
                .split("\n");
    }

    /**
     * Takes the string array of the name records found online and iterates over the array, producing a hash map of
     * names and their name records.
     * @param nameRecordStringArray
     * @return
     */
    private HashMap<String, NameRecord> convertStringArrayToNameRecords(String[] nameRecordStringArray) {
        var nameHashMap = new HashMap<String, NameRecord>();

        for (var res = Arrays.stream(nameRecordStringArray).iterator(); res.hasNext();) {
            var nameRecord = new NameRecord(res.next());

            var name = nameRecord.getName();
            nameHashMap.put(name.toLowerCase(), nameRecord);
        }

        return nameHashMap;
    }

    /**
     * Runs the selection the user input, such as getting the best rank of a name for a user.
     * @param input integer value, 1-5. If not valid or outside the scope, we recursively run this again.
     */
    private void runSelection(int input) {
        var name = "";
        var runAgain = true;
        try {
            switch (input) {
                case 1:
                    name = getNameFromUser();
                    var bestDecade = _nameRecords.get(name.toLowerCase()).bestDecade();
                    System.out.println("The best year for " + name + " was the year " + bestDecade);
                    main();
                    break;
                case 2:
                    name = getNameFromUser();
                    var bestRank = _nameRecords.get(name.toLowerCase()).getBestRank();
                    System.out.println("The best rank for the name " + name + " was " + bestRank.getBestRank() + " in the year of " + bestRank.getBestYear());
                    main();
                    break;
                case 3:
                    name = getNameFromUser();
                    _nameRecords.get(name.toLowerCase()).plot();
                    main();
                    break;
                case 4:
                    StdDraw.clear();
                    main();
                    break;
                case 5:
                    runAgain = false;
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (runAgain) {
                main();
            }
        }
    }

    /**
     * Prompts the user to input a string name to get data for, and then returns the data
     * @return String the name of the user
     */
    private String getNameFromUser() {
        System.out.println(Messages.NAME_PROMPT);
        var scanner = new Scanner(System.in);
        return scanner.next();
    }
}
