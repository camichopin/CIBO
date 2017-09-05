package com.cibo.entity;

public class detalles_venta {
private int id;
private int idVenta;
private int idProducto;
private int cantidad; 


public detalles_venta(int id, int idProducto, int idVenta, int cantidad) {
	this.id = id;
	this.idVenta = idVenta;
	this.idProducto = idProducto;
	this.cantidad = cantidad;
	
}

public detalles_venta(int id) {
	this.id = id;
	
}

public detalles_venta(int idProducto, int idVenta, int cantidad){
	this.idProducto = idProducto;
	this.idVenta = idVenta;
	this.cantidad = cantidad;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getIdVenta() {
	return idVenta;
}

public void setIdVenta(int idVenta) {
	this.idVenta = idVenta;
}

public int getIdProducto() {
	return idProducto;
}

public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

@Override
public String toString() {
	return "detalles_venta [id=" + id + ", idVenta=" + idVenta + ", idProducto=" + idProducto + ", cantidad=" + cantidad
			+ "]";
}
}