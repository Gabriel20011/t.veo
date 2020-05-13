package co.edu.unbosque.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private Connection conexion;

	public Connection ConectarBaseDeDatos() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/bbVSErCVGs", "bbVSErCVGs", "FXu8qmN5oE");
			} catch (Exception e) {
			System.out.println("Error de conexion" + e.getMessage());
		}

		return conexion;
	}
}

