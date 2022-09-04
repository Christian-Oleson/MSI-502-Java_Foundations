package FinalAssignment;

import java.util.HashMap;

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

    public String getName() {
        return _name;
    }

    public int getRank(int decade) {
        return _nameRecordHashMap.get(decade);
    }

    public HashMap<Integer, Integer> getNameRecordHashMap() {
        return _nameRecordHashMap;
    }

    public int bestYear() {
        return _nameRecordHashMap
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getKey();
    }

    public void plot() {
        var stdDraw = new StdDraw();
        stdDraw.
    }

    private void splitInput(String input) {
        var splitter = input.split(" ");
        var mutableFirstYear = START;

        for (var i = 0; i < splitter.length; i++) {
            if(i != 0) {
                _nameRecordHashMap.put(mutableFirstYear, Integer.parseInt(splitter[i]));
            } else {
                _name = splitter[i];
            }

            mutableFirstYear += 10;
        }
    }
}
