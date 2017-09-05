package com.cibo.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.cibo.control.Conexion;
import com.cibo.control.detalles_ventaCtrl;
import com.cibo.entity.detalles_venta;
import com.cibo.entity.ventas;
import com.cibo.view.ReadTypes;


public class detalles_ventaView {

	private Scanner scanner;
	private detalles_venta detalleVenta;
	private com.cibo.control.detalles_ventaCtrl detalleVentaCtrl;
	private Conexion conexion;

	public detalles_ventaView(Conexion conexion, Scanner scanner){
		this.scanner = scanner;
		detalleVentaCtrl = new detalles_ventaCtrl(conexion);
		this.conexion = conexion;
	}
	
	public void insertar(){
		int idProducto;
		int idVenta;
		int cantidad;
		
		idProducto = ReadTypes.leerEntero(scanner, "Ingrese el código del producto: ");
		idVenta = ReadTypes.leerEntero(scanner, "Ingrese el código de la venta: ");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");
		
		detalleVenta = new detalles_venta(idProducto, idVenta, cantidad);
		
		try{
			detalleVentaCtrl.insert(detalleVenta);
		} catch (Throwable e){
			System.out.println(e.getMessage());
		}
	}
	
	public void insertarParaVenta(ventas venta) throws Throwable{

		int idProducto;
		int idVenta;
		int cantidad;
		
		idProducto = ReadTypes.leerEntero(scanner, "Ingrese el código del producto: ");
		idVenta = venta.getId();
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");
				
		detalleVenta = new detalles_venta(idProducto, idVenta, cantidad);
		
		conexion.SQL("UPDATE productos set stock = stock - ? where id = ?");
		conexion.preparedStatement().setInt(1, cantidad);
		conexion.preparedStatement().setInt(2,  idProducto);
		conexion.CUD();
			
		
		try{
			detalleVentaCtrl.insert(detalleVenta);
		} catch (Throwable e){
			System.out.println(e.getMessage());
		}
	}
	
	public void listar(){
		ArrayList<detalles_venta> DetallesVentas;
		try{
			DetallesVentas = detalleVentaCtrl.list();
			for(int i=0; i < DetallesVentas.size(); i++){
				System.out.println(DetallesVentas.get(i));
			}
		} catch (Throwable e){
			System.out.println(e.getMessage());
		}
	}
	
	public void buscar(int id){
	
		detalles_venta detalleVenta = new detalles_venta(id);
		try{
			detalleVentaCtrl.search(detalleVenta);
			System.out.println(detalleVenta);
		} catch (Throwable e){
			System.out.println(e.getMessage());
		}
	}
	
	public void actualizar(){
		int id;
		int nuevaCantidad;
		int opcion;
		
	
		
		do{
			System.out.println("1.- Cambiar Cantidad");
			System.out.println("2.-Salir");
			opcion = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desee:");
			if(opcion != 2){
				id = ReadTypes.leerEntero(scanner, "Ingrese el id del detalle de venta a modificar: ");
				detalles_venta dv = new detalles_venta(id);
				try{
					detalleVentaCtrl.search(dv);
				} catch (Throwable e){
					e.printStackTrace();
				}
				
				switch (opcion){
				case 1:
					nuevaCantidad = ReadTypes.leerEntero(scanner, "Ingrese la nueva cantidad: ");
					try{
						detalleVentaCtrl.updateCantidad(dv, nuevaCantidad);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				}
			}
		} while(opcion != 2);
	}
	
	public int GetIdProd(int id ) {
		int IdProd = id;
				return IdProd;
	}
	
	public int GetCantidad(int cantidad ) {
				return cantidad;
	}
}


