package modelo;

import java.util.Date;

public class Socio extends Cliente {

	private int idSocio;
	private int puntoGame;
	private Date fechaRegistro;

	public Socio(int idSocio, int idCliente, String nombre, String apellido, String telefono, String email,
			String ciudad, boolean esSocio, String contrasenia, int puntoGame, Date fechaNacimiento,rol usuario,
			Date fechaRegistro) {
		super(idCliente, nombre, apellido, telefono, email, ciudad, esSocio, idSocio, contrasenia, fechaNacimiento,usuario);
		this.idSocio = idSocio;
		this.puntoGame = puntoGame;
		this.fechaRegistro = fechaRegistro;

	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public int getPuntoGame() {
		return puntoGame;
	}

	public void setPuntoGame(int puntoGame) {
		this.puntoGame = puntoGame;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public String toString() {
		return "Socio [idSocio=" + idSocio + ", puntoGame=" + puntoGame + ", fechaRegistro=" + fechaRegistro + "]";
	}

}