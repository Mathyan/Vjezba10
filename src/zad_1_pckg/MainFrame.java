package zad_1_pckg;
import java.awt.*;

import javax.swing.*;
// ostali uvozi

public class MainFrame extends JFrame {

    private JPanel left;
    private JPanel right;
    private JTextField textFld;
    private JButton btn;
    private JTextArea area;
    private JScrollPane scp;
    private JButton resetBtn;


    public MainFrame(){

        // naziv postaviti -> koristiti super()
        super("Application with GUI");

        // veličina 500, 450
        setSize(500, 450);
        // EXIT_ON_CLOSE
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // prikaz na sredini ekrana
        setLocationRelativeTo(null);

        // spriječiti promijenu dimenzija
        setResizable(false);

        // postaviti vidljivost na true
        setVisible(true);

        // za inicijalizaciju lijevog panela
        // i njegovih komponenti
        initLeft();
        // razmještaj komponenti na lijevom panelu
        layoutLeft();
        // za inicijalizaciju desnog panela
        // i njegovih komponenti
        initRight();
        // razmještaj komponenti na desnom panelu
        layoutRight();
        // za postavljanje lijevog i desnog panela na MainFrame
        // MainFrame koristi BorderLayout
        layoutAll();
        // aktiviranje forme
        activateFrame();
    }

    private void initRight(){
        right = new JPanel();
        right.setBackground(Color.WHITE);
        area = new JTextArea(10, 20);
        area.setBackground(Color.GRAY);
        area.setEditable(false);
        area.setCaretColor(Color.GRAY);
        scp = new JScrollPane(area);
        scp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scp.setPreferredSize(new Dimension(350, 450));

    }

    private void layoutRight(){
        right.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        right.add(scp, gbc);

    }

    private void initLeft(){
            left = new JPanel();
            left.setPreferredSize(new Dimension(150, 0));
            left.setBackground(Color.LIGHT_GRAY);
            textFld = new JTextField(10);
            btn = new JButton("Submit text");
            resetBtn = new JButton("Reset");
            resetBtn.setEnabled(false);
    }


    private void layoutLeft(){

        left.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.gridx = 0;
        left.add(new JLabel("Text:"), gbc);
        gbc.gridy++;

        gbc.weighty = 0.45;
        // now field
        gbc.gridy++;
        left.add(textFld, gbc);
        Component bx = Box.createVerticalStrut(30);
        left.add(bx, gbc);
        // now button
        gbc.gridy++;
        gbc.weighty = 0.45;
        left.add(btn, gbc);
        // now reset button
        gbc.gridy++;
        left.add(resetBtn, gbc);
    }

    private void layoutAll(){
        setLayout(new BorderLayout());
        // lijevi dodati u WEST
        add(left, BorderLayout.WEST);
        // desni dodati u CENTER
        add(right, BorderLayout.CENTER);

    }

    private void activateFrame(){

        // za btn Submit text
        btn.addActionListener(e -> {
            String text = textFld.getText();
            if(text.length() > 0){
                area.append(text + "\n************************\n");
                textFld.setText("");
                resetBtn.setEnabled(true);
            }
        });



        // za bnt Reset
        resetBtn.addActionListener(e -> {
            area.setText("");
            resetBtn.setEnabled(false);
        });




    }

}
