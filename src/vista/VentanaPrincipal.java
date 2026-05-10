package vista;



import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	LoginVista lV= new LoginVista();
	public VentanaPrincipal() {
		setTitle("Login ");
		setSize(500,700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(lV);
		setVisible(true);
	}
	
	
	

	
	
	
	
}
