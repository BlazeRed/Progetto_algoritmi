package main_time;

import generazione_campioni.GenerazioneCampioni;
import input_output.InputOutput;

public class MainTime {

    public static void main(String[] args) {
        
        GenerazioneCampioni gen = new GenerazioneCampioni(10000, 233);
        gen.misurazioneTempoMedio();

        


        
    }

}