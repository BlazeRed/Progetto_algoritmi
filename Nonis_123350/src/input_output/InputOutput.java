package input_output;

import random.RandomGenerator;

public class InputOutput {

    /**
     * Metodo che crea una stringa di input formata da numeri double random di lunghezza prefissata
     * @param lunghezza numero di double nella stringa
     * @param hardSeed seed per calcolo del Random
     * @return stringa di numeri double
     */
    public String makeInput(int lunghezza, int hardSeed) {
        String input = "";
        for(int i = 0; i < lunghezza; i++) {
            input += makeNumeroRandom(hardSeed) + " , ";
        }
        input = input.substring(0, input.length() - 2);
        input += " .";
        return input;
    }

    /**
     * Metodo che genera un double casuale con precisione di 5 cifre decimali e lo trasforma in stringa
     * @param hardSeed seed reale per il calcolo del seedRandom
     * @return Stringa di un singolo double.
     */
    private String makeNumeroRandom(int hardSeed) {
        int seedRandom = (int)(Math.random() * hardSeed);
        RandomGenerator random = new RandomGenerator(seedRandom);
        double maxNum = random.get() * 1000000.0;
        double realNum = random.get() * maxNum;
        // Arrotonda double a 5 cifre decimali
        double realNumRound = Math.round(realNum * 100000d) / 100000d;
        String realNumString = realNumRound + "";
        return realNumString;
    }

}