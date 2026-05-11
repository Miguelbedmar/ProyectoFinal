package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDao {

	private Connection conexion;

	public VentaDao() {
		conexion = Conexion.getInstance().getConexion();
	}

	public int contarVentas() throws SQLException {
		String sql = "SELECT COUNT(*) FROM Venta";
		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			return rs.next() ? rs.getInt(1) : 0;
		}
	}
}
