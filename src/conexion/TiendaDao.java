package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Almacen;
import modelo.Tienda;

public class TiendaDao {

	private Connection conexion;

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
		
		
		String sql1="";
		try(PreparedStatement ps = conexion.prepareStatement(sql1)){
			
		}

		return (ArrayList<Almacen>) almacen;
	}

}
