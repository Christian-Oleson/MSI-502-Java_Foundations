package OlesonChristian_FinalProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestRankYearTests {

    @Test
    public void record_accessors_returnConstructorValues() {
        // Arrange & Act
        var bestRankYear = new BestRankYear(1990, 5);

        // Assert
        assertEquals(1990, bestRankYear.bestRankYear());
        assertEquals(5, bestRankYear.bestRank());
    }

    @Test
    public void getBestYear_returnsBestRankYear() {
        // Arrange
        var bestRankYear = new BestRankYear(2000, 22);

        // Act
        var result = bestRankYear.getBestYear();

        // Assert
        assertEquals(2000, result);
    }

    @Test
    public void getBestRank_returnsBestRank() {
        // Arrange
        var bestRankYear = new BestRankYear(2000, 22);

        // Act
        var result = bestRankYear.getBestRank();

        // Assert
        assertEquals(22, result);
    }

    @Test
    public void equals_twoRecordsWithSameValues_areEqual() {
        // Arrange
        var a = new BestRankYear(1950, 10);
        var b = new BestRankYear(1950, 10);

        // Assert
        assertEquals(a, b);
    }

    @Test
    public void hashCode_twoRecordsWithSameValues_haveSameHashCode() {
        // Arrange
        var a = new BestRankYear(1950, 10);
        var b = new BestRankYear(1950, 10);

        // Assert
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void toString_containsFieldValues() {
        // Arrange
        var bestRankYear = new BestRankYear(1970, 33);

        // Act
        var result = bestRankYear.toString();

        // Assert
        assertEquals(true, result.contains("1970"));
        assertEquals(true, result.contains("33"));
    }
}
