package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conexion.ClienteDao;
import modelo.Cliente;

public class LoginVista extends JPanel implements ActionListener {

	private JButton continuar;
	private JButton cancelar;
	private JTextField texto;
	private JPasswordField contrasenia;
	/*
	 * PARA EVITAR QUE LA CONTRASEÑIA DEL USUARIO SEA VISIBLE SE UTILIZARA UNA
	 * SUBCLASE QUE HEREDA DE TEXTFIELD, DEMONINADA JPASSWORDFIELD QUE ENMASCARA LOS
	 * CARACTERES EN PUNTOS O ASTERISCOS,MANEJANDO EL TEXTO CON CHAR[].
	 */

	public LoginVista() {
		setLayout(new GridLayout(3, 2, 10, 10));
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel usua = new JLabel("Usuario:");
		texto = new JTextField();

		JLabel contrasen = new JLabel("Contrañia");
		contrasenia = new JPasswordField();

		continuar = new JButton("Iniciar Sesión");
		cancelar = new JButton("Cancelar");

		add(usua);
		add(texto);

		add(contrasen);
		add(contrasenia);

		continuar.addActionListener(this);
		add(continuar);
		cancelar.addActionListener(this);
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
			if(cliente !=null) {	
				if (cliente.getRolUsuario().equals("ADMIN")) {

				} else {

				}
			}else {
			JOptionPane.showMessageDialog(this, "Email o contraseñia incorrectos");
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == cancelar) {
			System.exit(0);

		}

	}

}
