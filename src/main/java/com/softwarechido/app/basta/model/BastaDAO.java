package com.softwarechido.app.basta.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BastaDAO {

	public final String SERVER = "jdbc:mysql://HOST-URL:1527/Basta";
	public final String USERNAME = "";
	public final String PASSWORD = "";

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

		PreparedStatement sentencia;
		String query = "";
		Connection conn = null;
		try {

			conn = getConnection();
			sentencia = conn.prepareStatement(INSERTSTATEMENT);

			System.out.println("DEBUG: Ejectuando query --> " + query);

			sentencia.setString(1, myBastaTO.getLetra() + "");
			System.out.println("DEBUG: Ejectuando query --> " + query);

			sentencia.setString(2, myBastaTO.getNombre());
			System.out.println("DEBUG: Ejectuando query --> " + query);
			sentencia.setString(3, myBastaTO.getApellido());

			sentencia.setString(4, myBastaTO.getFlorFruto());
			System.out.println("DEBUG: Ejectuando query --> " + query);
			sentencia.setString(5, myBastaTO.getAnimal());

			System.out.println("DEBUG: Ejectuando query --> " + query);

			sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//			
//			public UsuarioTO buscarUsuarioPorEmail(String email) {
	//
//				PreparedStatement sentencia;
//				String query = "";
//				Connection conn = null;
//				try {
//					conn = getConnection();
//					query = "select "+ COLUMNAS + " from Usuario where email =?";
//					System.out.println("ejectuando query --> "+query);
//					sentencia = conn.prepareStatement(query);
//					sentencia.setString(1, email);
//					ResultSet resultado = sentencia.executeQuery();
//					String id = null; String nombre = null; String contrasena = null; String nivel = null;
//					if (resultado.next() == true ){
//						id = resultado.getString("id");
//						nombre = resultado.getString("nombre");
//						contrasena = resultado.getString("contrasena");
//						nivel = resultado.getString("nivel");				
//					}
//					UsuarioTO myUsuario = new UsuarioTO();
//					myUsuario.setId(id);			
//					myUsuario.setNombre(nombre);
//					myUsuario.setContrasena(contrasena);
//					myUsuario.setNivel(Nivel.valueOf(nivel));
//					myUsuario.setEmail(email);
//					return myUsuario;						
//					
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//				}
//				finally{
//					try {
//						conn.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//				return null;
//			}
//		}
	//
	//
//			
//			
//			
//			
//			return myBastaTO; 
//			
//		}

}
