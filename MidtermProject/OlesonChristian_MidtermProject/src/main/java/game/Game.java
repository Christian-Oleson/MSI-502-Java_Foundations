package game;


/**
 * @author Christian Oleson
 * @version 1.0
 * A game object that contains basic state of the game
 */
public class Game {
    private boolean finished = false;
    private boolean quitting = false;
    private int numberOfAttempts = 0;
    private int numberOfHints = 0;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isQuitting() {
        return quitting;
    }

    public void setQuitting(boolean quitting) {
        this.quitting = quitting;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public void incrementAttempts() {
        this.numberOfAttempts++;
    }

    public int getNumberOfHints() {
        return numberOfHints;
    }

    public void setNumberOfHints(int numberOfHints) {
        this.numberOfHints = numberOfHints;
    }
}
