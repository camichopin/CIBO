package com.cibo.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.cibo.control.Conexion;
import com.cibo.control.ventasCtrl;
import com.cibo.entity.ventas;

public class ventasView {

	private Scanner scanner;
	private ventas venta;
	private ventasCtrl ventasCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public ventasView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		ventasCtrl = new  ventasCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		Date fecha = new Date();
		String NIT;
		
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT de la venta: ");
		
		venta = new ventas(fecha, NIT);
		
		try {
			ventasCtrl.insert(venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void insertarVenta(String NIT) {
		Date fecha = new Date();
		
		venta = new ventas(fecha, NIT);
		
		try {
			ventasCtrl.insert(venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<ventas> ventas;

		try {
			ventas = ventasCtrl.list();
			for (int i = 0; i < ventas.size(); i++) {
				System.out.println(ventas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int id) {
		venta = new ventas(id);
		try {
			ventasCtrl.search(venta);
			System.out.println(venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int id;
		
		id = ReadTypes.leerEntero(scanner, "Ingrese el id de la venta a modificar: ");
		venta = new ventas(id);
		try {
			ventasCtrl.search(venta);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}
		try {
			ventasCtrl.update(venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public ventas getVenta() {
		return venta;
	}
	public void setVenta(ventas venta) {
		this.venta = venta;
	}
	/**********************************************************************************************************************
	*RECUPERAR CODIGO
	***********************************************************************************************************************/
	public int getVentaId() {
		int id = venta.getId();
		return id;
	}
	
}
