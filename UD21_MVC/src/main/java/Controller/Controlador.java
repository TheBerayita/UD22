package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador{
	
	private Modelo modelo;
	private Vista vista;
	private String query;
	private String query2;

	public Controlador(Modelo modelo, Vista vista2) {
		this.modelo = modelo;
		this.vista = vista2;
		this.vista.borrar.addActionListener(accion);
		this.vista.insertar.addActionListener(accion);
		this.vista.select.addActionListener(accion);
		this.vista.update.addActionListener(accion);
	}

	public void iniciarVista() {
		vista.setTitle("SQL");
		vista.pack();
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}
 ActionListener accion = new ActionListener() {
	public void actionPerformed(ActionEvent e) {	
		query = vista.texto.getText();
		if (vista.insertar == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
			System.out.println("hola2");
				modelo.setQuery("insert into persona (id, nombre, edad, profesion, telefono) values (" + query + ");");
				modelo.insertarDatos();
				vista.respuesta.setText(modelo.getRespuesta());
			}
		} else if (vista.borrar == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
				modelo.setQuery("delete from persona " + query);
				modelo.borrarDatos();
				vista.respuesta.setText(modelo.getRespuesta());
			}
		} else if (vista.update == e.getSource()) {
            if (!"".equals(vista.texto.getText())) {
                query = vista.texto.getText();
                modelo.setQuery("update persona set " + query );
                modelo.actualizarDatos();
                vista.respuesta.setText(modelo.getRespuesta());
                
            }
        } else if (vista.select == e.getSource()) {
            if (!"".equals(vista.texto.getText())) {
                query = vista.texto.getText();
                modelo.setQuery(query );
                modelo.select();
                vista.respuesta.setText(modelo.getRespuesta());
            }
        }
	}
};
	
}
