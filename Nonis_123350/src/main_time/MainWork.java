package main_time;

import algoritmo.WeightedMedian;

public class MainWork {

    public static void main(String[] args) {

        String input = args[0];

        while(!( input.substring(input.length()-1).equals("."))) {
            input = input.substring(0, input.length()-1);
        }
        if ((input.substring(input.length() - 1).equals(".")) && (input.contains(","))) {
            // elimino il "." terminale
            String sub = input.substring(0, input.length() - 1);

            String[] res = sub.split(",");
            double[] inputArr = new double[res.length];

            for (int i = 0; i < res.length; i++) {
                inputArr[i] = Double.parseDouble(res[i]);
            }
//
            WeightedMedian mediana = new WeightedMedian();
            System.out.println(mediana.medianaPesata(inputArr));
        }
    }
}