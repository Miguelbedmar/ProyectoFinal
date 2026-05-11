package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import conexion.ProductoDao;
import modelo.Producto;

public class VistaCatalogo extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField txtBuscar;

    public VistaCatalogo() {
        setLayout(new BorderLayout());

        // PANEL BUSQUEDA
        JPanel panelBusqueda = new JPanel(new FlowLayout());
        txtBuscar = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        JButton btnTodos = new JButton("Ver Todos");

        btnBuscar.addActionListener(e -> buscarProducto());
        btnTodos.addActionListener(e -> cargarDatos());

        panelBusqueda.add(new JLabel("Buscar:"));
        panelBusqueda.add(txtBuscar);
        panelBusqueda.add(btnBuscar);
        panelBusqueda.add(btnTodos);
        add(panelBusqueda, BorderLayout.NORTH);

        // TABLA
        String[] columnas = { "ID", "Nombre", "Descripcion", "Precio", "Plataforma", "Tipo" };
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        cargarDatos();
    }

    private void cargarDatos() {
        modelo.setRowCount(0);
        try {
            ArrayList<Producto> lista = new ProductoDao().obtenerTodosProductos();
            for (Producto p : lista) {
                modelo.addRow(new Object[] { p.getId(), p.getNombre(), p.getDescripcion(), p.getPrecio(), p.getPlataforma(), p.getTipo() });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buscarProducto() {
        modelo.setRowCount(0);
        try {
            ArrayList<Producto> lista = new ProductoDao().buscarProducto(txtBuscar.getText());
            for (Producto p : lista) {
                modelo.addRow(new Object[] { p.getId(), p.getNombre(), p.getDescripcion(), p.getPrecio(), p.getPlataforma(), p.getTipo() });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}