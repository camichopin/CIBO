package com.cibo.entity;

public class proveedores {

private int id;
private String empresa;
private String ciudad;
private String pais;
private String contacto;

public proveedores(int id, String empresa, String ciudad, String pais, String contacto) {
	
	this.id = id;
	this.empresa = empresa;
	this.ciudad = ciudad;
	this.pais = pais;
	this.contacto = contacto;
}
public proveedores(int id) {

	this.id = id;
}

public proveedores(String empresa, String ciudad, String pais, String contacto) {
	super();
	this.empresa = empresa;
	this.ciudad = ciudad;
	this.pais = pais;
	this.contacto = contacto;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmpresa() {
	return empresa;
}
public void setEmpresa(String empresa) {
	this.empresa = empresa;
}
public String getCiudad() {
	return ciudad;
}
public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}
public String getPais() {
	return pais;
}
public void setPais(String pais) {
	this.pais = pais;
}
public String getContacto() {
	return contacto;
}
public void setContacto(String contacto) {
	this.contacto = contacto;
}

@Override
public String toString() {
	return "proveedores [id=" + id + ", empresa=" + empresa + ", ciudad=" + ciudad + ", pais=" + pais + ", contacto="
			+ contacto + "]";
}




}
