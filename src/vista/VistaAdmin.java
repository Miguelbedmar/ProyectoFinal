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

public class VistaAdmin extends JPanel implements ActionListener {

	private Cliente adminActual;
	private JPanel contenido;
	// MENU
	private JMenuItem gestonionarProductos;
	private JMenuItem gestionarClientes;
	private JMenuItem verVentas;
	private JMenuItem gestionarAlmacen;
	private JMenuItem gestionarTiendas;
	private JMenuItem cerrarSesion;

	public VistaAdmin(Cliente admin) {
		this.adminActual = admin;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JMenuBar menu = new JMenuBar();

		JMenu menuProductos = new JMenu("GESTION PRODUCTOS");
		gestonionarProductos = new JMenuItem("Gestionar productos");
		gestonionarProductos.addActionListener(this);
		menuProductos.add(gestonionarProductos);

		JMenu menuClientes = new JMenu(" CLIENTES");
		gestionarClientes = new JMenuItem("Gestionar clientes");
		gestionarClientes.addActionListener(this);
		menuClientes.add(gestionarClientes);

		JMenu menuVentas = new JMenu("TODAS LAS VENTAS");
		verVentas = new JMenuItem("Ver ventas y estadísticas");
		verVentas.addActionListener(this);
		menuVentas.add(verVentas);

		JMenu menuAlmacen = new JMenu("TODOS LOS ALMACENES/TIENDAS");
		gestionarAlmacen = new JMenuItem("Gestionar almacén");
		gestionarTiendas = new JMenuItem("Gestionar tiendas");
		gestionarAlmacen.addActionListener(this);
		gestionarTiendas.addActionListener(this);
		menuAlmacen.add(gestionarAlmacen);
		menuAlmacen.add(gestionarTiendas);

		JMenu menuSesion = new JMenu("USUARIO ADMIN : " + admin.getNombre());
		cerrarSesion = new JMenuItem("Cerrar sesión");
		cerrarSesion.addActionListener(this);
		menuSesion.add(cerrarSesion);

		menu.add(menuProductos);
		menu.add(menuClientes);
		menu.add(menuVentas);
		menu.add(menuAlmacen);
		menu.add(Box.createHorizontalGlue());
		menu.add(menuSesion);

		addAncestorListener(new javax.swing.event.AncestorListener() {
			public void ancestorAdded(javax.swing.event.AncestorEvent e) {
				JFrame ventanaPadre = (JFrame) SwingUtilities.getWindowAncestor(VistaAdmin.this);
				if (ventanaPadre != null)
					ventanaPadre.setJMenuBar(menu);
			}

			public void ancestorRemoved(javax.swing.event.AncestorEvent e) {
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub

			}

		});
		contenido = new JPanel();
		contenido.add(new JLabel("PANEL DE ADMINISTRACION - BIENVENIDO/A" + admin.getNombre()));
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
		if (e.getSource() == gestonionarProductos) {
			verPanel(new  VistaGestionProductos());
		}
		if (e.getSource() == gestionarClientes) {
			verPanel(new  VistaGestionClientes());

		}
		if (e.getSource() == verVentas) {
			verPanel(new  VistaVentas());

		}
		if (e.getSource() == gestionarAlmacen) {
			verPanel(new  VistaGestionAlmacen());

		}
		if (e.getSource() == gestionarTiendas) {
			verPanel(new  VistaGestionTiendas());

		}
		if (e.getSource() == cerrarSesion) {
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
			frame.setJMenuBar(null);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new LoginVista());
			frame.revalidate();
			frame.repaint();
		}
	}
}
