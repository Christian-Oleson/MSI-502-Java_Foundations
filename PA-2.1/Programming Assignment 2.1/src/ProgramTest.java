import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {
    private final Program _sut;

    public ProgramTest() {
        _sut = new Program();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15})
    void calculateSquare_ReturnsExpectedValue(int input) {
        // Arrange
        var expected = input * input;

        // Act
        var result = _sut.calculateSquare(input);

        // Assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource(value = "numberOfUnitsPerSquare")
    void numberOfUnitsPerSquare_ReturnsExpectedValue(double[] doubleArray) {
        // Arrange
        var expected = (int)doubleArray[0] / doubleArray[1];

        // Act
        var result = _sut.numberOfKangaroosPerSquareKilometer((int)doubleArray[0], doubleArray[1]);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void expectedKangarooKills_ReturnsExpectedValue() {
        // Arrange
        var expected = 1.8;
        var sideOfSquare = 3.5;
        var roadsThroughSquare = 10;
        var numberOfKangaroos = 150;

        // Act
        var result = _sut.expectedKangarooKills(
                sideOfSquare, roadsThroughSquare, numberOfKangaroos);

        // Assert
        assertEquals(expected, result);
    }

    public static double[][] numberOfUnitsPerSquare() {
        return new double[][] { { 1.0 , 2.0 }, { 2.1, 4.3 }, { 121.99, 4.476 } };
    }
}