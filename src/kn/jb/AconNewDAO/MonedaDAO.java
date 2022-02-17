package kn.jb.AconNewDAO;

import java.sql.SQLException;
import java.util.List;

public interface MonedaDAO {

	List<Moneda> getMoneda(String code) throws SQLException;
	void setMoneda(Moneda moneda);
	void changeMoneda(Moneda moneda);
	
}
