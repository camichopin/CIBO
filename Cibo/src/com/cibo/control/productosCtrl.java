package com.cibo.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.cibo.entity.productos;

public class productosCtrl implements Control<productos>{
	private Conexion conexion;
	
		public productosCtrl(com.cibo.control.Conexion conexion) {
			this.conexion = conexion;
		}
//LISTAR PRODUCTOS
	public ArrayList<productos> list() throws Throwable {
		ArrayList<productos> productos = new ArrayList<productos>();
		ResultSet rs;
		int id;
		String producto;
		double precioUnidad;
		int stock;
		int idCategoria;
		double costoUnidad;
		String color;
		String talla;
		
		conexion.SQL("Select * from productos");

		rs = conexion.resultSet();
		
		while (rs.next()) {
			id = rs.getInt("id");
			producto = rs.getString("producto");
			precioUnidad = rs.getDouble("precioUnidad");
			stock = rs.getInt("stock");
			idCategoria = rs.getInt("idCategoria");
			costoUnidad= rs.getDouble("costoUnidad");
			color = rs.getString("color");
			talla = rs.getString("talla");
			productos.add(new productos(id, producto, precioUnidad, stock, idCategoria, costoUnidad, color, talla));
					
		}
		
		return productos;
}		
		
//INSERTAR PRODUCTOS
	
	public void insert(productos producto)  throws Throwable{
	conexion.SQL("Insert into productos(producto, precioUnidad, stock, idCategoria, costoUnidad, color, talla) VALUES(?,?,?,?,?,?,?)");
	conexion.preparedStatement().setString(1, producto.getProducto());
	conexion.preparedStatement().setDouble(2, producto.getPrecioUnidad());
	conexion.preparedStatement().setInt(3, producto.getStock());
	conexion.preparedStatement().setInt(4, producto.getIdCategoria());
	conexion.preparedStatement().setDouble(5, producto.getCostoUnidad());
	conexion.preparedStatement().setString(6, producto.getColor());
	conexion.preparedStatement().setString(7, producto.getTalla());
	conexion.CUD();
	}
//BUSCAR PRODUCTOS 
	public void search(productos producto) throws Throwable{
		ResultSet rs;
		
		conexion.SQL("Select * from productos where id = ? "); //por id
		conexion.preparedStatement().setInt(1, producto.getId());
		/*producto.setIdCategoria((Integer)null);
		producto.setCostoUnidad((Double) null);
		producto.setPrecioUnidad((Double) null);
		producto.setStock((Integer) null);
		producto.setColor(null);
		producto.setTalla(null);*/
		
		rs = conexion.resultSet();
		
			while (rs.next()) {
				
				producto.setProducto(rs.getString("producto"));
				producto.setPrecioUnidad(rs.getDouble("precioUnidad"));
				producto.setCostoUnidad(rs.getDouble("costoUnidad"));
				producto.setIdCategoria(rs.getInt("idCategoria"));
				producto.setStock(rs.getInt("stock"));
				producto.setColor(rs.getString("color"));
				producto.setTalla(rs.getString("talla"));
			}
			
			rs.close();
		}
//ACTUALIZAR PRODUCTOS
	public void update(productos producto) throws Throwable{
		int id;
		String productoName;
		double precioUnidad;
		int stock;
		int idCategoria;
		double costoUnidad;
		String color; 
		String talla;
		if(producto != null) {
			id = producto.getId();
			productoName = producto.getProducto();
			precioUnidad = producto.getPrecioUnidad();
			stock = producto.getStock();
			idCategoria = producto.getIdCategoria();
			costoUnidad = producto.getCostoUnidad();
			color = producto.getColor();
			talla = producto.getTalla();
			
			conexion.SQL("Update productos set producto = ? , precioUnidad = ?, stock = ?,idCategoria = ? , costoUnidad = ?, color = ?, talla = ? WHERE id = ?" );
			conexion.preparedStatement().setString(1, productoName);
			conexion.preparedStatement().setDouble(2, precioUnidad);
			conexion.preparedStatement().setInt(3, stock);
			conexion.preparedStatement().setInt(4, idCategoria);
			conexion.preparedStatement().setDouble(5, costoUnidad);
			conexion.preparedStatement().setString(6, color);
			conexion.preparedStatement().setString(7, talla);
			conexion.preparedStatement().setInt(8, id);
			conexion.CUD();		
		}	
	}
	
	public void updateProductoName(productos producto, String productoName) throws Throwable{
		int id;
		if(producto != null) {
			id = producto.getId();
			//productoName = producto.getProducto();
			
			conexion.SQL("Update productos set producto = ? WHERE id = ?" );
			conexion.preparedStatement().setString(1, productoName);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();		
		}	
	}
	
	public void updatePrecioUnidad(productos producto, double precioUnidad) throws Throwable{
		int id;
		if(producto != null) {
			id = producto.getId();
			//precioUnidad = producto.getPrecioUnidad();
			
			conexion.SQL("Update productos set precioUnidad = ? WHERE id = ?" );
			conexion.preparedStatement().setDouble(1, precioUnidad);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();		
		}	
	}
	
	public void updateCostoUnidad(productos producto, double costoUnidad) throws Throwable{
		int id;
		if(producto != null) {
			id = producto.getId();
			//costoUnidad = producto.getCostoUnidad();
			
			conexion.SQL("Update productos set costoUnidad = ? WHERE id = ?" );
			conexion.preparedStatement().setDouble(1, costoUnidad);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();		
		}	
	}
	
	public void updateColor(productos producto, String color) throws Throwable{
		int id;
		if(producto != null) {
			id = producto.getId();
			//color = producto.getColor();
			
			conexion.SQL("Update productos set color = ? WHERE id = ?" );
			conexion.preparedStatement().setString(1, color);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();		
		}	
	}
	
	public void updateTalla(productos producto, String talla) throws Throwable{
		int id;
		if(producto != null) {
			id = producto.getId();
			//talla = producto.getTalla();
			
			conexion.SQL("Update productos set talla = ? WHERE id = ?" );
			conexion.preparedStatement().setString(1, talla);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();		
		}	
	}
	
public void updateVenta(productos producto, int cantidad) throws Throwable{
		
	int id;
	int stock;
	
		id = 1;
		stock = cantidad;
		conexion.SQL("Update productos set stock = ? where id = ?");
		conexion.preparedStatement().setInt(1, stock);
		conexion.preparedStatement().setInt(2, id);
		conexion.CUD();	
	}

public void updateCompra(productos producto, int cantidad) throws Throwable{
	
	int id;
	int stock;
	
		id = producto.getId();
		stock = producto.getStock() + cantidad;
		conexion.SQL("Update productos set stock = ? where id = ?");
		conexion.preparedStatement().setInt(1, stock);
		conexion.preparedStatement().setInt(2, id);
		conexion.CUD();	
	}
}
	
