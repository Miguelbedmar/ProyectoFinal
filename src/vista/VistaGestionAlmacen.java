package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import conexion.AlmacenDao;
import modelo.Almacen;

public class VistaGestionAlmacen extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JSpinner spnStock;

    public VistaGestionAlmacen() {
        setLayout(new BorderLayout());

        String[] columnas = { "ID Almacen", "Producto", "Tienda", "Stock" };
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel panelSur = new JPanel(new FlowLayout());
        spnStock = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1));
        JButton btnActualizar = new JButton("Actualizar Stock");

        btnActualizar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                try {
                    int idAlmacen = (int) modelo.getValueAt(fila, 0);
                    int nuevoStock = (int) spnStock.getValue();
                    Almacen al = new Almacen(null, null, nuevoStock);
                    al.setIdAlmacen(idAlmacen);
                    new AlmacenDao().actualizarStock(al);
                    JOptionPane.showMessageDialog(this, "Stock actualizado");
                    cargarDatos();
                } catch (Exception ex) { ex.printStackTrace(); }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una fila primero");
            }
        });

        panelSur.add(new JLabel("Nuevo Stock:"));
        panelSur.add(spnStock);
        panelSur.add(btnActualizar);
        add(panelSur, BorderLayout.SOUTH);

        cargarDatos();
    }

    private void cargarDatos() {
        modelo.setRowCount(0);
        try {
            ArrayList<Almacen> lista = new AlmacenDao().obtenerTodosStock();
            for (Almacen a : lista) {
                modelo.addRow(new Object[] {
                    a.getIdAlmacen(),
                    a.getProducto() != null ? a.getProducto().getNombre() : "N/A",
                    a.getTienda() != null ? a.getTienda().getCiudad() : "N/A",
                    a.getStockAlmacen()
                });
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}