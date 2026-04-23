package modelo;

import java.util.ArrayList;

public class Almacen {
	// ATRIBUTOS
	private int idAlmacen;
	private ArrayList<Producto> producto;
	private Tienda tienda;
	private int stockAlmacen;

	// CONSTRUCTOR
	public Almacen(ArrayList<Producto> producto, Tienda tienda, int stockAlmacen) {
		this.producto = producto;
		this.tienda = tienda;
		this.stockAlmacen = stockAlmacen;
	}
	// GETTERS Y SETTERS.

	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public ArrayList<Producto> getProducto() {
		return producto;
	}

	public void setProducto(ArrayList<Producto> producto) {
		this.producto = producto;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public int getStockAlmacen() {
		return stockAlmacen;
	}

	public void setStockAlmacen(int stockAlmacen) {
		this.stockAlmacen = stockAlmacen;
	}

}
