package com.cibo.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.cibo.control.Conexion;
import com.cibo.control.productosCtrl;
import com.cibo.entity.productos;

public class productosView {

	private Scanner scanner;
	private productos productoObj;
	private productosCtrl productosCtrl;
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public productosView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		
		productosCtrl = new  productosCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		String producto;
		double precioUnidad;
		int stock;
		int idCategoria;
		double costoUnidad;
		String color;
		String talla;

		producto = ReadTypes.leerCadena(scanner, "Ingrese el nombre del producto: ");
		precioUnidad = ReadTypes.leerReal(scanner, "Ingrese el precio por unidad: ");
		stock = ReadTypes.leerEntero(scanner, "Ingrese el stock: ");
		idCategoria = ReadTypes.leerEntero(scanner, "Ingrese el id de la categoria: ");
		costoUnidad = ReadTypes.leerReal(scanner, "Ingrese el costo por unidad: ");
		color = ReadTypes.leerCadena(scanner, "Ingrese el color: ");
		talla = ReadTypes.leerCadena(scanner, "Ingrese la talla: ");
		
		productoObj = new productos(producto, precioUnidad, stock, idCategoria, costoUnidad, color, talla);
		
		try {
			productosCtrl.insert(productoObj);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<productos> productos;

		try {
			productos = productosCtrl.list();
			for (int i = 0; i < productos.size(); i++) {
				System.out.println(productos.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int id) {
		productos producto = new productos(id);
		try {
			productosCtrl.search(producto);
			System.out.println(producto);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int id;
		int opcion;
		String nuevoProducto;
		double nuevoPrecio;
		double nuevoCosto;
		String nuevoColor;
		String nuevaTalla;
		
	
		do{
			System.out.println("1.- Cambiar Nombre Producto");
			System.out.println("2.- Cambiar Precio Producto");
			System.out.println("3.- Cambiar Costo Producto");
			System.out.println("4.- Cambiar Color Producto");
			System.out.println("5.- Cambiar Talla Producto");
			System.out.println("6.- Salir");
			opcion = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desee");
			if(opcion != 6){
				id = ReadTypes.leerEntero(scanner, "Ingrese el id del producto a modificar");
				productos prod = new productos(id);
				
				try{
					productosCtrl.search(prod);
				} catch (Throwable e){
					e.printStackTrace();
				}
				
				switch(opcion){
				case 1:
					nuevoProducto = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre del producto: ");
					try{
						productosCtrl.updateProductoName(prod, nuevoProducto);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				case 2:
					nuevoPrecio = ReadTypes.leerReal(scanner, "Ingrese el nuevo precio del producto: ");
					try{
						productosCtrl.updatePrecioUnidad(prod, nuevoPrecio);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				case 3:
					nuevoCosto = ReadTypes.leerReal(scanner, "Ingrese el nuevo costo del producto: ");
					try{
						productosCtrl.updateCostoUnidad(prod, nuevoCosto);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				case 4:
					nuevoColor = ReadTypes.leerCadena(scanner, "Ingrese el nuevo color del producto: ");
					try{
						productosCtrl.updateColor(prod, nuevoColor);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				case 5:
					nuevaTalla = ReadTypes.leerCadena(scanner, "Ingrese la nueva talla del producto: ");
					try{
						productosCtrl.updateTalla(prod, nuevaTalla);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				}
			}
		} while(opcion != 6);
		
	}
	
	public void actualizarStockVenta() {
		
	}
}
