package com.softwarechido.app.basta.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BastaDAO {

	public final String SERVER = "jdbc:mysql://basta.cy5g8qjisfaw.us-east-1.rds.amazonaws.com:3306/basta";
	public final String USERNAME = "admin";
	public final String PASSWORD = "softwarechido1";

	public final String COLUMNAS = "nombre, apellido, florFruto, animal";
	public final String INSERTSTATEMENT = "INSERT INTO bastapartida VALUES (?,?,?,?,?)";

	protected Connection getConnection() {

		Connection result = null;

		try {
			// Cargamos el puente JDBC => DB
			System.out.println("Intentando cargar el conector...");
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Intentamos conectarnos a la base de Datos en este caso una base
			// llamada temp
			System.out.println("Conectando a la base...");
			result = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);
			System.out.println("Conexion a BD establecida");

		} catch (SQLException ex) {
			System.out.println(ex);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public void guardarJuego(BastaTO myBastaTO) {
		System.out.println("Guardando juego...");
		Connection conn = null;
		PreparedStatement sentencia=null;
		ResultSet resultSet = null;
		try {
			conn = getConnection();
			sentencia = conn.prepareStatement(INSERTSTATEMENT);
			sentencia.setString(1, myBastaTO.getLetra() + "");
			sentencia.setString(2, myBastaTO.getNombre());
			sentencia.setString(3, myBastaTO.getApellido());
			sentencia.setString(4, myBastaTO.getFlorFruto());
			sentencia.setString(5, myBastaTO.getAnimal());
			sentencia.executeUpdate();
			sentencia.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (resultSet != null) {
		        try {
		        	resultSet.close();
		        } catch (SQLException sqlEx) { } // ignore

		        resultSet = null;
		    }

		    if (sentencia != null) {
		        try {
		        	sentencia.close();
		        } catch (SQLException sqlEx) { } // ignore

		        sentencia = null;
		    }
		}
	}
}
