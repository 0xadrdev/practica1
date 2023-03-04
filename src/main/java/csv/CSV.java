package csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import row.Row;
import row.RowWithLabels;
import table.Table;
import table.TableWithLabels;

import java.util.List;

public class CSV {
    public static Table readTable(String file) throws FileNotFoundException {
        File myFile = new File(file);
        List<String> headers = new ArrayList<>();

        Scanner myReader = new Scanner(myFile);

        //add headers
        headers.addAll(Arrays.asList(myReader.nextLine().split(",")));

        Table table = new Table(headers);

        while(myReader.hasNextLine()) {
            String[] rowData = myReader.nextLine().split(",");
            List<Double> rowDataAsDouble = new ArrayList<>();
            for(int i=0; i< rowData.length; i++){
                rowDataAsDouble.add(Double.parseDouble(rowData[i]));
            }
            table.addRow(rowDataAsDouble);
        }

        return table;
    }

    public static TableWithLabels readTableWithLabels(String file) throws FileNotFoundException{
        File myFile = new File(file);
        List<String> headers = new ArrayList<>();
        List<String> labels = new ArrayList<>();

        Scanner myReader = new Scanner(myFile);

        //add headers
        headers.addAll(Arrays.asList(myReader.nextLine().split(",")));

        TableWithLabels table = new TableWithLabels(headers);

        while(myReader.hasNextLine()) {
            String[] rowData = myReader.nextLine().split(",");
            labels.add(rowData[rowData.length - 1]);
            ArrayList<Double> rowDataAsDouble = new ArrayList<>();
            for(int i = 0;  i < rowData.length - 1; i++){
                rowDataAsDouble.add(Double.parseDouble(rowData[i]));
            }
            table.addRow(rowDataAsDouble, rowData[rowData.length - 1]);
        }
        return table;
    }
}