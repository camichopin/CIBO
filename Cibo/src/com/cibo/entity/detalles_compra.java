package com.cibo.entity;

public class detalles_compra {
private int id;
private int idProducto;
private int idCompra;
private int cantidad;

public detalles_compra(int id, int idProducto, int idCompra, int cantidad) {
	this.id = id;
	this.idProducto = idProducto;
	this.idCompra = idCompra;
	this.cantidad = cantidad;
}

public detalles_compra(int id) {
	this.id = id;
	
}

public int getId() {
	return id;
}

public detalles_compra(int idProducto, int idCompra, int cantidad) {

	this.idProducto = idProducto;
	this.idCompra = idCompra;
	this.cantidad = cantidad;
}



public void setId(int id) {
	this.id = id;
}

public int getIdProducto() {
	return idProducto;
}

public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}

public int getIdCompra() {
	return idCompra;
}

public void setIdCompra(int idCompra) {
	this.idCompra = idCompra;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

@Override
public String toString() {
	return "detalles_compra [id=" + id + ", idProducto=" + idProducto + ", idCompra=" + idCompra + ", cantidad="
			+ cantidad + "]";
}



}
