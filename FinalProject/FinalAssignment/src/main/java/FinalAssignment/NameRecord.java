package FinalAssignment;

import java.util.HashMap;
import java.util.Map;

public class NameRecord {
    private String _name;
    private String _nameRecordString;
    private HashMap<Integer, Integer> _nameRecordHashMap;
    private final int START = 1900;
    private final int DECADES = 11;

    public NameRecord(String nameRecordString) {
        _nameRecordString = nameRecordString;
        _nameRecordHashMap = new HashMap<>();
        splitInput(_nameRecordString);
    }

    /**
     * Gets the name of the current record
     * @return String name
     */
    public String getName() {
        return _name;
    }

    /**
     * Gets the rank of the name for the decade provided
     * @param decade
     * @return int rank of the decade provided
     */
    public int getRank(int decade) {
        return _nameRecordHashMap.get(decade);
    }

    public BestRankYear getBestRank() {
        var best = best();

        return new BestRankYear(best.getKey(), best.getValue());
    }

    public class BestRankYear {
        public int _bestRank;
        public int _bestRankYear;

        private BestRankYear(int bestRank, int bestRankYear) {
            _bestRank = bestRank;
            _bestRankYear = bestRankYear;
        }
    }

    /**
     * Gets a hash map of the name record
     * @return HashMap<Integer, Integer>
     */
    public HashMap<Integer, Integer> getNameRecordHashMap() {
        return _nameRecordHashMap;
    }

    /**
     * The best year for the name
     * @return int best year
     */
    public int bestDecade() {
        return best()
                .getKey();
    }

    private Map.Entry<Integer, Integer> best() {

        return _nameRecordHashMap
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get();
    }

    public void plot() {
        var stdDraw = new StdDraw();
    }

    private void splitInput(String input) {
        var splitter = input.split(" ");
        var mutableFirstYear = START;
        _name = splitter[0];

        for (var i = 0; i < splitter.length; i++) {
            if(i != 0) {
                _nameRecordHashMap.put(mutableFirstYear, Integer.parseInt(splitter[i]));
                mutableFirstYear += 10;
            }
        }
    }
}
