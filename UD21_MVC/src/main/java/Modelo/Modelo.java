package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo {
	// Atributos
	private String query;
	private String respuesta;
		
	public void setQuery(String query) {
		this.query = query;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void insertarDatos() {

		SQL sql = new SQL();
		sql.Connect();

		respuesta = sql.manipularBD("insertados", "insertar", query);

		sql.cerrarConnec();
	}

	public void borrarDatos() {

		SQL sql = new SQL();
		sql.Connect();

		respuesta = sql.manipularBD("eliminados", "eliminar", query);

		sql.cerrarConnec();

	}

	public void actualizarDatos() {

		SQL sql = new SQL();
		sql.Connect();

		respuesta = sql.manipularBD("actualizados", "actualizar", query);

		sql.cerrarConnec();

	}
	
	public void select () {
		SQL sql = new SQL();
		sql.Connect();

		respuesta = sql.Select("seleccionar", query);
		System.out.println(respuesta);

		sql.cerrarConnec();
	}

}