package modelo;

import java.util.Date;

public class Venta {
	// ATRIBUTOS
	protected int idVenta;
	protected Date fechaVenta;
	protected Cliente cliente;
	protected Tienda tienda;

	// CONSTRUCTOR
	public Venta(Date fechaVenta, Cliente cliente, Tienda tienda) {
		this.fechaVenta = fechaVenta;
		this.cliente = cliente;
		this.tienda = tienda;
	}

	// GETTERS Y SETTERS
	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", fechaVenta=" + fechaVenta + ", cliente=" + cliente + ", tienda="
				+ tienda + "]";
	}

}
