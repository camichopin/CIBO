package com.cibo.entity;

public class categorias {
private int id;
private String categoria;
private String descripcion;

public categorias(int id, String categoria, String descripcion) {
	this.id = id;
	this.categoria = categoria;
	this.descripcion = descripcion;
}

public categorias(int id) {
	this.id = id;

}

public categorias(String categoria, String descripcion) {
	this.categoria = categoria;
	this.descripcion = descripcion;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCategoria() {
	return categoria;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

@Override
public String toString() {
	return "categorias [id=" + id + ", categoria=" + categoria + ", descripcion=" + descripcion + "]";
}



}
