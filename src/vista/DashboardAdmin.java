package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import conexion.ClienteDao;
import conexion.ProductoDao;
import conexion.VentaDao;

public class DashboardAdmin extends JPanel {

	public DashboardAdmin() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		JLabel titulo = new JLabel("Panel de Control", SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		add(titulo);

		JPanel panelTarjetas = new JPanel(new GridLayout(1, 3, 20, 0));
		panelTarjetas.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

		panelTarjetas.add(crearTarjeta("CLIENTES TOTALES", ObtenerCliente(), new Color(52, 152, 219)));
	    panelTarjetas.add(crearTarjeta("PRODUCTOS", obtenerNumProductos(), new Color(46, 204, 113)));
	    panelTarjetas.add(crearTarjeta("VENTAS REALIZADAS", obtenerNumVentas(), new Color(231, 76, 60)));
		
		add(panelTarjetas);
		add(Box.createHorizontalGlue());
	}

	private JPanel crearTarjeta(String titulo, String valor, Color color) {
		JPanel tarjeta = new JPanel();
		tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
		tarjeta.setBackground(color);
		tarjeta.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel lblTitulo = new JLabel(titulo);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setAlignmentX(CENTER_ALIGNMENT);

		JLabel lblValor = new JLabel(valor);
		lblValor.setFont(new Font("Arial", Font.BOLD, 40));
		lblValor.setForeground(Color.WHITE);
		lblValor.setAlignmentX(CENTER_ALIGNMENT);
		
		
		tarjeta.add(Box.createVerticalGlue());
		tarjeta.add(lblTitulo);
		tarjeta.add(Box.createRigidArea(new Dimension(0, 10)));
		tarjeta.add(lblValor);
		tarjeta.add(Box.createVerticalGlue());

		return tarjeta;
	}

	private String ObtenerCliente() {
		try {
			ClienteDao dao = new ClienteDao();
			return String.valueOf(dao.contarClientes());
		} catch (SQLException e) {
			return "—";
		}

	}
	private String obtenerNumProductos() {
        try {
        	ProductoDao dao = new ProductoDao();
            return String.valueOf(dao.contarProductos()); 
        } catch (SQLException e) {
            return "—";
        }
    }

    private String obtenerNumVentas() {
        try {
            VentaDao dao = new VentaDao();
            return String.valueOf(dao.contarVentas()); 
        } catch (SQLException e) {
            return "—";
        }
    }
	

}
