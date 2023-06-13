package zad_2_pckg;

import java.awt.*;

import javax.swing.*;

public class FormPanel extends JPanel{
    private JTextField txtField;
    private JRadioButton rbtnMnth;
    private JRadioButton rbtnQuart;
    private JButton btnOK;
    private JButton btnList;
    private JTextField txtGodina;
    private String[] kamate = {"5%", "6%", "7%", "8%", "9%", "10%", "11%"};
    private JComboBox combo;
	private FormListener formListener;
	private FormEvent formEvent;

    public FormPanel() {
        setPreferredSize( new Dimension( 300, 400 ) );
        createComp();
        layoutComponents();
		activateForm();
    }
    private void createComp(){
        txtField = new JTextField(10);
        txtGodina = new JTextField(10);
        combo = new JComboBox(kamate);
        rbtnMnth = new JRadioButton("Mjesečno plaćanje");
		rbtnMnth.setSelected(true);
        rbtnQuart = new JRadioButton("Kvartalno plaćanje");
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnMnth);
		group.add(rbtnQuart);
        btnOK = new JButton("Izračunaj");
        btnList = new JButton("Prikaz");
        
    }
    public void layoutComponents() {

		GridBagConstraints gbc = new GridBagConstraints();

		///////////////// First Row ////////////////////////
		gbc.weightx = 0.5;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Visina kredita"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtField, gbc);
		///////////////// Second Row ////////////////////////
		gbc.weightx = 0.5;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("GodinaOtplate"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtGodina, gbc);

		///////////////// Second Row ////////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.2;

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(new JLabel("Kamatna stopa"), gbc);

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		add(combo, gbc);

		///////////////// Third Row ////////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.1;

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(rbtnMnth, gbc);

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(rbtnQuart, gbc);
		///////////////// Last Row ////////////////////////
		gbc.weightx = 1;
		gbc.weighty = 2;

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(0, 10, 0, 0);
		gbc.anchor = GridBagConstraints.LINE_END;
		add(btnList, gbc);

		gbc.gridx = 1;

		gbc.insets = new Insets(0, 5, 0, 12);
		gbc.anchor = GridBagConstraints.LINE_END;
		add(btnOK, gbc);

	}
	public void activateForm(){
		btnOK.addActionListener(e -> {
			setFormEvent(new FormEvent(this));
			formEvent.setKreda(Integer.parseInt(txtField.getText()));
			formEvent.setKamata(getKamata());
			formEvent.setGodina(Integer.parseInt(txtGodina.getText()));
			if(rbtnMnth.isSelected()){
				formEvent.setNacin(12);
			}else if(rbtnQuart.isSelected()){
				formEvent.setNacin(4);
			}
			if(formListener != null){
				formListener.calculateFormEventOccurred(formEvent);
			}
		});
		btnList.addActionListener(e -> {
			setFormEvent(new FormEvent(this));
			formEvent.setKreda(Integer.parseInt(txtField.getText()));
			formEvent.setKamata(getKamata());
			formEvent.setGodina(Integer.parseInt(txtGodina.getText()));
			if(rbtnMnth.isSelected()){
				formEvent.setNacin(12);
			}else if(rbtnQuart.isSelected()){
				formEvent.setNacin(4);
			}
			System.out.println("FormEvent: " + formEvent);
			if(formListener != null){
				formListener.listFormEventOccurred(formEvent);
			}
		});


	}
	private float getKamata(){
		String kamata = (String) combo.getSelectedItem();
		float kamataFloat = Float.parseFloat(kamata.substring(0, kamata.length()-1));
		return kamataFloat/100;
	}
	public void setFormListener(FormListener formListener){
		this.formListener = formListener;
	}
	private void setFormEvent(FormEvent e){
		this.formEvent = e;
	}
}


