package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaVentas extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;

    public VistaVentas() {
        setLayout(new BorderLayout());

        String[] columnas = { "ID Venta", "Fecha", "Cliente", "Tienda" };
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JLabel lblInfo = new JLabel("Historial de ventas", SwingConstants.CENTER);
        add(lblInfo, BorderLayout.NORTH);
    }
}
