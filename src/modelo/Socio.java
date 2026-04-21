package modelo;

import java.util.Date;

public class Socio extends Cliente {

	private int idSocio;
	private int puntoGame;
	private Date fechaRegistro;

	public Socio(String nombre, String apellido, String ciudad, boolean esSocio, String telefono, String email,
			int puntoGame, Date fechaNacimiento,Date fechaRegistro) {
		super(nombre, apellido, telefono, email, ciudad, esSocio, fechaNacimiento);

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
	
	
	

}