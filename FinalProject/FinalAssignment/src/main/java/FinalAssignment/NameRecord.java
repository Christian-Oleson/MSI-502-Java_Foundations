package FinalAssignment;

import java.util.HashMap;
import java.util.Map;

public class NameRecord {
    private String _name;
    private String _nameRecordString;
    private HashMap<Integer, Integer> _nameRecordHashMap;
    private final int START = 1900;
    private final int DECADES = 11;
    private StdDraw _stdDraw;

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

    /**
     * Gets the best rank for a given name
     * @return BestRankYear a DTO with the best rank and best year for a given baby name
     */
    public BestRankYear getBestRank() {
        var best = best();

        return new BestRankYear(best.getKey(), best.getValue());
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

    /**
     * Uses a Java stream to get the maximum value and corresponding year for a baby name.
     * @return Map.Entry<Integer, Integer> a hash map entry of the year (key) and rank (value)
     */
    private Map.Entry<Integer, Integer> best() {

        return _nameRecordHashMap
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get();
    }

    /**
     * Plots the rank of a baby name over 11 decades, starting with 1900
     */
    public void plot() {
        int width = 500;
        int height = 500;

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(START - 10, START + (10 * DECADES) + 10);
        StdDraw.setYscale(-10, 2000);
        StdDraw.setPenRadius(0.015);
        StdDraw.setPenColor(Color.getRandomColor());

        if (_nameRecordHashMap == null)
        {
            return;
        }

        _nameRecordHashMap.forEach((nameRecordKey, nameRecordValue) -> StdDraw.point(nameRecordKey, nameRecordValue));
        StdDraw.text(1950, START + (10 * DECADES) - 100, _name);
    }

    /**
     * Tales the input of a line found from the baby name data from the census and splits it on spaces.
     * The first value is the name, with the subsequent values being the rank for each decade.
     * @param input a line of data from the census in the following form
     *              Christian 297 434 603 617 621 392 253 117 90 33 22
     */
    private void splitInput(String input) {
        var splitter = input.split(" ");
        var mutableFirstYear = START;
        _name = splitter[0].toLowerCase();

        for (var i = 0; i < splitter.length; i++) {
            if(i != 0) {
                _nameRecordHashMap.put(mutableFirstYear, Integer.parseInt(splitter[i]));
                mutableFirstYear += 10;
            }
        }
    }
}
