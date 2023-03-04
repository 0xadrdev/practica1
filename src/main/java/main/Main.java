package main;

import csv.CSV;
import table.Table;
import table.TableWithLabels;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
/*        Table tablaSinEtiquetas = CSV.readTable("C:/Users/adale/Desktop/Practica1 final/Practica1/src/main/resources/miles_dollars.csv");
        System.out.println(tablaSinEtiquetas.getHeaders());
        for (int i = 0; i < tablaSinEtiquetas.getNumberOfLines(); i++) {
            System.out.println(tablaSinEtiquetas.getRowAt(i).getData());
        }*/
        TableWithLabels tableConEtiquetas = CSV.readTableWithLabels("C:/Users/adale/Desktop/Practica1 final/Practica1/src/main/resources/iris.csv");
        for (int i = 0; i < tableConEtiquetas.getNumberOfLines(); i++) {
            System.out.println(tableConEtiquetas.getLabelAt(tableConEtiquetas.getRowAt(i).getNumberClass()));
            System.out.println(tableConEtiquetas.getRowAt(i).getData());
        }

    }
}