package kn.jb.AconNewClases;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import kn.jb.ConexionesAs400.*;

public class VentanaBankMaster extends JPanel {
	
	private static final long serialVersionUID = 7526472295622776147L;
	private boolean ALLOW_ROW_SELECTION = true;
	private String company;
	private String bankCode;
	private Object[][] data = new Object[150][5];
	private int linea = 0;
	
	public VentanaBankMaster() {
		
		JFrame frame = new JFrame("BANK MASTER");
        frame.setLocation(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        leerBankMaster();
        data = new Object[linea][5];
        leerBankMaster();
        final MyTableModel tm = new MyTableModel();
        JTable table = new JTable(tm); 
        table.setPreferredScrollableViewportSize(new Dimension(1000, 500));
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(1);
        table.getColumnModel().getColumn(1).setPreferredWidth(1);
        table.getColumnModel().getColumn(4).setPreferredWidth(1);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        if (ALLOW_ROW_SELECTION) { 
            ListSelectionModel rowSM = table.getSelectionModel();
            rowSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (e.getValueIsAdjusting()) return; 
                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        System.out.println("No rows are selected.");
                    } else {
                        int selectedRow = lsm.getMinSelectionIndex();
                        System.out.println("Row " + selectedRow
                                           + " is now selected.");
                        if (selectedRow < linea) { 
                        	company = tm.getValueAt(selectedRow, 0).toString();
                        	bankCode = tm.getValueAt(selectedRow, 1).toString();
                        	new VentanaBankMasterD(company, bankCode);
                        }
                    }
                }
            });
        } else {
            table.setRowSelectionAllowed(false);
        }
        
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
			linea = 0;
			ConexionAsknudev conUdev = ConexionAsknudev.getInstance(); 
			Statement stmt = conUdev.con.createStatement();
			ResultSet rs = stmt.executeQuery("select ampdcd, amcdcd, amartx, amcecd, amcbcd " +
											 "from ACONDTSAO.ACAMREPF " +
//											 "from ACONDSAO.ACAMREPF " +
											 "order by ampdcd, amcdcd");
			while (rs.next()) {
				data [linea][0] = rs.getString(1);
				data [linea][1] = rs.getString(2);
				data [linea][2] = rs.getString(3);
				data [linea][3] = rs.getString(4);
				data [linea][4] = rs.getString(5);
				linea = linea + 1; 
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
                                        "Bank Name",
                                        "Bank Account",
                                        "Currency Code"};

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
