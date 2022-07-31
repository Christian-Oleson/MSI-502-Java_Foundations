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

/**
 * @author Christian Oleson
 * @version 1.0
 * The majority of the business logic. This could be refactored, but ultimately it's not worth it right now.
 * This class runs the game, which is unscrambling words.
 */
@Singleton
public class Word {
    /**
     * Injected reader
     */
    @Inject
    private Reader reader;

    /**
     * Injected writer
     */
    @Inject
    private Writer writer;

    /**
     * If someone passes one of the names below, then the application will only read words of that size or greater
     */
    @CommandLine.Option(names = {"--wordLength", "-w"}, description = "...")
    int wordLength = 5;


    /**
     * This method reads the string path of a word file and returns a random word from that file.
     * @param file The path to the word file.
     * @return WordDto a word DTO which includes the correct word and the scrambled word.
     */
    public WordDto getValidRandomizedWord(String file) {
        var fileContents = reader.readToEnd(file);
        var wordArray = getStrings(fileContents, wordLength);
        return getScrambledWord(wordArray);
    }

    /**
     * This method takes an array of words and returns a random word DTO with a scrambled word from that array.
     * Here, we also filter out words that do not meet the word length or contractions
     * @param words An array of words to choose from
     * @return WordDto a word DTO which includes the correct word and the scrambled word.
     */
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

    /**
     * Takes in an array list of string, which is a list of words, and an Array of string
     * @param words An array of words to choose from
     * @param wordLength The length of the words must be greater than or equal to this value
     * @return String[] all valid words in the form of a string array
     */
    public String[] getStrings(ArrayList<String> words, int wordLength) {
        return words
                .stream()
                .filter(word -> word.length() >= wordLength)
                .toArray(String[]::new);
    }

    /**
     * Validates if the word dto is now correct. If it is, it updates the game to be in a finished state and
     * prints a congratulatory message.
     * @param wordDto
     * @param scanner
     * @param game
     * @return Game the game object, updated to be in a finished state.
     */
    private Game Valid(WordDto wordDto, Scanner scanner, Game game) {
        var valid = validateIfEqual(wordDto.word, wordDto.scrambledWord);
        return validMessage(valid, game);
    }

    /**
     * Validates if the game is in a correct state and finished. If so, we congratulate the user and end the game.
     * Otherwise, we increment the number of attempts and ask the user to try again.
     * @param valid
     * @param game
     * @return
     */
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

    /**
     * This is the core of the game. We give the user options, we show them their current state, and we ask them to
     * make a choice of what to do next.
     * @param wordDto
     * @return Game the game object, updated to be in a finished state.
     */
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

    /**
     * We allow the user to get a hint starting with the first letter of the word, then moving right on the word
     * @param wordDto
     * @param hints
     * @return int the number of hints used
     */
    private int getAHint(WordDto wordDto, int hints) {
        var hint = wordDto.getWord().charAt(hints);
        writer.write(hint + " is at position " + hints);
        return ++hints;
    }

    /**
     * This method just scrambles a string randomly. Nobody can really guess what the output will be.
     * @param word
     * @return
     */
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

    /**
     * Takes a list of possible words and scrambles on, then returns that one word.
     * @param words
     * @return String the word that was chosen
     */
    private String getRandomWord(String[] words) {
        var randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }

    /**
     * This is where the user interacts with the game to swap letters in the scrambled word. We ask the user to
     * enter the position of the letter they want to swap, and then we ask them to enter the letter they want to swap
     * it with (the letter at the position they entered).
     * @param wordDto
     * @param scanner
     * @return
     */
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

    /**
     * We end up printing the possible letters and their indices several times, so we make a method to do that.
     * @param scrambledWord
     */
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

    /**
     * Here we ask the user to input their guess should they believe they know the answer
     * @param wordDto
     * @param scanner
     * @return  boolean true if the guess is correct, false if it is not
     */
    private boolean validateIfEqual(WordDto wordDto, Scanner scanner) {
        writer.write("Enter the word you think this is: ");
        var unscrambledWord = scanner.nextLine();
        var word = wordDto.getWord();
        return validateIfEqual(unscrambledWord, word);
    }

    /**
     * Core validation logic of one string against another. If they are the same, we get a nice message. If not,
     * we get a bad message.
     * @param currentWord
     * @param validWord
     * @return boolean true if the guess is correct, false if it is not
     */
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
