package main;
import java.util.Arrays;
import java.util.Scanner;
import algoritmo.*;

public class Main{
  
    public static void main (String[] args) {
        //0.1,0.35,0.05,0.1,0.15,0.05,0.2.
        // 0.1,0.35,0.05,0.1,0.15,0.05,0.2  .
        WeightedMedian mediana = new WeightedMedian();

        //TODO capire come portare fuori la lavoraizone dell'input

        Scanner in = new Scanner(System.in); 
        String str = in.nextLine();

        //controllo se l'ultimo elemento della stringa è un punto e se sono presenti i separatori
        while(!( str.substring(str.length()-1).equals("."))) {
            str = str.substring(0, str.length()-1);
        }
        if(( str.substring(str.length()-1).equals(".") ) && ( str.contains(",") )){
            //elimino il "." terminale
            String sub = str.substring(0, str.length()-1);
           
            String [] res = sub.split(",");
			double [] input = new double[res.length];
            
			for(int i=0; i<res.length; i++) {
				input[i] =  Double.parseDouble( res[i] );		
			}
            //TODO elimina la stampa del'input
			//System.out.println(Arrays.toString(input));
			System.out.println(mediana.medianaPesata(input));

        }else {
			in.close();
			throw new IllegalArgumentException("L'input non è del formato giusto");
        }
    		
		in.close();
    }
}