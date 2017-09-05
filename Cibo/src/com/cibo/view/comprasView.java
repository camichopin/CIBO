package com.cibo.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.cibo.control.Conexion;
import com.cibo.control.comprasCtrl;
import com.cibo.entity.compras;

public class comprasView {

	private Scanner scanner;
	private compras compra;
	private comprasCtrl comprasCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public comprasView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		comprasCtrl = new  comprasCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		//int id;
		Date fecha = new Date();
		int idProveedor;
		
		idProveedor = ReadTypes.leerEntero(scanner, "Ingrese el id del proveedor: ");
		
		compra = new compras( fecha , idProveedor);
		
		try {
			comprasCtrl.insert(compra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void insertarCompra(int idProducto) {

		Date fecha = new Date();
		
		compra = new compras(fecha, idProducto);
		
		try {
			comprasCtrl.insert(compra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<compras> compras;

		try {
			compras = comprasCtrl.list();
			for (int i = 0; i < compras.size(); i++) {
				System.out.println(compras.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int id) {
		compra = new compras(id);
		try {
			comprasCtrl.search(compra);
			System.out.println(compra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int id;
		
		id = ReadTypes.leerEntero(scanner, "Ingrese el id de la compra a modificar: ");
		compra = new compras(id);
		try {
			comprasCtrl.search(compra);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		
		try {
			comprasCtrl.update(compra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	public compras getCompra() {
		return compra;
	}
	public void setCompra(compras compra) {
		this.compra = compra;
	}
	
	
}
