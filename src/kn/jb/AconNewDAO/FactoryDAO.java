package kn.jb.AconNewDAO;

public abstract class FactoryDAO {
	
	public static final int ASKNUDEV_FACTORY = 1;
	public static final int ASKNP03_FACTORY = 2;
	
	public abstract MonedaDAO getMonedaDAO();
	
	public static FactoryDAO getFactory(int claveFactory){
        switch(claveFactory){
            case ASKNUDEV_FACTORY:
                return new AsknudevFactoryDAO();
            case ASKNP03_FACTORY:
                return new Asknp03FactoryDAO();
            default:
                throw new IllegalArgumentException();
        }
    }

}
