package JUnit_UD21.UD21_MVC;

import Controller.Controlador;
import Modelo.Modelo;
import Modelo.SQL;
import Vista.Vista;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SQL sql = new SQL();
		sql.Connect();
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo, vista);
		controlador.iniciarVista();
	}
}
