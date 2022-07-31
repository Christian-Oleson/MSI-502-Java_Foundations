package word;

import file.Reader;
import file.Writer;
import game.Game;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/** Christian Oleson
 * MSI-503
 * Assignment 3
 * @author Christian Oleson
 * @version 1.0
 * The main class that runs the game. This class is the entry point for the application.
 * I used Micronaut to create the application, which has built in Dependency Injection.
 * Likewise, I used Picocli to create the command line interface. This has some nice abilities to read different CLI args.
 */
@Command(name = "word-unscrambler", description = "...",
        mixinStandardHelpOptions = true)
public class OlesonChristian_unscrambler implements Runnable {

    /**
     * If someone passes one of the names below, then the application will read that file
     */
    @Option(names = {"-f", "--file"}, description = "...")
    String file;

    /**
     * Injection of the Word class.
     */
    @Inject
    Word word;

    /**
     * Injection of the reader class
     */
    @Inject
    private Reader reader;

    /**
     * Injection of the writer class
     */
    @Inject
    private Writer writer;

    /**
     * Injection of an HTTP Client. If the user does not pass in a word.txt file, I instead read this from a REST API.
     * Note, this could be any endpoint that returns a list of word, where there is one word per line, with the typical
     * line ending of \n. In particular, I used an online list found via github. There are many other options, but this
     * is the one I used.
     */
    @Client("https://raw.githubusercontent.com/powerlanguage/word-lists/master/1000-most-common-words.txt")
    @Inject
    HttpClient httpClient;

    /**
     * The micronaut entrypoint of any CLI application
     */
    public static void main(String[] args) {
        PicocliRunner.run(OlesonChristian_unscrambler.class, args);
    }

    /**
     * The micronaut run method. This is the secondary entry point for the application. Here I left the business logic
     * to determine if the user passed in a file or not. If they did, I read the file and use it. If they did not, I read
     * the words from the github API. I then run the game. The user chooses to play or quit. If the user chooses to play,
     * I ask the user to unscramble the word. The user can choose to move a letter at a time, solve the entire word,
     * quit, get a hint, or get a new word entirely.
     */
    public void run() {
        WordDto scrambledWord;
        var results = new String[0];
        if (file != null) {
            file = reader.getValidInput();
            scrambledWord = word.getValidRandomizedWord(file);
        } else {
            var httpRequest = HttpRequest
                    .create(HttpMethod.GET, "https://raw.githubusercontent.com/powerlanguage/word-lists/master/1000-most-common-words.txt")
                    .accept("text/plain");

            results = httpClient.toBlocking().retrieve(httpRequest).split("\n");
            scrambledWord = word.getScrambledWord(results);
        }

        var game = new Game();

        do {
            writer.write("Starting a new game...");
            game = word.unscrambleWord(scrambledWord);

            if (game.finished) {
                scrambledWord = word.getScrambledWord(results);
            }
        } while (!game.quitting);
    }
}
