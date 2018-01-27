package cl.comp.inspeccion.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.inject.Singleton;

/*
 * Clase encargada de realizar la conexion con el datasource
 */

@Singleton
public class DataSourceFactory {
	public static Connection getConnection() {
		Connection con = null;
		try {
			String connectionUrl = "jdbc:mariadb://localhost:8889/db";
			// Establish the connection.
			
			try {
				Class.forName("org.mariadb.jdbc.Driver").newInstance();
			} catch (ClassNotFoundException ex) {
			    System.out.println("Error al registrar el driver de mariadb: " + ex);
			}
			con = DriverManager.getConnection(connectionUrl, "","");
			System.out.println("Abri� conexi�n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
				System.out.println("Cerr� conexi�n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
		return con;
	}
}
