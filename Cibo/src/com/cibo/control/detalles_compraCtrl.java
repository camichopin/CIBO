package com.cibo.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.cibo.entity.detalles_compra;

public class detalles_compraCtrl implements Control<detalles_compra>{

private Conexion conexion;
	
	public detalles_compraCtrl(Conexion conexion){
		this.conexion = conexion;
	}
	
	public int generadoridCompra() throws Throwable{
		ResultSet rs;
		int idCompra = 0;
		conexion.SQL("SELECT id FROM ventas ORDER BY compras.id DESC LIMIT 1");
		rs = conexion.resultSet();
		
		while (rs.next()){
			idCompra = rs.getInt("id");
		}
		
		return idCompra;
	}
//LISTAS DETALLES COMPRAS
	public ArrayList<detalles_compra> list() throws Throwable{
		ArrayList<detalles_compra> detallesCompras = new ArrayList<detalles_compra>();
		ResultSet rs;
		int id;
		int idProducto;
		int idCompra;
		int cantidad;
		
		conexion.SQL("Select * from detalles_compra");
		
		rs = conexion.resultSet();
		
		while (rs.next()){
			id = rs.getInt("id");
			idProducto = rs.getInt("idProducto");
			idCompra = rs.getInt("idCompra");
			cantidad = rs.getInt("cantidad");
			detallesCompras.add(new detalles_compra(id, idProducto,idCompra, cantidad));
		}
		
		return detallesCompras;
	}
//INSERTAR DETALLES COMPRA
	public void insert(detalles_compra detalleCompra) throws Throwable{
		conexion.SQL("Insert into detalles_compra(idProducto, idCompra, cantidad) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, detalleCompra.getIdProducto());
		conexion.preparedStatement().setInt(2, detalleCompra.getIdCompra());
		conexion.preparedStatement().setInt(3, detalleCompra.getCantidad());
		conexion.CUD();
	}
//BUSCAR DETALLES COMPRAS
	public void search(detalles_compra detalleCompra) throws Throwable{
		ResultSet rs;
		
		conexion.SQL("Select * from detalles_compra where id=?");
		conexion.preparedStatement().setInt(1, detalleCompra.getId());
		rs = conexion.resultSet();
		
		while (rs.next()){
			detalleCompra.setIdProducto(rs.getInt("idProducto"));
			detalleCompra.setIdCompra(rs.getInt("idCompra"));
			detalleCompra.setCantidad(rs.getInt("cantidad"));
		}
		
		rs.close();
	}
//ACTUALIZAR DETALLES COMPRAS
	public void update(detalles_compra detalleCompra) throws Throwable{
		
		int idProducto;
		int idCompra;
		int cantidad;
		
		if(detalleCompra != null){
		
			idProducto = detalleCompra.getIdProducto();
			idCompra = detalleCompra.getIdCompra();
			cantidad = detalleCompra.getCantidad();
			
			conexion.SQL("Update detalles_compra set idProducto=?, idCompra=?, cantidad=? where id=?");
			conexion.preparedStatement().setInt(1, idProducto);
			conexion.preparedStatement().setInt(2, idCompra);
			conexion.preparedStatement().setInt(3, cantidad);
			conexion.CUD();
		}
	}
	
public void updateCantidad(detalles_compra detalleCompra, int cantidad) throws Throwable{
		
		int id;
		if(detalleCompra != null){
		
			id = detalleCompra.getId();
			//cantidad = detalleCompra.getCantidad();
			
			conexion.SQL("Update detalles_compra set cantidad=? where id=?");

			conexion.preparedStatement().setInt(1, cantidad);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();
		}
	}
}
