package OlesonChristian_FinalProject;

/**
 * @author Christian Oleson
 * The BestRankYear DTO
 */
public class BestRankYear {
    private final int _bestRank;
    private final int _bestRankYear;

    public BestRankYear(int bestRankYear, int bestRank) {
        _bestRank = bestRank;
        _bestRankYear = bestRankYear;
    }

    /**
     * Gets the best rank from the DTO
     * @return int best rank
     */
    public int getBestRank() {
        return _bestRank;
    }

    /**
     * Gets the best rank year from the DTO
     * @return int best rank year
     */
    public int getBestYear() {
        return _bestRankYear;
    }
}
