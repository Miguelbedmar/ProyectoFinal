package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;

import modelo.Cliente;

public class VistaCliente extends JPanel implements ActionListener {
	private Cliente clienteActual;
	private JPanel contenido;

	private JMenuItem catagoloProducto;
	private JMenuItem realizarCompra;
	private JMenuItem cerrarSesión;

	public VistaCliente(Cliente cliente) {
		this.clienteActual = cliente;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		/*
		 * CREO E INSTENCIO UN OBJETO DE TIPO JMENU QUE FORMA PARTE DE LAS LIBRERIAS
		 * SWING PARA LA IMPLEMENTACIÓN DE MENUS DESPLEGABLES. PRIMERO INSTANCIAMOS
		 * AÑADIMOS ACCIÓN.*
		 */

		JMenuBar barraMenu = new JMenuBar();

		JMenu catalogo = new JMenu("CATALOGO");
		catagoloProducto = new JMenuItem(" VER PRODUCTOS");
		catagoloProducto.addActionListener(this);
		catalogo.add(catagoloProducto);

		JMenu compra = new JMenu("COMPRA");
		realizarCompra = new JMenuItem("REALIZAR COMPRA");
		realizarCompra.addActionListener(this);
		compra.add(realizarCompra);

		JMenu finalizarSesion = new JMenu("CERAR SESION" + ":" + cliente.getNombre());
		cerrarSesión = new JMenuItem("CERAR SESION");
		cerrarSesión.addActionListener(this);
		finalizarSesion.add(cerrarSesión);

		barraMenu.add(catalogo);
		barraMenu.add(compra);
		barraMenu.add(Box.createHorizontalGlue()); // ALIENAMOS LOS ELEMENTOS A LA DERECHA.
		barraMenu.add(finalizarSesion);

		/**
		 * CREAMOS UN NUEVO JFRAME QUE ACTUARA COMO UN PANEL PADRE A LA HORA DE QUE SEA
		 * VISIBLE LA BARRA
		 */

		addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorAdded(javax.swing.event.AncestorEvent e) {
				JFrame ventanaPadre = (JFrame) SwingUtilities.getWindowAncestor(VistaCliente.this);
				if (ventanaPadre != null)
					ventanaPadre.setJMenuBar(barraMenu);
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent e) {
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub

			}

		});
		contenido = new VistaCatalogo();
		add(contenido);
	}

	private void verPanel(JPanel panel) {
		remove(contenido);
		contenido = panel;
		add(contenido);
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == catagoloProducto) {
			verPanel(new VistaCatalogo());
		}
		if (e.getSource() == realizarCompra) {
			verPanel(new VistaCompra());
		}
		if (e.getSource() == cerrarSesión) {
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
			frame.setJMenuBar(null);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new LoginVista());
			frame.revalidate();
			frame.repaint();
		}
	}
}
