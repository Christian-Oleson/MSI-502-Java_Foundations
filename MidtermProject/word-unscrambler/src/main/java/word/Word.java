package word;

import file.Reader;
import file.Writer;
import game.Game;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import picocli.CommandLine;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        words = Stream.of(words)
                .filter(str -> str.length() >= wordLength
                        && !str.contains("'"))
                .collect(Collectors.toSet())
                .toArray(new String[0]);
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

    private Game Valid(WordDto wordDto, Scanner scanner, Game game) {
        var valid = validateIfEqual(wordDto.word, wordDto.scrambledWord);
        return validMessage(valid, game);
    }

    private Game validMessage(Boolean valid, Game game) {
        if (valid) {
            game.finished = true;
            game.quitting = false;
            writer.write("Congratulations! You unscrambled the word project in " + game.numberOfAttempts + " steps." +
                    " You used " + game.numberOfHints + " hints.");
            game.numberOfAttempts = 0;
        } else {
            game.numberOfAttempts++;
        }

        return game;
    }

    public Game unscrambleWord(WordDto wordDto) {

        var scanner = new Scanner(System.in);
        var game = new Game();

        do {
            writer.write("You have used " + game.numberOfAttempts + " attempts with " + game.numberOfHints + " hints.");
            writer.write("The scrambled word now is: ");
            printPossibleInputOptions(wordDto.scrambledWord);
            writer.write("Enter 1 to swap a pair of letters.");
            writer.write("Enter 2 to solve.");
            writer.write("Enter 3 to quit.");
            writer.write("Enter 4 to get a hint.");
            writer.write("Enter 5 to get a new word.");
            writer.write("Enter your choice: ");
            var choice = scanner.nextLine();
            try {
                var intChoice = Integer.parseInt(choice);
                switch (intChoice) {
                    case 1:
                        wordDto = swapLetters(wordDto, scanner);
                        game = Valid(wordDto, scanner, game);
                        break;
                    case 2:
                        var isValid = validateIfEqual(wordDto, scanner);
                        validMessage(isValid, game);
                        break;
                    case 3:
                        game.finished = true;
                        game.quitting = true;
                        writer.write("You chose to quit. The word was too difficult for you!");
                        writer.write("The word was: " + wordDto.word + ".\n");
                        break;
                    case 4:
                        writer.write("Get a hint!");
                        game.numberOfHints = getAHint(wordDto, game.numberOfHints);
                        break;
                    case 5:
                        game.finished = true;
                        game.quitting = false;
                        writer.write("You chose to get a new word. The word was too difficult for you!");
                        writer.write("The word was: " + wordDto.word + ".\n");
                        break;
                }
            } catch (Exception e) {
                writer.write(e.toString());
                writer.write("Invalid choice. Please enter a valid integer.");
            }

            game.numberOfAttempts++;
        } while (!game.finished);

        return game;
    }

    private int getAHint(WordDto wordDto, int hints) {
        var hint = wordDto.getWord().charAt(hints);
        writer.write(hint + " is at position " + hints);
        return ++hints;
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
        return validateIfEqual(unscrambledWord, word);
    }

    private boolean validateIfEqual(String currentWord, String validWord) {

        var wordsAreEqual = currentWord.equalsIgnoreCase(validWord);

        if (wordsAreEqual) {
            writer.write("You solved the word!");
        } else {
            writer.write("You didn't solve the word!");
        }

        return wordsAreEqual;
    }
}
