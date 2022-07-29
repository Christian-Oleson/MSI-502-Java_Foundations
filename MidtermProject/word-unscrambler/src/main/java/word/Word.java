package word;

import file.Reader;
import file.Writer;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

@Singleton
public class Word {
    @Inject
    private Reader reader;

    @Inject
    private Writer writer;

    @CommandLine.Option(names = {"--wordLength"}, description = "...")
    int wordLength = 5;

    public WordDto getValidRandomizedWord(String file) {
        var fileContents = reader.readToEnd(file);
        var wordArray = getStrings(fileContents, wordLength);
        return getScrambledWord(wordArray);
    }

    public WordDto getScrambledWord(String[] words) {
        var word = getRandomWord(words);
        var scrambledWord = scrambleWord(word);

        return new WordDto(word, scrambledWord);
    }

    public String[] getStrings(ArrayList<String> words, int wordLength) {
        return words
                .stream()
                .filter(word -> word.length() >= wordLength)
                .toArray(String[]::new);
    }

    public void unscrambleWord(WordDto wordDto) {

        var scanner = new Scanner(System.in);
        var finished = false;
        writer.write(wordDto.scrambledWord);

        do {
            writer.write("Enter 1 to swap a pair of letters.");
            writer.write("Enter 2 to solve.");
            writer.write("Enter 3 to quit.");
            var choice = scanner.nextLine();
            try {
                var intChoice = Integer.parseInt(choice);
                switch (intChoice) {
                    case 1:
                        wordDto = swapLetters(wordDto, scanner);
                        break;
                    case 2:
                        validateIfEqual(wordDto, scanner);
                        finished = true;
                        break;
                    case 3:
                        finished = true;
                        writer.write("You chose to quit. The word was too difficult for you!");
                        writer.write("The word was: " + wordDto.word);
                        break;
                }
            } catch (Exception e) {
                writer.write(e.toString());
                writer.write("Invalid choice. Please enter a valid integer.");
            }
        } while (!finished);
    }

    private String scrambleWord(String word) {
        var wordLength = word.length();
        var chars = word.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        var stringBuilder = new StringBuilder();

        while (!chars.isEmpty()) {
            var randomIndex = (int) (Math.random() * wordLength);

            if (chars.size() > randomIndex) {
                var character = chars.get(randomIndex);
                stringBuilder.append(character);
                chars.remove(character);
            }
        }

        return stringBuilder.toString();
    }

    private String getRandomWord(String[] words) {
        var randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }

    private WordDto swapLetters(WordDto wordDto, Scanner scanner) {
        var scrambledWord = wordDto.getScrambledWord();

        printPossibleInputOptions(scrambledWord);
        var finished = false;

        do {
            var pair = scanner.nextLine();
            if (pair.length() >= 2) {
                var pairs = pair.split(" ");
                var firstItemInt = Integer.parseInt(pairs[0]);
                var lastItemInt = Integer.parseInt(pairs[1]);
                var firstItemChar = scrambledWord.charAt(firstItemInt);
                var lastItemChar = scrambledWord.charAt(lastItemInt);

                var charArray = scrambledWord.toCharArray();
                charArray[firstItemInt] = lastItemChar;
                charArray[lastItemInt] = firstItemChar;

                 wordDto.setScrambledWord(String.valueOf(charArray));
            } else {
                writer.write("Invalid pair. Please enter a valid pair. Ex: 1 2");
            }
        } while (finished);

        return wordDto;
    }

    private void printPossibleInputOptions(String scrambledWord) {
        var scrambledWordLength = scrambledWord.length();
        var intStringBuilder = new StringBuilder();
        var charStringBuilder = new StringBuilder();

        for (int i = 0; i < scrambledWordLength; i++) {
            intStringBuilder.append(i + " ");
            charStringBuilder.append(scrambledWord.charAt(i) + " ");
        }

        writer.write(intStringBuilder.toString());
        writer.write(charStringBuilder.toString());
    }

    private boolean validateIfEqual(WordDto wordDto, Scanner scanner) {
        writer.write("Enter the word you think this is: ");
        var unscrambledWord = scanner.nextLine();
        var word = wordDto.getWord();
        var wordsAreEqual = unscrambledWord.equalsIgnoreCase(word);

        if (wordsAreEqual) {
            writer.write("You solved the word!");
        } else {
            writer.write("You didn't solve the word!");
        }

        return wordsAreEqual;
    }
}
