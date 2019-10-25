package random;
public class RandomGenerator {

	/*
		Classe che genera numeri casuali, migliore del random di sistema
	 */

	// variabile che tiene memorizzato il seme
	private double seed;

	public RandomGenerator(double s) {
		seed = s;
	}

	// restituisce un numero compreso tra 0 e 1 (e aggiorna il seme)
	public double get() {

		final int a = 16087;
		final int m = 2147483647;
		final int q = 127773;
		final int r = 2836;

		double lo, hi, test;

		hi = Math.ceil(seed / q);
		lo = seed - q * hi;
		test = a * lo - r * hi;
		if (test < 0.0) {
			seed = test + m;
		} else {
			seed = test;
		}
		return seed / m;
	}

	public void setSeed(double s) {
		seed = s;
	}
}