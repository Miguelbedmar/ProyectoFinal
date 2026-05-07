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

public class TiendaDao {

	private Connection conexion;
	
	public TiendaDao() {
		conexion = Conexion.getInstance().getConexion();
	}
	public ArrayList<Tienda> obtenerTodasTiendas() throws SQLException {

		List<Tienda> tienda = new ArrayList<>();

		String sql = "SELECT * FROM Tienda";

		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Tienda t = new Tienda(rs.getString("ciudad"), rs.getString("codigo_postal"), rs.getString("direccion"));

				t.setIdT(rs.getInt("id_tienda"));

				tienda.add(t);

			}
		}

		return (ArrayList<Tienda>) tienda;

	}

	public ArrayList<Almacen> obtenerStockTodasTiendas(int idT) throws SQLException {
		List<Almacen> almacen = new ArrayList<>();

		String sql1 = "SELECT a.*,p.*,t.* FROM Almacen " + " INNER JOIN Producto p ON a.id_producto = p.id_producto"
				+ " INNER JOIN Tienda t ON a.id_tienda=t.id_tienda" + " WHERE id_tienda=?";
		try (PreparedStatement ps = conexion.prepareStatement(sql1)) {
			ps.setInt(1, idT);
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

}
