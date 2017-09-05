package com.cibo.entity;

public class productos {
private int id;
private String producto;
private double precioUnidad;
private int stock;
private int idCategoria;
private double costoUnidad;
private String color;
private String talla;

public productos(int id, String producto, double precioUnidad, int stock, int idCategoria, double costoUnidad,
		String color, String talla) {
	this.id = id;
	this.producto = producto;
	this.precioUnidad = precioUnidad;
	this.stock = stock;
	this.idCategoria = idCategoria;
	this.costoUnidad = costoUnidad;
	this.color = color;
	this.talla = talla;
	
}

public productos(int id) {
	this.id = id;
	
}

public productos(String producto){
	this.producto = producto;
}


public productos(String producto, double precioUnidad, int stock, int idCategoria, double costoUnidad, String color,
		String talla) {
	
	this.producto = producto;
	this.precioUnidad = precioUnidad;
	this.stock = stock;
	this.idCategoria = idCategoria;
	this.costoUnidad = costoUnidad;
	this.color = color;
	this.talla = talla;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getTalla() {
	return talla;
}

public void setTalla(String talla) {
	this.talla = talla;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getProducto() {
	return producto;
}

public void setProducto(String producto) {
	this.producto = producto;
}

public double getPrecioUnidad() {
	return precioUnidad;
}

public void setPrecioUnidad(double precioUnidad) {
	this.precioUnidad = precioUnidad;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public int getIdCategoria() {
	return idCategoria;
}

public void setIdCategoria(int idCategoria) {
	this.idCategoria = idCategoria;
}

public double getCostoUnidad() {
	return costoUnidad;
}

public void setCostoUnidad(double costoUnidad) {
	this.costoUnidad = costoUnidad;
}

@Override
public String toString() {
	return "productos [id=" + id + ", producto=" + producto + ", precioUnidad=" + precioUnidad + ", stock=" + stock
			+ ", idCategoria=" + idCategoria + ", costoUnidad=" + costoUnidad + ", color=" + color + ", talla=" + talla
			+ "]";
}


}
