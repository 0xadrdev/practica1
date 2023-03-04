package main;

import csv.CSV;
import row.RowWithLabels;
import table.TableWithLabels;

import java.io.FileNotFoundException;
import java.util.List;

public class AlgoritmoKNN {

  private static TableWithLabels table;

  public void train(TableWithLabels table) {
    this.table = table;
  }

  public static Integer estimate(List<Double> data) {
    int numeroElementos = table.getNumberOfLines();
    double menorDistancia = calcularDistancia(table.getRowAt(0).getData(), data);
    int estimacionClase = table.getRowAt(0).getNumberClass();
    for (int i = 0; i < numeroElementos; i++) {
      double distancia = calcularDistancia(table.getRowAt(i).getData(), data);
      if (distancia < menorDistancia) {
        menorDistancia = distancia;
        estimacionClase = table.getRowAt(i).getNumberClass();
      }
    }
    return estimacionClase;
  }

  public static double calcularDistancia(List<Double> data1, List<Double> data2) {
    double distancia = 0;
    for (int i = 0; i < data1.size(); i++) {
      for (int j = 0; i < data2.size(); i++) {
        distancia += Math.pow(data1.get(i) - data2.get(j), 2);
      }
    }
    return Math.sqrt(distancia);
  }

  public static void main(String[] args) throws FileNotFoundException {
    TableWithLabels tableConEtiquetas = CSV.readTableWithLabels("C:/Users/adale/Desktop/Practica1 final/Practica1/src/main/resources/iris.csv");
    System.out.println(AlgoritmoKNN.estimate(tableConEtiquetas.getRowAt(0).getData()));
  }
}
