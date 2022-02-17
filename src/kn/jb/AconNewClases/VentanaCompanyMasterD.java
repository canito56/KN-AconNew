package kn.jb.AconNewClases;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import kn.jb.ConexionesAs400.*;

public class VentanaCompanyMasterD extends JFrame {
	
	private static final long serialVersionUID = 7526472295622776147L;
	private JTextArea areaSalida;
	
	public VentanaCompanyMasterD(String company) {
		super("COMPANY MASTER Detail");
		setSize(400, 200); 
		setLocation(600, 250);
		JLabel titulo = new JLabel("Company            A/R             A/P             FSL             G/L");
		areaSalida = new JTextArea(); 
		areaSalida.setEditable(false);
		ScrollPane panelDesplazable = new ScrollPane();
		panelDesplazable.add(areaSalida);
	    Container contenedor = getContentPane();
	    contenedor.add( titulo, BorderLayout.NORTH );
	    contenedor.add( panelDesplazable, BorderLayout.CENTER );
	    leerCompanyMasterD(company);
		setVisible(true);
	}

	private void leerCompanyMasterD(String company) {
		try {
			ConexionAsknudev conUdev = ConexionAsknudev.getInstance(); 
			Statement stmt = conUdev.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ACONDTSAO.ACAAREPF " +
//			ResultSet rs = stmt.executeQuery("select * from ACONDSAO.ACAAREPF " +		
											 "where AA_COMP_CODE = '" + company.trim() + "'"); 
			while (rs.next()) {
				if (rs.getString(1).equals(company.trim())) {
					areaSalida.append("   " + company);
					areaSalida.append("                 " + rs.getString(5));
					areaSalida.append("      " + rs.getString(6));
					areaSalida.append("      " + rs.getString(7));
					areaSalida.append("      " + rs.getString(8) + "\n");
				}
			}
			rs.close();
			stmt.close();
		}	catch(Exception ex) {
				System.out.println(ex);
				System.exit(0);
			}
	}

}
