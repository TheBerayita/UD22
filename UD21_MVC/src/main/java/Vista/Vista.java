package Vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista extends JFrame {

	private JPanel panelR, panelB;
	public JButton insertar;
	public JButton borrar;
	public JButton select;
	public JButton update;
	public JLabel respuesta;
	public JTextField texto;

	public Vista() {
		getContentPane().setLayout(new BorderLayout());

		panelB = new JPanel();
		panelB.setLayout(new FlowLayout());

		panelR = new JPanel();
		panelR.setLayout(new FlowLayout());

		insertar = new JButton("Insertar");
		borrar = new JButton("Borrar");
		select = new JButton("Select");
		update = new JButton("Update");

		respuesta = new JLabel ("Respuesta: ");
		texto = new JTextField();
		
		panelB.add(insertar);
		panelB.add(borrar);
		panelB.add(select);
		panelB.add(update);
		
		panelR.add(texto);
		panelR.add(respuesta);

		add(texto, BorderLayout.NORTH);
		add(panelB, BorderLayout.SOUTH);
		add(panelR, BorderLayout.CENTER);
	}

}
