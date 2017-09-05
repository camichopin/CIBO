package com.cibo.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.cibo.control.Conexion;
import com.cibo.entity.detalles_venta;

public class detalles_ventaCtrl implements Control<detalles_venta> {

private Conexion conexion;
	
	public detalles_ventaCtrl(Conexion conexion){
		this.conexion = conexion;
	}
///	
	public int generadoridVenta() throws Throwable{
		ResultSet rs;
		int idVenta = 0;
		conexion.SQL("SELECT id FROM ventas ORDER BY ventas.id DESC LIMIT 1");
		rs = conexion.resultSet();
		
		while (rs.next()){
			idVenta = rs.getInt("id");
		}
		
		return idVenta;
	}
//LISTAS DETALLES VENTAS
	public ArrayList<detalles_venta> list() throws Throwable{
		ArrayList<detalles_venta> detallesVentas = new ArrayList<detalles_venta>();
		ResultSet rs;
		int id;
		int idProducto;
		int idVenta;
		int cantidad;
		
		conexion.SQL("Select * from detalles_venta");
		
		rs = conexion.resultSet();
		
		while (rs.next()){
			id = rs.getInt("id");
			idProducto = rs.getInt("idProducto");
			idVenta = rs.getInt("idVenta");
			cantidad = rs.getInt("cantidad");
			detallesVentas.add(new detalles_venta(id, idProducto,idVenta, cantidad));
		}
		
		return detallesVentas;
	}
// INSERTAR DETALLES VENTAS
	public void insert(detalles_venta DetalleVenta) throws Throwable{
		conexion.SQL("Insert into detalles_venta(idProducto, idVenta, cantidad) VALUES(?,?,?)");
		
		conexion.preparedStatement().setInt(1, DetalleVenta.getIdProducto());
		conexion.preparedStatement().setInt(2, DetalleVenta.getIdVenta());
		conexion.preparedStatement().setInt(3, DetalleVenta.getCantidad());
		conexion.CUD();
	}
//BUSCAR DETALLES VENTAS
	public void search(detalles_venta DetalleVenta) throws Throwable{
		ResultSet rs;
		
		conexion.SQL("Select * from detalles_venta where id=?");
		conexion.preparedStatement().setInt(1, DetalleVenta.getId());
		rs = conexion.resultSet();
		
		while (rs.next()){
			DetalleVenta.setIdProducto(rs.getInt("idProducto"));
			DetalleVenta.setIdVenta(rs.getInt("idVenta"));
			DetalleVenta.setCantidad(rs.getInt("cantidad"));
		}
		
		rs.close();
	}
//ACTUALIZAR DETALLES VENTAS
	public void update(detalles_venta DetalleVenta) throws Throwable{
		int id;
		int idProducto;
		int idVenta;
		int cantidad;
		
		if(DetalleVenta != null){
			id = DetalleVenta.getId();
			idProducto = DetalleVenta.getIdProducto();
			idVenta = DetalleVenta.getIdVenta();
			cantidad = DetalleVenta.getCantidad();
			
			conexion.SQL("Update detalles_venta set idProducto=?, idVenta=?, cantidad=? where id=?");
			conexion.preparedStatement().setInt(1, idProducto);
			conexion.preparedStatement().setInt(2, idVenta);
			conexion.preparedStatement().setInt(3, cantidad);
			conexion.preparedStatement().setInt(4, id);
			conexion.CUD();
		}
	}
	
	public void updateCantidad(detalles_venta DetalleVenta, int cantidad) throws Throwable{
		int id;
		
		if(DetalleVenta != null){
			id = DetalleVenta.getId();
			//cantidad = DetalleVenta.getCantidad();
			
			conexion.SQL("Update detalles_venta set cantidad=? where id=?");
			conexion.preparedStatement().setInt(1, cantidad);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();
		}
	}
	
	public void updateIdVenta(detalles_venta DetalleVenta, int IdVenta) throws Throwable{
		int id;
		
		if(DetalleVenta != null){
			id = DetalleVenta.getId();
			
			conexion.SQL("Update detalles_venta set IdVenta=? where id=?");
			conexion.preparedStatement().setInt(1, IdVenta);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();
		}
	}
}
