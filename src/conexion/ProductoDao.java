package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;

public class ProductoDao {

	private Connection conexion;

	public ProductoDao() {
		conexion = Conexion.getInstance().getConexion();
	}

	public ArrayList<Producto> obtenerTodosProductos() throws SQLException {
		List<Producto> producto = new ArrayList<>();

		String sql = "SELECT * FROM Producto";

		try (PreparedStatement ps = conexion.prepareStatement(sql); 
				ResultSet rs = ps.executeQuery()) {
		
			while (rs.next()) {
			String tipoStr=rs.getString("tipo");
			tipoProducto tipo= tipoProducto.valueOf(tipoStr);
			Producto p=new Producto(
				rs.getString("nombre"),
				rs.getString("descripcion"),	
				rs.getDouble("precio"),
				rs.getString("plataforma"),
				tipo,					
					);	
			producto.add(p);
			
			}

		}
		return (ArrayList<Producto>)producto;

	}

}
