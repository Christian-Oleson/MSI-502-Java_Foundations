package word;

/**
 * @author Christian Oleson
 * @version 1.0
 * A DTO for words, including methods to get and set attributes.
 */
public class WordDto {
    public String word;
    public String scrambledWord;

    public WordDto(String word, String unscrambledWord) {
        this.word = word;
        this.scrambledWord = unscrambledWord;
    }

    public String getWord() {
        return word;
    }

    public String getScrambledWord() {
        return scrambledWord;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setScrambledWord(String scrambledWord) {
        this.scrambledWord = scrambledWord;
    }
}
