package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTests {

    @Test
    public void newGame_hasDefaultValues() {
        // Arrange & Act
        var game = new Game();

        // Assert
        assertFalse(game.isFinished());
        assertFalse(game.isQuitting());
        assertEquals(0, game.getNumberOfAttempts());
        assertEquals(0, game.getNumberOfHints());
    }

    @Test
    public void setFinished_updatesFinishedState() {
        // Arrange
        var game = new Game();

        // Act
        game.setFinished(true);

        // Assert
        assertTrue(game.isFinished());
    }

    @Test
    public void setQuitting_updatesQuittingState() {
        // Arrange
        var game = new Game();

        // Act
        game.setQuitting(true);

        // Assert
        assertTrue(game.isQuitting());
    }

    @Test
    public void incrementAttempts_incrementsByOne() {
        // Arrange
        var game = new Game();

        // Act
        game.incrementAttempts();
        game.incrementAttempts();
        game.incrementAttempts();

        // Assert
        assertEquals(3, game.getNumberOfAttempts());
    }

    @Test
    public void setNumberOfAttempts_overridesCurrentValue() {
        // Arrange
        var game = new Game();
        game.incrementAttempts();
        game.incrementAttempts();

        // Act
        game.setNumberOfAttempts(0);

        // Assert
        assertEquals(0, game.getNumberOfAttempts());
    }

    @Test
    public void setNumberOfHints_updatesHintCount() {
        // Arrange
        var game = new Game();

        // Act
        game.setNumberOfHints(5);

        // Assert
        assertEquals(5, game.getNumberOfHints());
    }
}
