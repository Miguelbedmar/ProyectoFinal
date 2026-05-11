package vista;

import java.awt.*;
import java.util.Date;
import javax.swing.*;
import conexion.ProductoDao;
import conexion.TiendaDao;
import modelo.Almacen;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Tienda;
import modelo.Venta;
import java.util.ArrayList;

public class VistaCompra extends JPanel {

    private Cliente clienteActual;
    private JComboBox<Producto> cmbProductos;
    private JComboBox<Tienda> cmbTiendas;
    private JSpinner spnCantidad;

    public VistaCompra(Cliente clienteActual) {
        this.clienteActual = clienteActual;
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(5, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createTitledBorder("Realizar Compra"));

        cmbProductos = new JComboBox<>();
        cmbTiendas = new JComboBox<>();
        spnCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));

        cargarProductos();
        cargarTiendas();

        panelForm.add(new JLabel("Producto:")); panelForm.add(cmbProductos);
        panelForm.add(new JLabel("Tienda:")); panelForm.add(cmbTiendas);
        panelForm.add(new JLabel("Cantidad:")); panelForm.add(spnCantidad);

        JButton btnComprar = new JButton("Comprar");
        btnComprar.addActionListener(e -> realizarCompra());
        panelForm.add(new JLabel()); panelForm.add(btnComprar);

        add(panelForm, BorderLayout.CENTER);
    }

    private void cargarProductos() {
        try {
            ArrayList<Producto> lista = new ProductoDao().obtenerTodosProductos();
            for (Producto p : lista) cmbProductos.addItem(p);
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void cargarTiendas() {
        try {
            ArrayList<Tienda> lista = new TiendaDao().obtenerTodasTiendas();
            for (Tienda t : lista) cmbTiendas.addItem(t);
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void realizarCompra() {
        try {
            Producto productoSeleccionado = (Producto) cmbProductos.getSelectedItem();
            Tienda tiendaSeleccionada = (Tienda) cmbTiendas.getSelectedItem();
            int cantidad = (int) spnCantidad.getValue();

            Venta venta = new Venta(new Date(), clienteActual, tiendaSeleccionada);
            ArrayList<Producto> productos = new ArrayList<>();
            productos.add(productoSeleccionado);
            DetalleVenta detalle = new DetalleVenta(venta, productos, productoSeleccionado.getPrecio(), cantidad);
            Almacen almacen = new Almacen(productoSeleccionado, tiendaSeleccionada, cantidad);

            new ProductoDao().realizarCompra(detalle, almacen);
            JOptionPane.showMessageDialog(this, "¡Compra realizada con éxito!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al realizar la compra");
        }
    }
}
