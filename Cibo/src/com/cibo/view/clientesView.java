package com.cibo.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.cibo.control.clientesCtrl;
import com.cibo.control.Conexion;
import com.cibo.entity.clientes;
import com.cibo.view.ReadTypes;


public class clientesView {

	private Scanner scanner;
	private clientes cliente;
	private clientesCtrl clientesCtrl;
	/**********************************************************************************************************************
	*METODO
	***********************************************************************************************************************/
	public clientesView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		clientesCtrl = new  clientesCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		String NIT;
		String nombre;

		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		
		cliente = new clientes(NIT,nombre);
		
		try {
			clientesCtrl.insert(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<clientes> clientes;

		try {
			clientes = clientesCtrl.list();
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println(clientes.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(String NIT) {

		cliente = new clientes(NIT);
		try {
			clientesCtrl.search(cliente);
			System.out.println(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void VerificarNIT(String NIT) {
	
		cliente = new clientes(NIT);
		try {
			clientesCtrl.search(cliente);
			if (cliente.getCliente()!=null) {
				System.out.println(cliente);
			}
			else {
				System.out.println("Cliente Nuevo");
				String nombreCliente = ReadTypes.leerCadena(scanner, "Inserte nuevo nombre");
				cliente.setCliente(nombreCliente);
				cliente.setNIT(NIT);
				clientesCtrl.insert(cliente);
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		String NIT;
		String nuevoCliente;
		int opcion;
	
		
		do{
			System.out.println("1.- Cambiar Nombre de Cliente");
			System.out.println("2.- Salir");
			
			opcion = ReadTypes.leerEntero(scanner, "Ingrese una opcion");
			if(opcion != 2){
				NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente a modificar: ");
				clientes clnt = new clientes(NIT);
				try{
					clientesCtrl.search(clnt);//REVISAR MANDA OBJETO PERO RECIBE CONEXION
				} catch (Throwable e){
					e.printStackTrace();
				}
				
				switch (opcion){
				case 1:
					nuevoCliente = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre del cliente: ");
					try{
						clientesCtrl.updateCliente(clnt, nuevoCliente);
					} catch (Throwable e){
						e.printStackTrace();
					}
					break;
				}
			}
		} while(opcion != 2);	
	}
}

