package zad_2_pckg;

import java.util.ArrayList;
import java.util.EventObject;

public class FormEvent extends EventObject{
    private float kreda;
    private float kamata;
    private int nacin;
    private int godina;

    public FormEvent(Object source) {
        super(source);
    }


    public float getKreda() {
        return kreda;
    }
    public void setKreda(float kreda) {
        this.kreda = kreda;
    }
    public float getKamata() {
        return kamata;
    }
    public void setKamata(float kamata) {
        this.kamata = kamata;
    }
    public int getNacin() {
        return nacin;
    }
    public void setNacin(int nacin) {
        this.nacin = nacin;
    }
    public int getGodina() {
        return godina;
    }
    public void setGodina(int godina) {
        this.godina = godina;
    }
    public ArrayList<Calculation> getCalculation() {
        return null;
    }
    public void setCalculation(ArrayList<Calculation> calculation) {
    }
}
