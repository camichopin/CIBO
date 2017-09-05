package com.cibo.entity;

import java.util.Date;

public class ventas {
private int id;
private Date fecha;
private String NIT;

public ventas(int id, Date fecha, String NIT) {
	
	this.id = id;
	this.fecha = fecha;
	this.NIT = NIT;
}
public ventas(int id) {
	
	this.id = id;
}

public ventas(Date fecha, String nIT) {
	this.fecha = fecha;
	this.NIT = nIT;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getNIT() {
	return NIT;
}
public void setNIT(String NIT) {
	this.NIT = NIT;
}

@Override
public String toString() {
	return "ventas [id=" + id + ", fecha=" + fecha + ", NIT=" + NIT + "]";
}

}
