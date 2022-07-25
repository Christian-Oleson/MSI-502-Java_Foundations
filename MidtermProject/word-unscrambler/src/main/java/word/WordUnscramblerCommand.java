package word;

import file.Reader;
import file.Writer;
import io.micronaut.configuration.picocli.PicocliRunner;
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

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(WordUnscramblerCommand.class, args);
    }

    public void run() {
        file = reader.getValidInput();

        if (file.length() == 0) {
            return;
        }

        var scrambledWord = word.getValidRandomizedWord(file);
        word.unscrambleWord(scrambledWord);
    }
}
