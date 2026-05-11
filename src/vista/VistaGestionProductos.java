package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import conexion.ProductoDao;
import modelo.Producto;
import modelo.Producto.tipoProducto;

public class VistaGestionProductos extends JPanel {

	private JTable tabla;
	private DefaultTableModel modelo;
	
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtPlataforma;
	private JComboBox<tipoProducto> cmbTipo;

	public VistaGestionProductos() {
		setLayout(new BorderLayout());

		// TABLA
		String[] columnas = { "ID", "Nombre", "Precio", "Plataforma", "Tipo" };
		modelo = new DefaultTableModel(columnas, 0);
		tabla = new JTable(modelo);
		add(new JScrollPane(tabla), BorderLayout.CENTER);

		// PANEL FORMULARIO AÑADIR
		JPanel panelForm = new JPanel(new GridLayout(6, 2, 5, 5));
		panelForm.setBorder(BorderFactory.createTitledBorder("Añadir Producto"));

		txtNombre = new JTextField();
		txtDescripcion = new JTextField();
		txtPrecio = new JTextField();
		txtPlataforma = new JTextField();
		cmbTipo = new JComboBox<>(tipoProducto.values());

		panelForm.add(new JLabel("Nombre:"));
		panelForm.add(txtNombre);
		panelForm.add(new JLabel("Descripcion:"));
		panelForm.add(txtDescripcion);
		panelForm.add(new JLabel("Precio:"));
		panelForm.add(txtPrecio);
		panelForm.add(new JLabel("Plataforma:"));
		panelForm.add(txtPlataforma);
		panelForm.add(new JLabel("Tipo:"));
		panelForm.add(cmbTipo);

		JButton btnAnadir = new JButton("Añadir Producto");
		btnAnadir.addActionListener(e -> {
			try {
				Producto p = new Producto(txtNombre.getText(), txtDescripcion.getText(),
						Double.parseDouble(txtPrecio.getText()), txtPlataforma.getText(),
						(tipoProducto) cmbTipo.getSelectedItem());
				new ProductoDao().añadirProductos(p);
				JOptionPane.showMessageDialog(this, "Producto añadido con éxito");
				cargarDatos();
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error al añadir producto");
			}
		});
		panelForm.add(btnAnadir);
		add(panelForm, BorderLayout.NORTH);

		// BOTON ELIMINAR
		JButton btnEliminar = new JButton("Eliminar Producto Seleccionado");
		btnEliminar.addActionListener(e -> {
			int fila = tabla.getSelectedRow();
			if (fila != -1) {
				try {
					int id = (int) modelo.getValueAt(fila, 0);
					Producto p = new Producto(null, null, 0, null, null);
					p.setId(id);
					new ProductoDao().retirarProductos(p);
					JOptionPane.showMessageDialog(this, "Eliminado con éxito");
					cargarDatos();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Selecciona un producto primero");
			}
		});
		add(btnEliminar, BorderLayout.SOUTH);

		cargarDatos();
	}

	private void cargarDatos() {
		modelo.setRowCount(0);
		try {
			ArrayList<Producto> lista = new ProductoDao().obtenerTodosProductos();
			for (Producto p : lista) {
				modelo.addRow(new Object[] { p.getId(), p.getNombre(), p.getPrecio(), p.getPlataforma(), p.getTipo() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}