package zad_2_pckg;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class MainFrame extends JFrame{
    private FormPanel formPanel;
    private DataPanel dataPanel;

    public MainFrame() {
        super("Zadatak 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        createComp();
        activateForm();
    }



    private void createComp(){
        formPanel = new FormPanel();
        dataPanel = new DataPanel();
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.WEST);
        add(dataPanel, BorderLayout.EAST);

    }
    private void activateForm(){
        ArrayList<Calculation> calculations = new ArrayList<Calculation>();
        formPanel.setFormListener(new FormListener() {
            @Override
            public void calculateFormEventOccurred(FormEvent e) {
                calculations.add(new Calculation(e.getKreda(), e.getKamata(), e.getNacin(), e.getGodina()));
                dataPanel.setData((float)calculations.get(calculations.size()-1).getPay());
            }
            @Override
            public void listFormEventOccurred(FormEvent e) {
                dataPanel.showCalculations(calculations);
            }
        });
    }
}


