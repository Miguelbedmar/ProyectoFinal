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
		String sql = "SELECT id_cliente FROM Cliente WHERE email = ? AND contrasenia = ?";
		try (PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			
			
		}

		return null;
	}
}
