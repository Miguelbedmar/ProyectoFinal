package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	/*
	 * Esta clase utliza el patrón singleton para evitar que una clase tenga más de
	 * una instancia de conexion a la base de datos de toda la app .Si existe dicha
	 * conexion el metodo getInstance te devuelve esa conexion y en caso de que la
	 * conexion sea igual a null la crea */

	private static Conexion instancia = null;
	private Connection conexion = null;

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	// direcci�n de la BBDD MySQL
	private static final String URL = "jdbc:mysql://localhost:3306/Game";
	// usuario y contrase�a de acceso a la BD
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";

	private Conexion() {
		try {
			Class.forName(DRIVER);
				conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			System.out.println("Conexion OK");

		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error en la conexi�n");
			e.printStackTrace();
		}

	}

	public static Conexion getInstance() {
		if (instancia == null) {
			instancia = new Conexion();
		}

		return instancia;

	}

	public Connection getConexion() {
		return conexion;
	}

}
