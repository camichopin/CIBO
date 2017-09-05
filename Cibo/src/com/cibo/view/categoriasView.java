package com.cibo.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.cibo.control.Conexion;
import com.cibo.control.categoriasCtrl;
import com.cibo.entity.categorias;

public class categoriasView {

	private Scanner scanner;
	private categorias categoria;
	private categoriasCtrl categoriasCtrl;
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public categoriasView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		categoriasCtrl = new  categoriasCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
	
		String categoriaName;
		String descripcion;

		categoriaName = ReadTypes.leerCadena(scanner, "Ingrese la categoria: ");
		descripcion = ReadTypes.leerCadena(scanner, "Ingrese la descripción: ");
		
		categoria = new categorias(categoriaName,descripcion);
		
		try {
			categoriasCtrl.insert(categoria);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<categorias> categorias;

		try {
			categorias = categoriasCtrl.list();
			for (int i = 0; i < categorias.size(); i++) {
				System.out.println(categorias.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int id) {
		categorias categoria = new categorias(id);
		try {
			categoriasCtrl.search(categoria);
			System.out.println(categoria);
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
		String nuevaCategoria;
		String nuevaDescripcion;
	
		do{
			
			System.out.println("1.- Cambiar el nombre");
			System.out.println("2.- Cambiar la descripcion");
			System.out.println("3.- Salir");
			opcion = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desea: ");
			if(opcion != 3){
				id = ReadTypes.leerEntero(scanner, "Ingrese el Id de la categoria a modificar: ");
				categorias cat = new categorias(id);
				
				try{
					categoriasCtrl.search(cat);
				} catch (Throwable e){
					e.printStackTrace();
				}
				
				switch(opcion){
				case 1:
					nuevaCategoria = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre de la categoria: ");
					try{
						categoriasCtrl.updateCategoriaName(cat, nuevaCategoria);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				case 2:
					nuevaDescripcion = ReadTypes.leerCadena(scanner, "Ingrese la nueva descripcion: ");
					try{
						categoriasCtrl.updateDescripcion(cat, nuevaDescripcion);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				}
			}
		} while (opcion != 3);
	}
}
