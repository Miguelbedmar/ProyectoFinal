package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import conexion.ClienteDao;
import modelo.Cliente;

public class VistaGestionClientes extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;

    public VistaGestionClientes() {
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Gestión de Clientes", SwingConstants.CENTER);
        add(lblTitulo, BorderLayout.NORTH);

        String[] columnas = { "ID", "Nombre", "Apellido", "Telefono", "Email", "Ciudad", "Socio", "Rol" };
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JButton btnEliminar = new JButton("Eliminar Cliente Seleccionado");
        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar este cliente?");
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Cliente eliminado");
                    modelo.removeRow(fila);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un cliente primero");
            }
        });
        add(btnEliminar, BorderLayout.SOUTH);

        cargarDatos();
    }

    private void cargarDatos() {
        modelo.setRowCount(0);
        try {
            ClienteDao cD = new ClienteDao();
            ArrayList<Cliente> lista = cD.obtenerTodosClientes();
            for (Cliente c : lista) {
                modelo.addRow(new Object[] {
                    c.getIdCliente(),
                    c.getNombre(),
                    c.getApellido(),
                    c.getTelefono(),
                    c.getEmail(),
                    c.getCiudad(),
                    c.isEsSocio(),
                    c.getRolUsuario()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
