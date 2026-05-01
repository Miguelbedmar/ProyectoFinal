package modelo;

public class Tienda {

	// ATRIBUTOS
	private int idT;
	private String ciudad;
	private String codigoPostal;
	private String direccion;

	// CONSTRUCTOR
	public Tienda(String ciudad) {
		this.ciudad = ciudad;
	}

	// GETTERS Y SETTERS
	public int getId() {
		return idT;
	}

	public void setId(int id) {
		this.idT = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getIdT() {
		return idT;
	}

	public void setIdT(int idT) {
		this.idT = idT;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Tienda [idT=" + idT + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + ", direccion="
				+ direccion + "]";
	}

	
}
