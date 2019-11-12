package main;
import java.util.Scanner;
import algoritmo.*;

public class Main{
  
    public static void main (String[] args) {
        WeightedMedian mediana = new WeightedMedian();
        
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

			System.out.println(mediana.medianaPesata(input));

        }else {
			in.close();
			throw new IllegalArgumentException("L'input non è del formato giusto");
        }
    		
		in.close();
    }
}