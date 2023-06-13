package zad_2_pckg;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class DataPanel extends JPanel{
    private JTextField payment;
    private JTextArea txtAr;
    private ScrollPane scrollPane;

    DataPanel() {
        setPreferredSize(new Dimension(300,400));
        createComp();
    }
    private void createComp(){
        payment = new JTextField(20);
        payment.setEditable(false);
        txtAr = new JTextArea();
        txtAr.setEditable(false);
        txtAr.setLineWrap(false);
        scrollPane = new ScrollPane();
        scrollPane.add(txtAr, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(300,340));
        scrollPane.setVisible(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(scrollPane, gbc);
        gbc.gridy++;
        add(payment, gbc);
    }
    public void setData(Float payment){
        this.payment.setText(payment.toString());
    }

    public void showCalculations(ArrayList<Calculation> calculations){
        txtAr.setText("");
        for (Calculation calculation : calculations) {
            txtAr.append("/////////////////Calculation/////////////////\n");
            txtAr.append("Vsina kredita: " + calculation.getKreda() + "\n");
            txtAr.append("Kamatna stopa: " + calculation.getKamata() + "\n");
            txtAr.append("Godina otplate: " + calculation.getGodina() + "\n");
            txtAr.append("Rata kredita: " + calculation.getPay() + "\n");

        }
    }


}
