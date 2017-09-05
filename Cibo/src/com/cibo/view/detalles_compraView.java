package com.cibo.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.cibo.control.Conexion;
import com.cibo.control.detalles_compraCtrl;
import com.cibo.entity.compras;
import com.cibo.entity.detalles_compra;

public class detalles_compraView {

	private Scanner scanner;
	private detalles_compra detalleCompra;
	private com.cibo.control.detalles_compraCtrl detalleCompraCtrl;
	private Conexion conexion;

	public detalles_compraView(Conexion conexion, Scanner scanner){
		this.scanner = scanner;
		detalleCompraCtrl = new detalles_compraCtrl(conexion);
		this.conexion  = conexion;
	}
	
	public void insertar(){
		int idProducto;
		int idCompra;
		int cantidad;
		
		idProducto = ReadTypes.leerEntero(scanner, "Ingrese el código del producto: ");
		idCompra = ReadTypes.leerEntero(scanner, "Ingrese el código de la compra: ");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");
		
		detalleCompra = new detalles_compra(idProducto, idCompra, cantidad);
		
		try{
			detalleCompraCtrl.insert(detalleCompra);
		} catch (Throwable e){
			System.out.println(e.getMessage());
		}
	}
	
	public void insertarParaCompra(compras compra) throws Throwable{

		int idProducto;
		int idCompra;
		int cantidad;
		
		idProducto = ReadTypes.leerEntero(scanner, "Ingrese el código del producto: ");
		idCompra = compra.getId();
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");
				
		detalleCompra = new detalles_compra(idProducto, idCompra, cantidad);
		
		conexion.SQL("UPDATE productos set stock = stock + ? where id = ?");
		conexion.preparedStatement().setInt(1, cantidad);
		conexion.preparedStatement().setInt(2,  idProducto);
		conexion.CUD();
			
		
		try{
			detalleCompraCtrl.insert(detalleCompra);
		} catch (Throwable e){
			System.out.println(e.getMessage());
		}
	}
	
	public void listar(){
		ArrayList<detalles_compra> DetallesCompras;
		try{
			DetallesCompras = detalleCompraCtrl.list();
			for(int i=0; i < DetallesCompras.size(); i++){
				System.out.println(DetallesCompras.get(i));
			}
		} catch (Throwable e){
			System.out.println(e.getMessage());
		}
	}
	
	public void buscar(int id){
		detalles_compra detalleCompra = new detalles_compra(id);
		try{
			detalleCompraCtrl.search(detalleCompra);
			System.out.println(detalleCompra);
		} catch (Throwable e){
			System.out.println(e.getMessage());
		}
	}
	
	public void actualizar(){
		int id;
		int nuevaCantidad;
		int opcion;
		
		
		do{
			System.out.println("1.-Cambiar cantidad en detalle de Compra");
			System.out.println("2.- Salir");
			opcion = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desee: ");
			if(opcion != 2){
				id = ReadTypes.leerEntero(scanner, "Ingrese el id del detalle de compra a modificar: ");
				detalles_compra dc = new detalles_compra(id);
				try{
					detalleCompraCtrl.search(dc);
				} catch (Throwable e){
					e.printStackTrace();
				}
				
				switch (opcion){
				case 1:
					nuevaCantidad = ReadTypes.leerEntero(scanner, "Ingrese la nueva cantidad: ");
					try{
						detalleCompraCtrl.updateCantidad(dc, nuevaCantidad);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				}
			}
		} while(opcion != 2);
	}
}
