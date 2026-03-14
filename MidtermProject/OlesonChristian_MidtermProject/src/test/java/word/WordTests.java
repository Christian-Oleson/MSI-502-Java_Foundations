package word;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordTests {

    @Test
    public void getStrings_filtersWordsShorterThanMinLength() {
        // Arrange
        var word = new Word();
        var words = List.of("hi", "cat", "hello", "world", "programming");

        // Act
        var result = word.getStrings(words, 5);

        // Assert
        assertEquals(3, result.length);
        assertArrayEquals(new String[]{"hello", "world", "programming"}, result);
    }

    @Test
    public void getStrings_withEmptyList_returnsEmptyArray() {
        // Arrange
        var word = new Word();
        List<String> words = new ArrayList<>();

        // Act
        var result = word.getStrings(words, 5);

        // Assert
        assertEquals(0, result.length);
    }

    @Test
    public void getStrings_withAllWordsLongEnough_returnsAll() {
        // Arrange
        var word = new Word();
        var words = List.of("apple", "banana", "cherry");

        // Act
        var result = word.getStrings(words, 5);

        // Assert
        assertEquals(3, result.length);
    }

    @Test
    public void getStrings_withMinLengthOne_returnsAllWords() {
        // Arrange
        var word = new Word();
        var words = List.of("a", "bb", "ccc");

        // Act
        var result = word.getStrings(words, 1);

        // Assert
        assertEquals(3, result.length);
    }

    @Test
    public void getScrambledWord_returnsWordDtoWithSameLetters() {
        // Arrange
        var word = new Word();
        var words = new String[]{"programming"};

        // Act
        var result = word.getScrambledWord(words);

        // Assert
        assertNotNull(result);
        assertEquals("programming", result.getWord());
        assertNotNull(result.getScrambledWord());
        assertEquals(result.getWord().length(), result.getScrambledWord().length());

        // Verify scrambled word has the same characters
        var originalSorted = result.getWord().chars().sorted().toArray();
        var scrambledSorted = result.getScrambledWord().chars().sorted().toArray();
        assertArrayEquals(originalSorted, scrambledSorted);
    }

    @Test
    public void getScrambledWord_filtersContractions() {
        // Arrange
        var word = new Word();
        var words = new String[]{"don't", "can't", "programming"};

        // Act
        var result = word.getScrambledWord(words);

        // Assert
        assertEquals("programming", result.getWord());
    }

    @Test
    public void wordDto_gettersReturnCorrectValues() {
        // Arrange
        var dto = new WordDto("hello", "olleh");

        // Assert
        assertEquals("hello", dto.getWord());
        assertEquals("olleh", dto.getScrambledWord());
    }

    @Test
    public void wordDto_setScrambledWord_updatesValue() {
        // Arrange
        var dto = new WordDto("hello", "olleh");

        // Act
        dto.setScrambledWord("lehlo");

        // Assert
        assertEquals("lehlo", dto.getScrambledWord());
    }
}
