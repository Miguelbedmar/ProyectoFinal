package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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

	// BOTONES
	private JButton registrarse;
	private JButton volverAtras;

	public VistaRegistro() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		formularioObligatorio();
		formularioOpcional();
	}

	public void formularioObligatorio() {
		// NOMBRE
		JLabel nom = new JLabel("NOMBRE :");
		nombre = new JTextField();
		nombre.setMaximumSize(new Dimension(200, 40));
		nombre.setAlignmentX(CENTER_ALIGNMENT);
		add(nom);
		add(nombre);

		// EMAIL
		JLabel gmail = new JLabel("EMAIL:");
		email = new JTextField();
		email.setMaximumSize(new Dimension(200, 40));
		email.setAlignmentX(CENTER_ALIGNMENT);
		add(gmail);
		add(email);

		// TELEFONO
		JLabel tel = new JLabel("TELEFONO");
		telefono = new JTextField();
		telefono.setMaximumSize(new Dimension(200, 40));
		telefono.setAlignmentX(CENTER_ALIGNMENT);
		add(tel);
		add(telefono);
		// CONTRASENIA
		JLabel contra = new JLabel("CONTRASENIA");
		contrasenia = new JPasswordField();
		contrasenia.setMaximumSize(new Dimension(200, 40));
		contrasenia.setAlignmentX(CENTER_ALIGNMENT);
		add(contra);
		add(contrasenia);

	}

	public void formularioOpcional() {
		// APELLIDO.
		JLabel ape = new JLabel("APELLIDO : ");
		apellido = new JTextField();
		apellido.setMaximumSize(new Dimension(200, 40));
		apellido.setAlignmentX(CENTER_ALIGNMENT);
		add(ape);
		add(apellido);
		// CIUDAD.
		JLabel ciu = new JLabel("CIUDAD :");
		ciudad = new JTextField();
		ciudad.setMaximumSize(new Dimension(200, 40));
		ciudad.setAlignmentX(CENTER_ALIGNMENT);
		add(ciu);
		add(ciudad);
		// FECHA DE NACIMIENTO.
		JLabel feNa = new JLabel("FECHA NACIMIENTO :");
		fechaNacimiento = new JTextField();
		fechaNacimiento.setMaximumSize(new Dimension(200, 40));
		fechaNacimiento.setAlignmentX(CENTER_ALIGNMENT);
		add(feNa);
		add(fechaNacimiento);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
