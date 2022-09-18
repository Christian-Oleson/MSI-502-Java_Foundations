package FinalAssignment;

public class BestRankYear {
    private final int _bestRank;
    private final int _bestRankYear;

    public BestRankYear(int bestRankYear, int bestRank) {
        _bestRank = bestRank;
        _bestRankYear = bestRankYear;
    }

    public int getBestRank() {
        return _bestRank;
    }

    public int getBestYear() {
        return _bestRankYear;
    }
}
