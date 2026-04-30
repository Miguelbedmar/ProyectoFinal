package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;

public class ClienteDAO {

	private Connection conexion;

	public ClienteDAO() {
		conexion = Conexion.getInstance().getConexion();
	}

	public Cliente login(String email, String contrasenia) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE email = ? AND contrasenia = ?";
		try (PreparedStatement ps = conexion.prepareStatement(sql) ) {
			
			ps.setString(1, email);
			ps.setString(2, contrasenia);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				return new Cliente(
						rs.getInt("id_cliente"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("telefono"),
						rs.getString("email"),
						rs.getString("ciudad"),
						rs.getBoolean("es_socio"),
						rs.getInt("id_socio"),
						rs.getString("contrasenia"),
						rs.getDate("fecha_nacimiento")
						
												
						);
			}
		}

		return null;
	}
}
