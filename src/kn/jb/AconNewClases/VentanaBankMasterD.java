package kn.jb.AconNewClases;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import kn.jb.ConexionesAs400.*;

public class VentanaBankMasterD extends JPanel {

	private static final long serialVersionUID = 7526472295622776147L;
	private Object[][] data = new Object[1][6];
	private String company;
	private String bankCode;
	
	public VentanaBankMasterD(String comp, String banCod) {

		company = comp;
		bankCode = banCod;
		JFrame frame = new JFrame("BANK MASTER Detail"); 
        frame.setLocation(400, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        leerBankMaster();
        final MyTableModel tm = new MyTableModel();
        JTable table = new JTable(tm); 
        table.setPreferredScrollableViewportSize(new Dimension(800, 17));
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(1);
        table.getColumnModel().getColumn(1).setPreferredWidth(1);
        table.getColumnModel().getColumn(4).setPreferredWidth(1);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);               
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
		setVisible(true);
        setOpaque(true);
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);

	}

	private void leerBankMaster() {
		
		try {
			ConexionAsknudev conUdev = ConexionAsknudev.getInstance(); 
			Statement stmt = conUdev.con.createStatement();
			ResultSet rs = stmt.executeQuery("select ampdcd, amcdcd, amcfcd, ampzcd, amp0cd, amexst " +
											 "from ACONDTSAO.ACAMREPF " +
//											 "from ACONDSAO.ACAMREPF " +
											 "where ampdcd = '" + company.trim() + "'" +
											 " and  amcdcd = '" + bankCode.trim() + "'"); 
			while (rs.next()) {
				if (rs.getString(1).equals(company.trim()) && rs.getString(2).equals(bankCode.trim())) {
					data [0][0] = rs.getString(1);
					data [0][1] = rs.getString(2);
					data [0][2] = rs.getString(3);
					data [0][3] = rs.getString(4);
					data [0][4] = rs.getString(5);
					data [0][5] = rs.getString(6);
				}
			}
			rs.close();
			stmt.close();
		}	catch(Exception ex) {
				System.out.println(ex);
				System.exit(0);
			}			
		
	}
	
	class MyTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		private String[] columnNames = {"Company Code",
                                        "Bank Code",
                                        "Bank Branch",
                                        "Natural A/C",
                                        "Sub A/C",
										"Allow Computer Cheq"};

		public int getColumnCount() {
            return columnNames.length;
        }
 
        public int getRowCount() {
            return data.length;
        }
 
        public String getColumnName(int col) {
            return columnNames[col];
        }
 
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        
	}
	
}
