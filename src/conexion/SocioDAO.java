package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Socio;

public class SocioDAO {

	private Connection conexion;

	public SocioDAO() {
		conexion = Conexion.getInstance().getConexion();
	}

	public void registrarSocio(Socio socio) throws SQLException {
		String sql = "INSERT INTO Socio (punto_game,fecha_registro)VALUES (?,?)";

		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			ps.setInt(1, socio.getPuntoGame());
			ps.setDate(2, new java.sql.Date(socio.getFechaRegistro().getTime()));
			ps.executeUpdate();
		}
	}

	public ArrayList<Socio> obtenerTodoSocios() throws SQLException {
		List<Socio> socio = new ArrayList<>();
		String sql = "SELECT s.*,c.* FROM Socio s" + " INNER JOIN Cliente c ON s.id_socio = c.id_socio";

		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Socio s = new Socio(
						rs.getInt("id_socio"),
						rs.getInt("id_cliente"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("telefono"),
						rs.getString("email"),
						rs.getString("ciudad"),
						rs.getBoolean("es_socio"),
						rs.getString("contrasenia"),
						rs.getInt("punto_game"),
						rs.getDate("fecha_nacimiento"),
						rs.getDate("fecha_registro")
											
						);
				
				
				
				socio.add(s);
			}
		}

		return (ArrayList<Socio>) socio;

	}

}
