package generazione_campioni;

import input_output.InputOutput;
import strumenti_analisi.CalcoloTemporale;

public class GenerazioneCampioni {

    InputOutput inOut = new InputOutput();
    int lunghezza;
    int ripetizioni;
    int seed;
    double za;

    public GenerazioneCampioni(int lunghezza, int seed) {
        this.lunghezza = lunghezza;
        this.seed = seed;
        ripetizioni = 10;
        za = 2.33;
    }

    public void misurazioneTempoMedio () {
        //double t0 = System.currentTimeMillis();
        double tMin = CalcoloTemporale.tMin(CalcoloTemporale.granularita());
        double tMed = 0;
        for (int i=1; i <= lunghezza; i++) {
                String[] campione = new String[1];
                campione[0] = inOut.makeInput(i, seed);
                tMed = CalcoloTemporale.misurazioneTempoMedio(campione, ripetizioni, za, CalcoloTemporale.calcolaRip(campione, tMin));
                System.out.println(tMed);
        }
        //double t1 = System.currentTimeMillis();
        //double tTot = ((t1-t0)/1000)/60;
        //System.out.println(tTot);
    }


// End Class
}