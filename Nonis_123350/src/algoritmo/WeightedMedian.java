package algoritmo;

// import java.util.Arrays;

import random.RandomGenerator;


public class WeightedMedian {

    /**
     * @param arr
     * @return la mediana pesata dell'array di input
     */
    public double medianaPesata(double [] arr){ 
        //valori dell'array su cui effettuare l'ortinamento (low, high)
    	int lo = 0;
    	int hi = arr.length-1;
        //Ordino l'array dato un sottoarray lo-hi
		quickSort(arr, lo, hi);
		//Somma di tutti gli elemeti dell'array
        double sumW = totalSumInput(arr);
        // // Debugging
        // System.out.println("La somma totale è: " + sumW);
        // System.out.println("La somma totale diviso 2 è: " + sumW/2);
        // System.out.println("Array ordinato: " + Arrays.toString(arr));
		//indice della somma cumulativa
		int indexCumSum = cumulativeSum(arr, sumW);
        return arr[indexCumSum-1]; 
	} 
	
	/**
	 * @param arr
	 * @return la somma degli elementi di arr
	 */
	private double totalSumInput(double [] arr){
		double sumW = 0;
		for(int i=0; i<arr.length; i++){
			sumW += arr[i];
		}
		return sumW;
	}

	/**
	 * 
	 * @param arr di double
	 * @param sumW somma di tutti gli elementi di arr
	 * @return indice per la mediana
	 */
	private int cumulativeSum(double arr[], double sumW){
		int index = 0;
		double partialSum = 0;
		while(partialSum<sumW/2) {
        	partialSum += arr[index];
        	index++;
        }
		return index;
	}

	/**
	 * @param arr array da ordinare
	 * @param lo indice inferiore del array
	 * @param hi indice superiore del array
	 * 
	 * modifica l'array ordinando i suoi elementi in maniera non decrescente
	 */
	private void quickSort(double[] arr, int lo, int hi) {
		if(lo < hi) {
			int pi = partition_random(arr, lo, hi);
			quickSort(arr, lo, pi-1);
			quickSort(arr, pi+1, hi);
		}
		
	}

	private int partition(double[] arr, int lo, int hi) {
		double pivot = arr[hi];
		int i = lo - 1; 
		for(int j=lo; j<hi; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, hi);
		return i+1;
	}
	
	private int partition_random(double[] arr, int lo, int hi) {
		RandomGenerator r = new RandomGenerator(123);
		int random = (int) (lo + r.get() % (hi - lo)); 
		// Swap A[random] with A[high] 
	    swap(arr, random, hi);
		return partition(arr, lo, hi);
	}

	private void swap(double[] arr, int i, int j) {
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	} 

}