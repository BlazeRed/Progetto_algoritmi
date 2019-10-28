package strumenti_analisi;

import main_time.MainWork;

public class CalcoloTemporale{
    //classe che mette a disposizione tutti gli strumenti per l'analisi temporale delgi algoritmi

    //metodo per il calcolo della granularità del sistema
    public static long granularita() {
		long t0 = System.currentTimeMillis();
		long t1 = System.currentTimeMillis();
		while (t1 == t0) {
			t1 = System.currentTimeMillis();
		}
		return t1 - t0;
    }

	//metodo per il calcolo delle ripetizioni 
	public static int calcolaRip(String[] input, double tMin){
		long t0 = 0;
		long t1 = 0;
		int rip = 1;
		
		while ((t1 - t0) <= tMin) {
			rip = rip * 2; 
			t0 = System.currentTimeMillis();
			for (int i = 1; i <= rip; i++) {
				MainWork.main(input);
			}
			t1 = System.currentTimeMillis();
		}
		
		int max = rip;
		int min = rip / 2;
		int cicliErrati = 5;
		while ((max - min) >= cicliErrati) {
			rip = (max + min) / 2;
			t0 = System.currentTimeMillis();
			for (int i = 1; i <= rip; i++) {
				MainWork.main(input);
			}
			t1 = System.currentTimeMillis();
			if ((t1 - t0) <= tMin) {
				min = rip;
			} else {
				max = rip;
			}
		}
		return max;
	}

	//metodo che esegue il programma Rip volte
	public static double calcoloDeiTempi(String[] input, double rip){
		long t0 = System.currentTimeMillis();
		for(int i = 0; i<rip; i++){
			MainWork.main(input);
		}
		long t1 = System.currentTimeMillis();
		long tTot = t1 -t0;
		double tMed = ((double) tTot)/((double) rip);
		return tMed;
	}

	//metodo per la misurazione del tempo medio 
	public static double misurazioneTempoMedio(String[] input, int c, double za, double tMin) {
		double t = 0;
		double sum = 0;
		double cn = 0;

		double delta = 0;
		double e = 0;
		double m = 0;
		double s = 0;
		double Delta=0;

		do {
			for (int i = 1; i <= c; i++) {
				m = calcoloDeiTempi(input, tMin);
				t = t + m;
				sum = sum + Math.pow(m, 2);
			}
			cn = cn + c;
			Delta = t/(cn*10); 
			e = t/cn;
			s = Math.sqrt(sum / cn - Math.pow(e, 2));
			delta = 1 / (Math.sqrt(cn) * za * s);
		} while (delta<Delta);
		
		/* Valore atteso in secondi */
		e=e/1000;

		return e;
	}

	public static double tMin(long granularita) {
		double tMin = granularita / 0.02;
		return tMin;
	}
    

}