package table;

import row.RowWithLabels;

import java.util.*;

public class TableWithLabels extends Table {
    private int numLabels = 0;
    private Map<String, Integer> labelsToIndex = new HashMap<>();
    private List<RowWithLabels> rows = new ArrayList<>();

    public TableWithLabels(List<String> headers){
        super(headers);
    }

    public void addRow(List<Double> data, String label){
        if(!labelsToIndex.containsKey(label)) {
            labelsToIndex.put(label, numLabels++);
        }
        rows.add(new RowWithLabels(data, labelsToIndex.get(label)));
    }

    public RowWithLabels getRowAt(int possition) {
        return rows.get(possition);
    }

    public int getNumberOfLines () {
        return this.rows.size();
    }

    public String getLabelAt(int pos) {
        for (Map.Entry<String, Integer> entry: labelsToIndex.entrySet()) {
            if (entry.getValue() == pos) {
                return entry.getKey();
            }
        }
        return null;
    }

}