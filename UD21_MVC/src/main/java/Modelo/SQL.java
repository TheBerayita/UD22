package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SQL {
	private static Connection conexion;

	public Connection getConexion() {
		return conexion;
	}

	// Metodo para abrir la conexion
	public void Connect() {
		try {
			
			String password = "123456";
			String usuario = "root";
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC","root" ,"123456");
			System.out.println("Servidor conectado.");
			
		} catch (SQLException ex) {

			System.out.println("No se pudo conectar con la BD.");
			System.out.println(ex);

		}

	}

	// Metodo para cerrar la conexion
	public void cerrarConnec() {
		try {
			conexion.close();
			System.out.println("Conexión finalizada.");

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error, cerrando conexión.");

		}
	}

	public String manipularBD(String nombre, String accion, String query) {
		try {
			String QueryDB = "USE mvc_db;";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(QueryDB);
			Statement st = conexion.createStatement();
			System.out.println(query);
			st.executeUpdate(query);
			return ("Datos " + nombre + " correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
			return ("Error al " + accion + " datos");
			
		}
	}

	public String Select(String accion, String query) {
		String resultado = "";

		try {
			String sql = "Select * from persona";
			String QueryDB = "USE mvc_db";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(QueryDB);
			Statement stdb2 = conexion.createStatement();
			ResultSet res = stdb2.executeQuery(sql);
			while (res.next()) {
				resultado += res.getString("id") + " ";
				resultado += res.getString("nombre") + " ";
				resultado += res.getString("edad") + " ";
				resultado += res.getString("profesion") + " ";
				resultado += res.getString("telefono") + " ";
			}
			res.close();
			return resultado;
		} catch (SQLException e) {
			System.out.println(e);
			return "Error al " + accion + " datos";
		}
	}
}
