package kn.jb.AconNewDAO;

public class AsknudevFactoryDAO extends FactoryDAO {

	public MonedaDAO getMonedaDAO() {
		return new MonedaAsknudevFactoryDAO();
	}

}
