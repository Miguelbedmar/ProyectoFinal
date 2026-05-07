package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Almacen;
import modelo.Producto;
import modelo.Tienda;
import modelo.Producto.tipoProducto;

public class AlmacenDao {
	private Connection conexion;

	public AlmacenDao() {
		conexion = Conexion.getInstance().getConexion();
	}

	public ArrayList<Almacen> obtenerTodosStock() throws SQLException {
		List<Almacen> almacen = new ArrayList<>();
		String sql = "SELECT a.*,p.*,t.* FROM Almacen a" + " INNER JOIN Producto p ON a.id_producto = p.id_producto"
				+ " INNER JOIN Tienda t ON a.id_tienda = t.id_tienda";
		try (PreparedStatement ps = conexion.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Almacen al = new Almacen(null, null, rs.getInt("stock_almacen"));

				al.setIdAlmacen(rs.getInt("id_almacen"));
				String tipoStr = rs.getString("tipo");
				tipoProducto tipo = tipoProducto.valueOf(tipoStr);

				Producto p = new Producto(rs.getString("nombre"), rs.getString("descripcion"), rs.getDouble("precio"),
						rs.getString("plataforma"), tipo);
				al.setProducto(p);

				Tienda t = new Tienda(rs.getString("ciudad"), rs.getString("codigo_postal"), rs.getString("direccion"));
				al.setTienda(t);
				almacen.add(al);
			}
		}

		return (ArrayList<Almacen>) almacen;
	}

	public void actualizarStock(Almacen almacen) throws SQLException {
		String sql = "UPDATE Almacen SET stock_almacen = ?  WHERE id_almacen = ?";

		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			ps.setInt(1, almacen.getStockAlmacen());
			ps.setInt(2, almacen.getIdAlmacen());
	
			ps.executeUpdate();
		}

	}
}
