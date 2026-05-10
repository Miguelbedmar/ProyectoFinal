package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import conexion.ClienteDao;
import modelo.Cliente;
import modelo.Cliente.rol;

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
		registrarse = new JButton("REGISTRARSE");
		volverAtras = new JButton("VOLVER ATRAS");
		formularioObligatorio();
		formularioOpcional();
		// BOTON REGISTRARSE
		registrarse.addActionListener(this);
		registrarse.setMaximumSize(new Dimension(200, 40));
		registrarse.setAlignmentX(CENTER_ALIGNMENT);
		add(registrarse);

		// BOTON VOLVER ATRAS
		volverAtras.addActionListener(this);
		volverAtras.setMaximumSize(new Dimension(200, 40));
		volverAtras.setAlignmentX(CENTER_ALIGNMENT);
		add(volverAtras);
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
		if (e.getSource() == registrarse) {
			Cliente c = null;
			try {
				java.sql.Date fecha = null;
				if (!fechaNacimiento.getText().isEmpty()) {
					fecha = java.sql.Date.valueOf(fechaNacimiento.getText());
				}
				 c = new Cliente(0, nombre.getText(), apellido.getText(), telefono.getText(), email.getText(),
							ciudad.getText(), false, 0, new String(contrasenia.getPassword()), fecha, rol.CLIENTE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Formato de fecha incorrecta .debe ser yyyy-MM-dd ");
				e1.printStackTrace();

			}
			if(c!=null) {
				ClienteDao cD = new ClienteDao();
				
				try {
					cD.registroNuevoCliente(c);
					JOptionPane.showMessageDialog(this, "!Registro completado !");
					/*DESPUES DE COMPLETAR EL REGISTRO DE MANERA EXITOSA 
					 * EL USUARIO SERÁ DEVUELTO AUTOMATICAMENTE AL LOGIN
					 * */
					JFrame jf=(JFrame) SwingUtilities.getWindowAncestor(this);
					jf.getContentPane().removeAll();
					jf.getContentPane().add(new LoginVista());
					jf.revalidate();
					jf.repaint();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "!E HA PRODUCIDO UN ERROR!");
				}
				
			}
			
		}
		if (e.getSource() == volverAtras) {
			JFrame lV = (JFrame) SwingUtilities.getWindowAncestor(this);
			lV.getContentPane().removeAll();
			lV.getContentPane().add(new LoginVista());
			lV.revalidate();
			lV.repaint();

		}
	}
}
