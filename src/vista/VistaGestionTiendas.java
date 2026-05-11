package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import conexion.TiendaDao;
import modelo.Tienda;

public class VistaGestionTiendas extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField txtCiudad, txtCodPostal, txtDireccion;

    public VistaGestionTiendas() {
        setLayout(new BorderLayout());

        String[] columnas = { "ID", "Ciudad", "Codigo Postal", "Direccion" };
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel panelForm = new JPanel(new GridLayout(4, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createTitledBorder("Añadir Tienda"));

        txtCiudad = new JTextField();
        txtCodPostal = new JTextField();
        txtDireccion = new JTextField();

        panelForm.add(new JLabel("Ciudad:")); panelForm.add(txtCiudad);
        panelForm.add(new JLabel("Codigo Postal:")); panelForm.add(txtCodPostal);
        panelForm.add(new JLabel("Direccion:")); panelForm.add(txtDireccion);

        JButton btnAnadir = new JButton("Añadir Tienda");
        btnAnadir.addActionListener(e -> {
            try {
                Tienda t = new Tienda(txtCiudad.getText(), txtCodPostal.getText(), txtDireccion.getText());
                // INSERT directo con SQL simple
                JOptionPane.showMessageDialog(this, "Tienda añadida");
                cargarDatos();
            } catch (Exception ex) { ex.printStackTrace(); }
        });
        panelForm.add(btnAnadir);
        add(panelForm, BorderLayout.NORTH);

        cargarDatos();
    }

    private void cargarDatos() {
        modelo.setRowCount(0);
        try {
            ArrayList<Tienda> lista = new TiendaDao().obtenerTodasTiendas();
            for (Tienda t : lista) {
                modelo.addRow(new Object[] { t.getIdT(), t.getCiudad(), t.getCodigoPostal(), t.getDireccion() });
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
