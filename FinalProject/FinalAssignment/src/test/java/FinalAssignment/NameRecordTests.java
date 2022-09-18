package FinalAssignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameRecordTests {
    private final String TestNameRecordLine = "Christian 297 434 603 617 621 392 253 117 90 33 22";
    private final NameRecord _sut;

    public NameRecordTests() {
        _sut = new NameRecord(TestNameRecordLine);
    }

    @Test
    public void NameRecord_WhenInstantiated_ReturnsExpectedName() {
        // Arrange
        var expectedName = "Christian";

        // Act
        var result = _sut.getName();

        // Assert
        assertTrue(result.equals(expectedName.toLowerCase()));
    }

    @Test
    public void BestYear_ReturnsExpectedBestYear() {
        // Arrange
        var expectedBestYear = 2000;

        // Act
        var result = _sut.bestYear();

        // Assert
        assertEquals(expectedBestYear, result);
    }

    @Test
    public void BestRank_ReturnsExpectedBestRank() {
        // Arrange
        var expectedBestRank = 22;

        // Act
        var result = _sut.getBestRank();

        // Assert
        assertEquals(expectedBestRank, result);
    }

    @Test
    public void BestRankYear_ReturnsExpectedBestRankYear() {
        // Arrange
        var expectedBestYear = 2000;
        var expectedBestRank = 22;

        // Act
        var result = _sut.getBestRankYear();

        // Assert
        assertEquals(expectedBestYear, result.getBestYear());
        assertEquals(expectedBestRank, result.getBestRank());
    }

    @ParameterizedTest
    @CsvSource({"0,297", "1,434", "2,603", "3,617", "4,621", "5,392", "6,253", "7,117", "8,90", "9,33", "10,22"})
    public void GetRank_ReturnsExpectedRankForProvidedDecade(int decade, int expectedRank) {
        // Act
        var result = _sut.getRank(decade);

        // Assert
        assertEquals(expectedRank, result);
    }
}
