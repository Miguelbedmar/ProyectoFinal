package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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

public class LoginVista extends JPanel implements ActionListener {

	private JButton continuar;
	private JButton cancelar;
	private JButton registro;
	private JTextField texto;
	private JPasswordField contrasenia;
	/*
	 * PARA EVITAR QUE LA CONTRASEÑIA DEL USUARIO SEA VISIBLE SE UTILIZARA UNA
	 * SUBCLASE QUE HEREDA DE TEXTFIELD, DEMONINADA JPASSWORDFIELD QUE ENMASCARA LOS
	 * CARACTERES EN PUNTOS O ASTERISCOS,MANEJANDO EL TEXTO CON CHAR[].
	 */

	public LoginVista() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		// ETIQUETA EMAIL
		JLabel usua = new JLabel("EMAIL:");

		texto = new JTextField();
		texto.setMaximumSize(new Dimension(300, 30));
		usua.setAlignmentX(CENTER_ALIGNMENT);
		// ETIQUETA CONTRASEÑIA
		JLabel contrasen = new JLabel("CONTRASEÑIA");
		contrasenia = new JPasswordField();
		contrasenia.setMaximumSize(new Dimension(300, 30));
		contrasen.setAlignmentX(CENTER_ALIGNMENT);
		continuar = new JButton("INICIAR SESIÓN");
		registro = new JButton("RESGISTRASE");
		cancelar = new JButton("SALIR");

		add(usua);
		add(texto);

		add(contrasen);
		add(contrasenia);
		// BOTON CONTINUAR
		continuar.addActionListener(this);
		continuar.setMaximumSize(new Dimension(200, 40));
		continuar.setAlignmentX(CENTER_ALIGNMENT);
		add(continuar);
		// BOTON RESGISTRO
		registro.addActionListener(this);
		registro.setMaximumSize(new Dimension(200, 40));
		registro.setAlignmentX(CENTER_ALIGNMENT);
		add(registro);
		// BOTON SALIR
		cancelar.addActionListener(this);
		cancelar.setAlignmentX(CENTER_ALIGNMENT);
		cancelar.setMaximumSize(new Dimension(200, 40));
		add(cancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == continuar) {
			ClienteDao cD = new ClienteDao();
			String email = texto.getText();
			String contrasen = new String(contrasenia.getPassword());
			try {
				Cliente cliente = cD.login(email, contrasen);
				if (cliente != null) {
					if (cliente.getRolUsuario().equals("ADMIN")) {
						JFrame admin = (JFrame) SwingUtilities.getWindowAncestor(this);
						admin.getContentPane().removeAll();
						admin.getContentPane().add(new VistaAdmin());
						admin.revalidate();
						admin.repaint();

					} else {
						JFrame clien = (JFrame) SwingUtilities.getWindowAncestor(this);
						clien.getContentPane().removeAll();
						clien.getContentPane().add(new VistaCliente());
						clien.revalidate();
						clien.repaint();

					}
				} else {
					JOptionPane.showMessageDialog(this, "Email o contraseñia incorrectos");
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this,"Se ha producido un error inesperado");
				e1.printStackTrace();
			}

		}
		if (e.getSource() == registro) {
			JFrame registro = (JFrame) SwingUtilities.getWindowAncestor(this);
			registro.getContentPane().removeAll();
			registro.getContentPane().add(new VistaRegistro());
			registro.revalidate();
			registro.repaint();
		}
		if (e.getSource() == cancelar) {
			System.exit(0);

		}

	}

}
