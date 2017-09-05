package com.cibo.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cibo.entity.compras;

public class comprasCtrl implements Control<compras>{

private Conexion conexion;
	
	public comprasCtrl(com.cibo.control.Conexion conexion) {
	
			this.conexion = conexion;
	}

//GENERADOR DE CODIGO
			public int generadorid() throws Throwable{
				ResultSet rs;
				int id =0;
				conexion.SQL("SELECT id FROM compras ORDER BY id DESC LIMIT 1");
				rs = conexion.resultSet();
				
				while (rs.next()){
					id = rs.getInt("id");
				}
				
				return id;
			}
//LISTAR COMPRA
	
	public ArrayList<compras> list() throws Throwable {
		ArrayList<compras> compras = new ArrayList<compras>();
		ResultSet rs;
		int id;
		Date fecha;
		int idProveedor;

		conexion.SQL("Select * from compras");

		rs = conexion.resultSet();

		while (rs.next()) {
			id = rs.getInt("id");
			fecha = rs.getDate("fecha");
			idProveedor = rs.getInt("idProveedor");
			compras.add(new compras(id, fecha, idProveedor));
		}

		return compras;

	}
	
//INSERTAR COMPRA
	
	public void insert(compras compra) throws Throwable {

		conexion.SQL("Insert into compras(fecha, idProveedor) VALUES(?,?)");
		conexion.preparedStatement().setDate(1, new java.sql.Date ( compra.getFecha().getTime()));
		conexion.preparedStatement().setInt(2, compra.getIdProveedor());
		conexion.CUD();
		int id = generadorid();
		compra.setId(id);

	}

//BURSCAR COMPRA
	
	public void search(compras compra) throws Throwable {
		ResultSet rs;

		conexion.SQL("Select * from compras where id=?");
		conexion.preparedStatement().setInt(1, compra.getId());
		//compra.setId(null);
		//compra.setFecha(null);
		rs = conexion.resultSet();

		while (rs.next()) {
			compra.setFecha((java.util.Date) rs.getDate("fecha"));
			compra.setIdProveedor(rs.getInt("idProveedor"));
			
		}

		rs.close();

	}
//ACTUALIZAR COMPRA (NO SE USARA)
	public void update(compras compra) throws Throwable {
		int id;
		Date fecha;
		int idProveedor;
		if (compra != null) {
			id = compra.getId();
			fecha = compra.getFecha();
			idProveedor = compra.getIdProveedor();

			conexion.SQL("Update compras set fecha = ?, idProveedor = ? where id=?");
			conexion.preparedStatement().setDate(1, (java.sql.Date) fecha);
			conexion.preparedStatement().setInt(2, idProveedor);
			conexion.preparedStatement().setInt(3, id);
			conexion.CUD();
		}
	}
}
