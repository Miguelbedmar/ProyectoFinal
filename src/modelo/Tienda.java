package modelo;

public class Tienda {

	// ATRIBUTOS
	private int idT;
	private String ciudad;

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

}
