package algoritmo;
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
		
		//calcolo la somma totale dei pesi
		double sumW = 0;
		for(int i=0; i<arr.length; i++){
			sumW += arr[i];
		}
		
		//calcolo la somma cumulativa per la mediana pesata
		double partialSum = 0;
        int i = 0;
        while(partialSum<sumW/2) {
        	partialSum += arr[i];
        	i++;
        }
        
        return arr[i-1]; 
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