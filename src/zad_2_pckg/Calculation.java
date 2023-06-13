package zad_2_pckg;


public class Calculation{
    private double pay;
    private float kreda;
    private float kamata;
    private int nacin;
    private int godina;

    public Calculation(float kreda, float kamata, int nacin, int godina) {
        this.kreda = kreda;
        this.kamata = kamata;
        this.nacin = nacin;
        this.godina = godina;
        this.pay = calculate(kreda, kamata, nacin, godina);
    }

    public static double calculate(float kreda, float kamata, int nacin, int godina) {
        double pay;
        float intr = kamata/nacin;
        int n = godina*12;
        double D = (Math.pow((1+intr), n)-1) / (intr*Math.pow((1+intr),n));
        pay = kreda / D;
        return pay;
    }
    public void setPay(float pay) {
        this.pay = pay;
    }
    public double getPay() {
        return pay;
    }
    public float getKreda() {
        return kreda;
    }
    public float getKamata() {
        return kamata;
    }
    public int getNacin() {
        return nacin;
    }
    public int getGodina() {
        return godina;
    }
    public String toString(){
        return "Kredit: " + kreda + " Kamata: " + kamata + " Nacin: " + nacin + " Godina: " + godina + " Placanje: " + pay + "\n";
    }
}