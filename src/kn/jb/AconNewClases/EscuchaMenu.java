package kn.jb.AconNewClases;

import java.awt.event.*;

public class EscuchaMenu implements ActionListener {
		
	public void actionPerformed(ActionEvent e) {
			
		if (e.getActionCommand().compareTo("Company Master")==0) {
			VentanaCompanyMaster vcm = new VentanaCompanyMaster();
			vcm.setDefaultCloseOperation(1);
		}
		
		if (e.getActionCommand().compareTo("Currency Code")==0) {
			new VentanaMoneda();
		}
		
		if (e.getActionCommand().compareTo("Bank Master")==0) {
			new VentanaBankMaster();
		}

	}

}
