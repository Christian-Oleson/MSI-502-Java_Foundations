package FinalAssignment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameRecordTests {
    private final NameRecord _sut;

    public NameRecordTests() {
        String testNameRecordLine = "Christian 297 434 603 617 621 392 253 117 90 33 22";
        _sut = new NameRecord(testNameRecordLine);
    }

    @Test
    void NameRecord_WhenInstantiated_ReturnsExpectedName() {
        // Arrange
        var expectedName = "Christian";

        // Act
        var result = _sut.getName();

        // Assert
        assertEquals(result, expectedName.toLowerCase());
    }

    @Test
    void BestYear_ReturnsExpectedBestYear() {
        // Arrange
        var expectedBestYear = 2000;

        // Act
        var result = _sut.bestYear();

        // Assert
        assertEquals(expectedBestYear, result);
    }

    @Test
    void BestRank_ReturnsExpectedBestRank() {
        // Arrange
        var expectedBestRank = 22;

        // Act
        var result = _sut.getBestRank();

        // Assert
        assertEquals(expectedBestRank, result);
    }

    @Test
    void BestRankYear_ReturnsExpectedBestRankYear() {
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
    void GetRank_ReturnsExpectedRankForProvidedDecade(int decade, int expectedRank) {
        // Act
        var result = _sut.getRank(decade);

        // Assert
        assertEquals(expectedRank, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Christel 0 0 0 0 0 0 0 943 0 0 0",
            "Christen 0 0 0 0 0 0 0 780 471 728 0",
            "Christene 0 0 895 768 0 0 0 0 0 0 0",
            "Christi 0 0 0 0 0 687 450 307 535 0 0",
            "Christian 297 434 603 617 621 392 253 117 90 33 22",
            "Christiana 0 0 0 0 0 0 0 0 0 739 789",
            "Christie 0 0 0 0 751 456 371 161 251 631 0",
            "Christin 0 0 0 0 0 0 0 954 414 825 0",
            "Christina 278 323 349 400 256 181 75 16 19 36 73",
            "Christine 137 124 124 129 55 30 27 22 48 101 218",
            "Christop 0 0 0 0 0 0 0 0 948 0 0",
            "Christoper 0 0 0 0 0 0 0 881 901 0 0",
            "Christopher 333 349 385 367 155 49 20 2 2 2 5",
            "Christy 0 0 0 0 761 314 222 71 149 444 670",
            "Chrystal 0 0 0 0 0 0 868 477 393 0 0",
            "Chuck 0 0 0 846 441 378 306 635 0 0 0"
    })
    void Plot_JustDoesntBlowUp(String input) {
        // I have no clue how to test this one, so just don't explode
        // Arrange
        var sut = new NameRecord(input);

        // Act
        sut.plot();
    }
}
