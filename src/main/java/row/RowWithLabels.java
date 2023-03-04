package row;

import java.util.List;

public class RowWithLabels extends Row {
    private int numberClass;

    public RowWithLabels(List<Double> data, int numberClass){
        super(data);
        this.numberClass = numberClass;
    }

    public int getNumberClass(){
        return this.numberClass;
    }
}