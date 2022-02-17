package kn.jb.ConexionesAs400;

import java.sql.*;

public class ConexionAsknudev {
	
	private static ConexionAsknudev conAsknudev;
	public Connection con = null;
	
	private ConexionAsknudev() {
		try {
			Class.forName("com.ibm.as400.access.AS400JDBCDriver");
			con = DriverManager.getConnection("jdbc:as400://pub400.com", "AGUS56", "milanga01");
//			con = DriverManager.getConnection("jdbc:as400://asknudev.int.kn", "BUERFIAJB", "MILANGA02");
//			con = DriverManager.getConnection("jdbc:as400://asknp03.us.int.kn", "BUERFIAJB", "MILANGA02");
		} 	catch(ClassNotFoundException e) { 
				System.out.println(e);
				System.exit(0);
		  	}
			catch(Exception ex) {
				System.out.println(ex);
				System.exit(0);
			}
	}
	
	public static ConexionAsknudev getInstance() {
		if (conAsknudev == null) {
			conAsknudev = new ConexionAsknudev();
		}
		return conAsknudev;
	}
	
	public void desconexionAsknudev() {
		try {
			con.close(); 
		}	catch(Exception ex) {
				System.out.println(ex);
				System.exit(0);
			}
	}

}
