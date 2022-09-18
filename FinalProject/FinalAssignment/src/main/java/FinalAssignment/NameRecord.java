package FinalAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Christian Oleson
 * A Name record class that encapsulates the ranking of a single name across the decades.
 */
public class NameRecord {
    private String _name;
    /**
     * The final assignment technically requires that the rank of the name be an integer array of the ranks.
     * However, this is not as efficient as a hash map. An integer array means that in order to find a specific value
     * of an array, we have to know that position 1 is always 1900, and position 6 is always 1950. You then have to
     * provide a calculation to determine what array value is needed. However, instead, we put the processing up front.
     * With a hash map, we initially set up the decades on instantiation of the name record class, and hash maps are
     * extremely efficient, with O(n) time complexity, which means over the long run, interactions with this hash map
     * will win out over the integer array. Hopefully this deviation is deemed an adequate deviation from the assignment
     * in the name of usability and efficiency.
     */
    private LinkedHashMap<Integer, Integer> _nameRecordHashMap;
    private final int START = 1900;
    private final int DECADES = 11;

    public NameRecord(String nameRecordString) {
        _nameRecordHashMap = new LinkedHashMap<>();
        splitInput(nameRecordString);
    }

    /**
     * Gets the name of the current record
     * @return String name
     */
    public String getName() {
        return _name;
    }

    /**
     * Gets the rank of the name for the decade provided.
     * To satisfy the requirements of the assignment, this is the method that caused me to move from a HashMap to a
     * LinkedHashMap. HashMaps don't require order, but also, trying to remember a decade in terms of its array position
     * is a bit nonsensical.
     * @param decade the position of the decade
     * @return int rank of the decade provided
     */
    public int getRank(int decade) {
        var mutableStart = START;
        for (int i = 0; i < decade; i++) {
            mutableStart += 10;
        }

        return getNameRecordHashMap().get(mutableStart);
    }

    /**
     * Gets the best rank for a given name
     * @return BestRankYear a DTO with the best rank and best year for a given baby name
     */
    public int getBestRank() {
        return best().getValue();
    }

    public BestRankYear getBestRankYear() {
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
    public int bestYear() {
        return best()
                .getKey();
    }

    /**
     * Uses a Java stream to get the best rank (e.g. the lowest value) and corresponding year for a baby name.
     * Filters out values zero or below since a 0 means the name was not in the top 1000 and thus was unranked.
     * @return Map.Entry<Integer, Integer> a hash map entry of the year (key) and rank (value)
     */
    private Map.Entry<Integer, Integer> best() {

        return getNameRecordHashMap()
                .entrySet()
                .stream()
                .filter(entry1 -> entry1.getValue() > 0)
                .min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get();
    }

    /**
     * Plots the rank of a baby name over 11 decades, starting with 1900
     */
    public void plot() {
        if (getNameRecordHashMap() == null) {
            return;
        }

        int width = 500;
        int height = 500;
        int yMin = -1500;
        int yMax = 0;
        int xMin = START - 5;
        int xMax = START + (10 * DECADES) + 5;

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(xMin, xMax);
        StdDraw.setYscale(yMin, yMax);
        StdDraw.setPenRadius(0.015);
        StdDraw.setPenColor(Color.getRandomColor());

        getNameRecordHashMap().forEach((nameRecordKey, nameRecordValue) -> StdDraw.point(nameRecordKey, -convertZeroedValue(nameRecordValue, yMin)));
        StdDraw.text(1950, -100, _name);
    }

    private int convertZeroedValue(int val, int yMin) {
        if (val == 0) {
            return yMin;
        }

        return val;
    }

    /**
     * Takes the input of a line found from the baby name data from the census and splits it on spaces.
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
                getNameRecordHashMap().put(mutableFirstYear, Integer.parseInt(splitter[i]));
                mutableFirstYear += 10;
            }
        }
    }
}
