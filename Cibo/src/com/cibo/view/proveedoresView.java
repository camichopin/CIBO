package com.cibo.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.cibo.control.Conexion;
import com.cibo.control.proveedoresCtrl;
import com.cibo.entity.proveedores;

public class proveedoresView {

	private Scanner scanner;
	private proveedores proveedor;
	private proveedoresCtrl proveedoresCtrl;
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public proveedoresView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		proveedoresCtrl = new proveedoresCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		String empresa;
		String ciudad;
		String pais;
		String contacto;

		empresa = ReadTypes.leerCadena(scanner, "Ingrese la empresa: ");
		ciudad = ReadTypes.leerCadena(scanner, "Ingrese la ciudad: ");
		pais = ReadTypes.leerCadena(scanner, "Ingrese el pais: ");
		contacto = ReadTypes.leerCadena(scanner, "Ingrese el contacto: ");
		
		proveedor = new proveedores(empresa, ciudad, pais, contacto);
		
		try {
			proveedoresCtrl.insert(proveedor);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<proveedores> proveedores;

		try {
			proveedores = proveedoresCtrl.list();
			for (int i = 0; i < proveedores.size(); i++) {
				System.out.println(proveedores.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int id) {
		proveedor = new proveedores(id);
		try {
			proveedoresCtrl.search(proveedor);
			System.out.println(proveedor);
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
		String nuevaEmpresa;
		String nuevaCiudad;
		String nuevoPais;
		String nuevoContacto;
		
		
		do{
			System.out.println("1.- Cambiar nombre Empresa:");
			System.out.println("2.- Cambiar Ciudad");
			System.out.println("3.- Cambiar Pais");
			System.out.println("4.- Cambiar Contacto");
			System.out.println("5.- Salir");
			opcion = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desee: ");
			if(opcion != 5){
				id = ReadTypes.leerEntero(scanner, "Ingrese el id del proveedor a modificar: ");
				proveedores pro = new proveedores(id);
				
				try{
					proveedoresCtrl.search(pro);
				} catch (Throwable e){
					e.printStackTrace();
				}
				
				switch(opcion){
				case 1:
					nuevaEmpresa = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre de la empresa: ");
					try{
						proveedoresCtrl.updateEmpresa(pro, nuevaEmpresa);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				case 2:
					nuevaCiudad = ReadTypes.leerCadena(scanner, "Ingrese la nueva ciudad: ");
					try{
						proveedoresCtrl.updateEmpresa(pro, nuevaCiudad);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				case 3:
					nuevoPais = ReadTypes.leerCadena(scanner, "Ingrese el nuevo pais: ");
					try{
						proveedoresCtrl.updateEmpresa(pro, nuevoPais);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				case 4:
					nuevoContacto = ReadTypes.leerCadena(scanner, "Ingrese el nuevo contacto: ");
					try{
						proveedoresCtrl.updateEmpresa(pro, nuevoContacto);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				}
			}
		} while (opcion != 5);
	}
}
