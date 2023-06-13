package zad_2_pckg;
import java.util.EventListener;



public interface FormListener extends EventListener {
    
    public void calculateFormEventOccurred(FormEvent e);
    public void listFormEventOccurred(FormEvent e);
}