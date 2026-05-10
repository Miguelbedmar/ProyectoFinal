package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VistaRegistro extends JPanel implements ActionListener {
	// ATRIBUTOS OBLIGATORIOS (NOT NULL)
	private JTextField nombre;
	private JTextField email;
	private JTextField telefono;
	private JPasswordField contrasenia;
	
	// ATRIBUTOS OPCIONALES
	private JTextField apellido;
	private JTextField ciudad;
	private JTextField fechaNacimiento;
	
	//BOTONES
	private JButton registrarse;
	private JButton  volverAtras;
	
	public VistaRegistro() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
