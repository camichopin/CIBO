package com.cibo.entity;

public class clientes {

	private String NIT;
	private String cliente;
	
	public clientes(String NIT, String cliente) {
		this.NIT = NIT;
		this.cliente = cliente;
	}
	
	public clientes(String NIT) {
		this.NIT = NIT;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "clientes [NIT=" + NIT + ", cliente=" + cliente + "]";
	}
}

