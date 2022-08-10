package OlesonChristian_Assignment4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OlesonChristian_Assignment4CommandTest {
    private final OlesonChristian_Assignment4Command _sut;


    public OlesonChristian_Assignment4CommandTest() {
        _sut = new OlesonChristian_Assignment4Command();
    }

    @Test
    public void calculateMean_shouldReturnMean() {
        // Arrange
        float[] numbers = { 1, 2, 3, 4, 5 };
        var expected = 3.00;

        // Act
        float mean = _sut.calculateMean(numbers);

        // Assert
        assertEquals(expected, mean);
    }

    @Test
    public void calculateStandardDeviation_shouldReturnStandardDeviation() {
        // Arrange
        float[] numbers = { 1, 2, 3, 4, 5 };
        var expected = 1.41;

        // Act
        float standardDeviation = _sut.calculateStandardDeviation(numbers, 3);

        // Assert
        assertEquals(expected, standardDeviation, 0.01);
    }
}
