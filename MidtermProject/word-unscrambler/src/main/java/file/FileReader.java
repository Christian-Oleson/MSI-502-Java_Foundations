package file;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Christian Oleson
 * @version 1.0
 * A basic FileReader that implements the Reader interface.
 */
@Singleton
public class FileReader implements Reader {

    @Inject
    private Writer writer;

    public Boolean exists(String name) {
        var file = new File(name);
        var exists = file.exists();

        if (exists) {
            System.out.println("File exists. Reading...");
        } else {
            System.out.println("File does not exist. Please enter a valid file ");
        }

        return exists;
    }

    public ArrayList<String> readToEnd(String name) {
        var wordList = new ArrayList<String>();
        try {
            var inputFile = new File(name);
            var scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();

                if (line.length() >= 5) {
                    wordList.add(line.toLowerCase());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }

        return wordList;
    }

    public String getValidInput() {
        var file = "";
        var exists = false;
        var scanner = new Scanner(System.in);

        while (!exists) {
            writer.write("Enter a file name location, press E for the default, or press Q to quit");

            if (file.equalsIgnoreCase("Q")) {
                writer.write("Quitting the application...");
                return "";
            } else if (file.equalsIgnoreCase("E")) {
                file = "C:\\words.txt";
            } else {
                file = scanner.next();
            }

            exists = exists(file);
        }

        return file;
    }
}
