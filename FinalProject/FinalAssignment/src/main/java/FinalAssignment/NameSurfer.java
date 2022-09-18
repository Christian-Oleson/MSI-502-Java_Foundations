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

    HashMap<String, NameRecord> _nameRecords;

    public void main() {
        showOptions();
    }

    private void showOptions() {
        var sb = new StringBuilder();
        sb.append("1 - Find the best year for a name\n");
        sb.append("2 - Find the best rank for a name\n");
        sb.append("3 - Plot the popularity of a name\n");
        sb.append("4 - Clear the plot\n");
        sb.append("5 - Quit\n");
        sb.append("Enter your selection.");
        System.out.println(sb);
        var nameDataArray = requestData();
        _nameRecords = convertStringArrayToNameRecords(nameDataArray);
        var parsedInt = 0;

        while (parsedInt == 0) {
            parsedInt = tryParseInteger();
        }

        runSelection(parsedInt);
    }

    private Integer tryParseInteger() {
        var scanner = new Scanner(System.in);
        var input = scanner.next();
        var parsedInt = 0;
        try {
            parsedInt = Integer.parseInt(input.toString());
        } catch (Exception e) {
            System.out.println("Not a valid selection. Please input an integer");
        }

        return parsedInt;
    }

    private String[] requestData() {
        var httpRequest = HttpRequest
                .create(HttpMethod.GET, "https://owd.tcnj.edu/~papamicd/name_data.txt")
                .accept("text/plain");

        return _httpClient
                .toBlocking()
                .retrieve(httpRequest)
                .split("\n");
    }

    private HashMap<String, NameRecord> convertStringArrayToNameRecords(String[] nameRecordStringArray) {
        var nameHashMap = new HashMap<String, NameRecord>();

        for (var res = Arrays.stream(nameRecordStringArray).iterator(); res.hasNext();) {
            var nameRecord = new NameRecord(res.next());

            var name = nameRecord.getName();
            nameHashMap.put(name.toLowerCase(), nameRecord);
        }

        return nameHashMap;
    }

    private void runSelection(int input) {
        var name = "";
        switch (input) {
            case 1:
                name = getNameFromUser();
                var bestDecade = _nameRecords.get(name.toLowerCase()).bestDecade();
                System.out.println("The best year for " + name + " was the year " + bestDecade);
                break;
            case 2:
                name = getNameFromUser();
                var bestRank = _nameRecords.get(name.toLowerCase()).getBestRank();
                System.out.println("The best rank for the name " + name + " was " + bestRank._bestRank + " in the year of " + bestRank._bestRankYear);
                break;
            case 3:
                name = getNameFromUser();
                break;
            case 4:
                StdDraw.clear();
                break;
            case 5:
                break;
            default:
                showOptions();
        }
    }

    private String getNameFromUser() {
        System.out.println("Enter the name you want data on:");
        var scanner = new Scanner(System.in);
        return scanner.next();
    }
}
