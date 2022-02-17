package kn.jb.AconNewClases;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CrearVentana extends JPanel {

	private static final long serialVersionUID = 1L;
	private boolean ALLOW_ROW_SELECTION = false;
	private JFrame frame;
	
	public CrearVentana(String titulo, int locX, int locY, JTable table) {		
		frame = new JFrame(titulo);
		frame.setLocation(locX, locY);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
	}
	
	public void setDisplay() {
		setVisible(true);
        setOpaque(true);
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
	}

	public void setALLOW_ROW_SELECTION(boolean aLLOW_ROW_SELECTION) {
		ALLOW_ROW_SELECTION = aLLOW_ROW_SELECTION;
	}

	public boolean isALLOW_ROW_SELECTION() {
		return ALLOW_ROW_SELECTION;
	}

}
