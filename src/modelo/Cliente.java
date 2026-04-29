package modelo;

import java.util.Date;

public class Cliente {

	// ATRIBUTOS
	protected int idCliente;
	protected String nombre;
	protected String apellido;
	protected String telefono;
	protected String email;
	protected String ciudad;
	protected boolean esSocio;
	private int idSocio;
	private String contrasenia;
	protected Date fechaNacimiento;

	// CONSTRUCTOR

	public Cliente(String nombre, String apellido, String telefono, String email, String ciudad, boolean esSocio,
			Date fechaNacimiento) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.ciudad = ciudad;
		this.esSocio = esSocio;
		this.fechaNacimiento = fechaNacimiento;

	}

	// GETTERS Y SETTERS
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public boolean isEsSocio() {
		return esSocio;
	}

	public void setEsSocio(boolean esSocio) {
		this.esSocio = esSocio;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	

}
