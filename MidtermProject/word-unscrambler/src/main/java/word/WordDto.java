package word;

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
