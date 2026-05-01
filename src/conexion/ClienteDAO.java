package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;

public class ClienteDao {

	private Connection conexion;

	public ClienteDao() {
		conexion = Conexion.getInstance().getConexion();
	}

	public Cliente login(String email, String contrasenia) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE email = ? AND contrasenia = ?";
		try (PreparedStatement ps = conexion.prepareStatement(sql)) {

			ps.setString(1, email);
			ps.setString(2, contrasenia);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("telefono"), rs.getString("email"), rs.getString("ciudad"),
						rs.getBoolean("es_socio"), rs.getInt("id_socio"), rs.getString("contrasenia"),
						rs.getDate("fecha_nacimiento")

				);
			}
		}

		return null;
	}

	public void registroNuevoCliente(Cliente cliente) throws SQLException {

		String sql = "INSERT INTO Cliente (nombre,apellido,contrasenia,telefono,email,ciudad,es_socio,fecha_nacimiento) VALUES (?,?,?,?,?,?,?,?) ";

		try (PreparedStatement ps = conexion.prepareStatement(sql)) {

			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getContrasenia());
			ps.setString(4, cliente.getTelefono());
			ps.setString(5, cliente.getEmail());
			ps.setString(6, cliente.getCiudad());
			ps.setBoolean(7, false);
			ps.setDate(8, new java.sql.Date(cliente.getFechaNacimiento().getTime()));

			ps.executeUpdate();
		}
	}
}
