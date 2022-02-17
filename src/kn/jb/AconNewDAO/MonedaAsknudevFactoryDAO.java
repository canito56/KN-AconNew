package kn.jb.AconNewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kn.jb.ConexionesAs400.ConexionAsknudev;

public class MonedaAsknudevFactoryDAO implements MonedaDAO {
	
	private PreparedStatement stmt;

	public List<Moneda> getMoneda(String code) throws SQLException {
		
		String sql = null;
		List<Moneda> ltc = new ArrayList<>();

		if (code == null) {
			sql = "SELECT cucode, cudesc, cudecp, cuuniw, cudesw " +
					 "FROM agus562.accurrpf " +
					 "ORDER BY cucode";
		} else {
			sql = "SELECT cucode, cudesc, cudecp, cuuniw, cudesw " +
					 "FROM agus562.accurrpf " +
					 "WHERE cucode = ?";
		}

		try {
			ConexionAsknudev conUdev = ConexionAsknudev.getInstance(); 
			stmt = conUdev.con.prepareStatement(sql);
			if (code != null) {
				stmt.setString(1, code);
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String cbcd = rs.getString(1);
				String cstx = rs.getString(2);
				String cunb = rs.getString(3);
				String agna = rs.getString(4);
				String ahna = rs.getString(5);
				Moneda tc = new Moneda(cbcd, cstx, cunb, agna, ahna);
				ltc.add(tc);
			}
			rs.close();
			stmt.close();
		} catch(Exception ex) {
			System.out.println(ex);
			System.exit(0);
		}
		
		return ltc;		
	}

	public void setMoneda(Moneda moneda) {
	}

	public void changeMoneda(Moneda moneda) {
	}

}
