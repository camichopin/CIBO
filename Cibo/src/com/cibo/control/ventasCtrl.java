package com.cibo.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import com.cibo.entity.ventas;

public class ventasCtrl implements Control<ventas> {

	private Conexion conexion;
	
	public ventasCtrl(com.cibo.control.Conexion conexion) {
	
			this.conexion = conexion;
	}
	
//GENERADOR DE CODIGO
	public int generadorid() throws Throwable{
		ResultSet rs;
		int id =0;
		conexion.SQL("SELECT id FROM ventas ORDER BY id DESC LIMIT 1");
		rs = conexion.resultSet();
		
		while (rs.next()){
			id = rs.getInt("id");
		}
		
		return id;
	}
//LISTAR VENTAS
	
	public ArrayList<ventas> list() throws Throwable {
		ArrayList<ventas> ventas = new ArrayList<ventas>();
		ResultSet rs;
		int id;
		Date fecha;
		String NIT;

		conexion.SQL("Select * from ventas");

		rs = conexion.resultSet();

		while (rs.next()) {
			id = rs.getInt("id");
			fecha = rs.getDate("fecha");
			NIT = rs.getString("NIT");
			ventas.add(new ventas(id ,fecha, NIT));
		}

		return ventas;

	}
	
//INSERTAR VENTAS
	
	public void insert(ventas venta) throws Throwable {

		conexion.SQL("Insert into ventas(fecha ,NIT) VALUES(?,?)");
		conexion.preparedStatement().setDate(1, new java.sql.Date ( venta.getFecha().getTime()));
		conexion.preparedStatement().setString(2, venta.getNIT());
		conexion.CUD();
		int id = generadorid();
		venta.setId(id);

	}

//BURSCAR VENTA
	
	public void search(ventas venta) throws Throwable {
		ResultSet rs;

		conexion.SQL("Select * from ventas where id=?");
		conexion.preparedStatement().setInt(1, venta.getId());
		//venta.setNIT(null);
		//venta.setFecha(null);
		rs = conexion.resultSet();

		while (rs.next()) {
			venta.setFecha((java.util.Date) rs.getDate("fecha"));
			venta.setNIT(rs.getString("NIT"));
			
		}

		rs.close();

	}
//ACTUALIZAR VENTAS
	public void update(ventas venta) throws Throwable {
		int id;
		Date fecha;
		String NIT;
		if (venta != null) {
			id = venta.getId();
			fecha = venta.getFecha();
			NIT = venta.getNIT();

			conexion.SQL("Update ventas set fecha = ?, NIT = ? where id=?");
			conexion.preparedStatement().setDate(1, (java.sql.Date) fecha);
			conexion.preparedStatement().setString(2, NIT);
			conexion.preparedStatement().setInt(3, id);
			conexion.CUD();
		}
	}
}
