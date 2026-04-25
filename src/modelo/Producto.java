package modelo;

public class Producto {
	// ATRIBUTO
	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	private String plataforma;
	private tipoProducto tipo;  

	public enum tipoProducto { // DECLARACIÓN DE UN ENUM
		VIDEOJUEGO, CONSOLA, ACCESORIO, PC;
	}

	// CONSTRUCTOR
	public Producto(String nombre, String descripcion, double precio, String plataforma, tipoProducto tipo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.plataforma = plataforma;
		this.tipo = tipo;
		
	}

	// GETTERS Y SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public tipoProducto getTipo() {
		return tipo;
	}

	public void setTipo(tipoProducto tipo) {
		this.tipo = tipo;
	}
	

}
