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

@Command(name = "word-unscrambler", description = "...",
        mixinStandardHelpOptions = true)
public class WordUnscramblerCommand implements Runnable {

    @Option(names = {"-f", "--file"}, description = "...")
    String file;

    @Inject
    Word word;

    @Inject
    private Reader reader;

    @Inject
    private Writer writer;

    @Client("https://raw.githubusercontent.com/powerlanguage/word-lists/master/1000-most-common-words.txt")
    @Inject
    HttpClient httpClient;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(WordUnscramblerCommand.class, args);
    }

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
