package table;
import row.Row;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows = new ArrayList<>();

    public Table(List<String> headers){
        this.headers = headers;
    }
    public void addRow(List<Double> data){
        rows.add(new Row(data));
    }
    public Row getRowAt(int possition){
        return rows.get(possition);
    }
    public int getNumberOfLines () {
        return this.rows.size();
    }
    public List<String> getHeaders() {
        return this.headers;
    }
}