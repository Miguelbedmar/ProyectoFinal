package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Almacen;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Producto.tipoProducto;

public class ProductoDao {

	private Connection conexion;

	public ProductoDao() {
		conexion = Conexion.getInstance().getConexion();
	}

	public ArrayList<Producto> obtenerTodosProductos() throws SQLException {
		List<Producto> producto = new ArrayList<>();

		String sql = "SELECT * FROM Producto";

		try (PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				/*
				 * La linea 35 recoge un tipo string proveniente de la base de datos de
				 * categoria enum la linea 36 se encarga de buscar tipoProducto que es el nombre
				 * del enum , una vez que haya encontrado el enum este lo pasa por un value.Of
				 * que transforma el string a un valor de tipo enum.
				 */
				String tipoStr = rs.getString("tipo");
				tipoProducto tipo = tipoProducto.valueOf(tipoStr);
				Producto p = new Producto(rs.getString("nombre"), rs.getString("descripcion"), rs.getDouble("precio"),
						rs.getString("plataforma"), tipo);
				producto.add(p);

			}

		}
		return (ArrayList<Producto>) producto;

	}

	public ArrayList<Producto> buscarProducto(String nombre) throws SQLException {
		List<Producto> producto = new ArrayList<>();

		String sql = "SELECT * FROM Producto WHERE nombre LIKE ?";
		try (PreparedStatement ps = conexion.prepareStatement(sql);) {
			ps.setString(1, "%" + nombre + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String tipoStr = rs.getString("tipo");

				tipoProducto tipo = tipoProducto.valueOf(tipoStr);

				Producto p = new Producto(rs.getString("nombre"), rs.getString("descripcion"), rs.getDouble("precio"),
						rs.getString("plataforma"), tipo);
				producto.add(p);
			}
		}

		return (ArrayList<Producto>) producto;
	}

	public void realizarCompra(DetalleVenta detalleVenta, Almacen almacen) throws SQLException {

		String sql = "INSERT INTO Venta (fecha_venta,id_cliente,id_tienda) VALUES (?,?,?)";

		try (PreparedStatement ps = conexion.prepareStatement(sql);) {

			ps.setDate(1, new java.sql.Date(detalleVenta.getVenta().getFechaVenta().getTime()));
			ps.setInt(2, detalleVenta.getVenta().getCliente().getIdCliente());
			ps.setInt(3, detalleVenta.getVenta().getTienda().getId());

			ps.executeUpdate();

		}
		String sql2 = "INSERT INTO Detalle_Venta (id_venta,id_producto,precio_unidad,cantidad) VALUES (?,?,?,?)";

		try (PreparedStatement ps2 = conexion.prepareStatement(sql2);) {

			for (Producto p : detalleVenta.getProducto()) {
				ps2.setInt(1, detalleVenta.getVenta().getIdVenta());
				ps2.setInt(2, p.getId());
				ps2.setDouble(3, detalleVenta.getPrecioUnidad());
				ps2.setInt(4, detalleVenta.getCantidad());
				ps2.executeUpdate();
			}
		}

		String sql3 = "UPDATE Almacen SET stock_almacen=stock_almacen - ?" + "WHERE id_producto= ? AND id_tienda =?";

		try (PreparedStatement ps3 = conexion.prepareStatement(sql3);) {
			for (Producto p : detalleVenta.getProducto()) {
				ps3.setInt(1,detalleVenta.getCantidad());
				ps3.setInt(2, p.getId());
				ps3.setInt(3, detalleVenta.getVenta().getTienda().getId());
				ps3.executeUpdate();
			}
		}

	}

}
