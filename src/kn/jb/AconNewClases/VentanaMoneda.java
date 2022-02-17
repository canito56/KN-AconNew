package kn.jb.AconNewClases;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import kn.jb.AconNewDAO.Moneda;
import kn.jb.AconNewDAO.MonedaAsknudevFactoryDAO;

public class VentanaMoneda {
	
	private JTable table;
	
	public VentanaMoneda() {
		
		String code = null;
		MonedaAsknudevFactoryDAO mafDAO = new MonedaAsknudevFactoryDAO();
		List<Moneda> ltc = null;
		
		try {
			ltc = mafDAO.getMoneda(code);
			DefaultTableModel dtm = new DefaultTableModel();
			dtm.setColumnIdentifiers(new String[]{"Currency Code", "Description", "Decimal Place", "Unit in Word", "Decimal in Word"});
			for (Moneda m : ltc) {
				dtm.addRow(new String[] {m.getCode(), m.getDesc(), m.getDecPlace(), m.getUnitWord(), m.getDecWord()});
			}
			table = new JTable(dtm);
	        table.setPreferredScrollableViewportSize(new Dimension(800, 500));
	        table.getColumnModel().getColumn(1).setPreferredWidth(150);
			CrearVentana ventana = new CrearVentana("CURRENCY CODE", 400, 150, table);
			ventana.setALLOW_ROW_SELECTION(false);
			ventana.setDisplay();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}

}
