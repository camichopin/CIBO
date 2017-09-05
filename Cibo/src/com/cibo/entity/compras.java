package com.cibo.entity;

import java.util.Date;

public class compras {
	private int id;
	private Date fecha;
	private int idProveedor;
	
public compras(int id, Date fecha, int idProveedor) {
		
		this.id = id;
		this.fecha = fecha;
		this.idProveedor = idProveedor;
	}

public compras(Date fecha, int idProveedor) {
	this.fecha = fecha;
	this.idProveedor = idProveedor;
}
public compras(int id) {
		
		this.id = id;
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
public int getIdProveedor() {
	return idProveedor;
}
public void setIdProveedor(int idProveedor) {
	this.idProveedor = idProveedor;
}

@Override
public String toString() {
	return "compras [id=" + id + ", fecha=" + fecha + ", idProveedor=" + idProveedor + "]";
}

}
