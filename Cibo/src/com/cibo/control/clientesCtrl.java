package com.cibo.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.cibo.entity.clientes;


public class clientesCtrl implements Control<clientes>{

	private Conexion conexion;
	
	public clientesCtrl (Conexion conexion) {
		this.conexion = conexion;
	}
//LISTAR CLIENTES
	public ArrayList<clientes> list() throws Throwable {
		ArrayList<clientes> clientes = new ArrayList<clientes>();
		ResultSet rs;
		String NIT;
		String clienteName;

		conexion.SQL("Select * from clientes");

		rs = conexion.resultSet();

		while (rs.next()) {
			NIT = rs.getString("NIT");
			clienteName = rs.getString("cliente");
			clientes.add(new clientes(NIT, clienteName));
			}

		return clientes;
	}
	
//INSERTAR UN CLIENTE
	
	public void insert(clientes cliente) throws Throwable {

		conexion.SQL("Insert into clientes(NIT,cliente) VALUES(?,?)");
		conexion.preparedStatement().setString(1, cliente.getNIT());
		conexion.preparedStatement().setString(2, cliente.getCliente());
		conexion.CUD();

	}
	
//BUSCAR CLIENTE
	public void search(clientes cliente) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from clientes where NIT=?");
		conexion.preparedStatement().setString(1, cliente.getNIT());
		rs = conexion.resultSet();

		while (rs.next()) {

			cliente.setCliente(rs.getString("cliente"));
			
		}

		rs.close();

	}
//ACTUALIZAR CLIENTE
	public void update(clientes cliente) throws Throwable {
		String clienteName;
		String NIT;
		if (cliente != null) {
			clienteName = cliente.getCliente();
			NIT = cliente.getNIT();

			conexion.SQL("Update clientes set cliente = ? where NIT=?");
			conexion.preparedStatement().setString(1, clienteName);
			conexion.preparedStatement().setString(2, NIT);
			conexion.CUD();
		}
	}
	//ACTUALIZAR NOMBRE (ESPECÍFICO)
	public void updateCliente(clientes cliente, String clienteName) throws Throwable {
		//String clienteName;
		String NIT;
		if (cliente != null) {
			//clienteName = cliente.getCliente();
			NIT = cliente.getNIT();

			conexion.SQL("Update clientes set cliente = ? where NIT=?");
			conexion.preparedStatement().setString(1, clienteName);
			conexion.preparedStatement().setString(2, NIT);
			conexion.CUD();
		}
	}
	

}
