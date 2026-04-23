package modelo;

public class Tienda {

	// ATRIBUTOS
	private int id;
	private String ciudad;

	// CONSTRUCTOR
	public Tienda(String ciudad) {
		this.ciudad = ciudad;
	}

	// GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
