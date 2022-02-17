package kn.jb.AconNewClases;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import kn.jb.ConexionesAs400.*;
@SuppressWarnings("unused")

public class VentanaCompanyMaster extends JFrame {
	
	private static final long serialVersionUID = 7526472295622776147L;
	private JTextArea areaSalida;
	private String company;
	
	public VentanaCompanyMaster() {
		super("COMPANY MASTER");
		setSize(600, 300); 
		setLocation(500, 200);
		JLabel titulo = new JLabel("Company Code     Company Name");
		areaSalida = new JTextArea(); 
		areaSalida.setEditable(false);
		areaSalida.addMouseListener(new MouseAdapter() { 
			public void mouseClicked(MouseEvent e) { 
				int rowOff = areaSalida.getSelectionStart();
				try {
					company = areaSalida.getText(rowOff, 10).trim();
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				VentanaCompanyMasterD vcmd = new VentanaCompanyMasterD(company);
			} 
		} );
		ScrollPane panelDesplazable = new ScrollPane();
		panelDesplazable.add(areaSalida);
	    Container contenedor = getContentPane();
	    contenedor.add( titulo, BorderLayout.NORTH );
	    contenedor.add( panelDesplazable, BorderLayout.CENTER );
	    leerCompanyMaster();
		setVisible(true);
	}

	private void leerCompanyMaster() {
		try {
			ConexionAsknudev conUdev = ConexionAsknudev.getInstance(); 
			Statement stmt = conUdev.con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ACONDTSAO.ACAAREPF"); 
//			ResultSet rs = stmt.executeQuery("select * from ACONDSAO.ACAAREPF"); 
			while (rs.next()) { 
				areaSalida.append("         " + rs.getString(1));
				areaSalida.append("                   " + rs.getString(2) + "\n");
			}
			rs.close();
			stmt.close();
		}	catch(Exception ex) {
				System.out.println(ex);
				System.exit(0);
			}
	}

}
