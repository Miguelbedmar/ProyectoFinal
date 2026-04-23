package modelo;

import java.util.ArrayList;
import java.util.Date;

public class DetalleVenta extends Venta {
	// ATRIBUTO
	private int idDV;
	private ArrayList<Producto> producto;
	private double precioUnidad;
	private int cantidad;

	// CONSTRUCTOR
	public DetalleVenta(Date fechaVenta, Cliente cliente, Tienda tienda, ArrayList<Producto> producto,
			double precioUnidad, int cantidad) {
		super(fechaVenta, cliente, tienda);

		this.producto = producto;
		this.precioUnidad = precioUnidad;
		this.cantidad = cantidad;
	}

	// GETTERS Y SETTERS

	public int getIdDV() {
		return idDV;
	}

	public void setIdDV(int idDV) {
		this.idDV = idDV;
	}

	public ArrayList<Producto> getProducto() {
		return producto;
	}

	public void setProducto(ArrayList<Producto> producto) {
		this.producto = producto;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
