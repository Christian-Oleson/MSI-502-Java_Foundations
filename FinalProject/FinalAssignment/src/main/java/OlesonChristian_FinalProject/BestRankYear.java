package OlesonChristian_FinalProject;

/**
 * @author Christian Oleson
 * The BestRankYear DTO
 */
public record BestRankYear(int bestRankYear, int bestRank) {

    /**
     * Gets the best rank from the DTO
     * @return int best rank
     */
    public int getBestRank() {
        return bestRank;
    }

    /**
     * Gets the best rank year from the DTO
     * @return int best rank year
     */
    public int getBestYear() {
        return bestRankYear;
    }
}
