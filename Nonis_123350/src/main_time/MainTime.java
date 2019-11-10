package main_time;

import generazione_campioni.GenerazioneCampioni;

public class MainTime {

    public static void main(String[] args) {
        
        GenerazioneCampioni gen = new GenerazioneCampioni(10000, 89080);
        gen.misurazioneTempoMedio();
        
    }

}