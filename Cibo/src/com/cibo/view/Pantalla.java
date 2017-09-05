package com.cibo.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.cibo.control.Conexion;

public class Pantalla { 
	Scanner scanner = new Scanner(System.in);
	Conexion conexion = new Conexion();
 public static void main(String[] args) throws Throwable {
	int opcionIngreso;
	int opcionMain;
	
	Scanner scanner = new Scanner(System.in);
	Conexion conexion = new Conexion();
	
	while(true) {
	System.out.println(">>>BIENVENIDO A CIBO<<<");
	System.out.println("Elija la forma de Ingresar:");
	System.out.println("1.- Empleado");
	System.out.println("2.- Administrador");
	opcionIngreso = ReadTypes.leerEntero(scanner, "");
	if (opcionIngreso!= 3) {
	  switch(opcionIngreso) {
		case 1:
			/////
			int OpcionEmpleado;
			//System.out.println("En Mantenimiento Joven...");
			System.out.println("1.- Realizar Venta");
			System.out.println("2.- Recepcionar Productos");
			System.out.println("3.- Salir");
			
			OpcionEmpleado = ReadTypes.leerEntero(scanner, "Elija la opcion que desea");
			
			if(OpcionEmpleado !=3) {
				switch(OpcionEmpleado) {
				case 1:
	
					ventasView ventaView = new ventasView(conexion, scanner);
				
					String NIT;
					NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT: ");
					clientesView clienteView = new clientesView(conexion, scanner);
					clienteView.VerificarNIT(NIT);
					ventaView.insertarVenta(NIT);
					
					System.out.println("");
					System.out.println("LISTA DE PRODUCTOS");
					System.out.println("");
					productosView productoView = new productosView(conexion, scanner);
					productoView.listar();
					
					int numeroProductos = ReadTypes.leerEntero(scanner, "Cuantos Tipos de Productos desea Comprar?");
					
								
						for(int i = 0; i < numeroProductos; i++) {
							detalles_ventaView detalleVentaView = new detalles_ventaView(conexion, scanner);
							detalleVentaView.insertarParaVenta(ventaView.getVenta());
							
							}											
									
					break;
				case 2:
					
					
					comprasView compraView = new comprasView(conexion, scanner);
					
					proveedoresView proveedorView = new proveedoresView (conexion, scanner);
					proveedorView.listar();
					int idProveedor;
					idProveedor = ReadTypes.leerEntero(scanner, "Ingrese el codigo del Proveedor: ");
					
					compraView.insertarCompra(idProveedor);
					
					productosView productoView31 = new productosView(conexion, scanner);
					productoView31.listar();
					
					int numProductos = ReadTypes.leerEntero(scanner, "Cuantos Tipos de Productos Estan Llegando?");
							
						for(int i = 0; i < numProductos; i++) {
							detalles_compraView detalleComprasView = new detalles_compraView(conexion, scanner);
							detalleComprasView.insertarParaCompra(compraView.getCompra());/**COMO RECUPERAR idVENTA**/ 
						}
							
					
					
					break;
				}
			}
				break;
				
			
		case 2:
			System.out.println("Elija la entidad a realizar mantenimiento:");
			System.out.println("0.- Categorias");
			System.out.println("1.- Clientes");
			System.out.println("2.- Compras");
			System.out.println("3.- Detalles de compra");
			System.out.println("4.- Detalles de venta");
			System.out.println("5.- Productos");
			System.out.println("6.- Proveedores");
			System.out.println("7.- Ventas");
			System.out.println("8.- Salir ");
			
			opcionMain = ReadTypes.leerEntero(scanner, "Ingrese una opcion: ");
			
			if(opcionMain != 8){
				switch(opcionMain){
				case 0:
					categoriasView categoriasView = new categoriasView(conexion, scanner);
					int opcionCategorias;
					do{
						System.out.println("1.- Listar Categorias");
						System.out.println("2.- Insertar nuevas Categorias");
						System.out.println("3.- Buscar Categorias");
						System.out.println("4.- Actualizar Categorias");
						System.out.println("5.- Salir");
						opcionCategorias = ReadTypes.leerEntero(scanner, "Ingrese una opcion: ");
						if(opcionCategorias != 5){
							switch(opcionCategorias){
							case 1:
								categoriasView.listar();
								break;
							case 2:
								categoriasView.insertar();
								break;
							case 3:
								int id = ReadTypes.leerEntero(scanner, "Ingrese el Id de la categoria que desea buscar: ");
								categoriasView.buscar(id);
								break;
							case 4:
								categoriasView.actualizar();
								break;
							case 5:
								System.out.println("Adios!");
								break;
							}
						}
					}while(opcionCategorias != 5);
					
				case 1:
					clientesView clientesView = new clientesView(conexion, scanner);
					int opcionClientes;
					do{
						System.out.println("1.- Listar Clientes");
						System.out.println("2.- Insertar nuevo Clientes");
						System.out.println("3.- Buscar Cliente");
						System.out.println("4.- Actualizar Cliente");
						System.out.println("5.- Salir");
						opcionClientes = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desee: ");
						if(opcionClientes != 5){
							switch(opcionClientes){
							case 1:
								clientesView.listar();
								break;
							case 2:
								clientesView.insertar();
								break;
							case 3:
								String NIT = ReadTypes.leerCadena(scanner, "Por favor ingrese el NIT del cliente que desea buscar: ");
								clientesView.buscar(NIT);
								break;
							case 4:
								clientesView.actualizar();
								break;
							case 5:
								System.out.println("Adios!");
								break;
							
							}
						}
					}while(opcionClientes != 5);
					
				case 2:
					comprasView comprasView = new comprasView(conexion, scanner);
					int opcionCompras;
					do{
						System.out.println("1.- Listar Compras");
						System.out.println("2.- Insertar nuevo Compra");
						System.out.println("3.- Buscar Compra");
						System.out.println("4.- Salir");
						opcionCompras = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desee: ");
						if(opcionCompras != 4){
							switch(opcionCompras){
							case 1:
								comprasView.listar();
								break;
							case 2:
								comprasView.insertar();
								break;
							case 3:
								int id = ReadTypes.leerEntero(scanner, "Por favor ingrese el id de la compra que desea buscar: ");
								comprasView.buscar(id);
								break;
							case 4:
								System.out.println("Adios!");
								break;
							}
						}
					}while(opcionCompras != 4);
					
				case 3:
					detalles_compraView detalles_compraView = new detalles_compraView(conexion, scanner);
					int opcionDetalles_compra;
					do{
						System.out.println("1.- Listar Detalles de Compra");
						System.out.println("2.- Insertar nuevo Detalle de Compra");
						System.out.println("3.- Buscar Detalle de Compra");
						System.out.println("4.- Actualizar Detalle de Compra");
						System.out.println("5.- Salir");
						opcionDetalles_compra = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desee: ");
						if(opcionDetalles_compra != 5){
							switch(opcionDetalles_compra){
							case 1:
								detalles_compraView.listar();
								break;
							case 2:
								detalles_compraView.insertar();
								break;
							case 3:
								int id = ReadTypes.leerEntero(scanner, "Ingrese el id del detalle de compra que desea buscar: ");
								detalles_compraView.buscar(id);
								break;
							case 4:
								detalles_compraView.actualizar();
								break;
							case 5:
								System.out.println("Adios!");
								break;
							}
						}
					} while(opcionDetalles_compra != 5);
				case 4:
					detalles_ventaView detalles_ventaView = new detalles_ventaView(conexion, scanner);
					int opcionDetalles_venta;
					do{
						System.out.println("1.- Listar Detalles de Venta");
						System.out.println("2.- Insertar nuevo Detalle de Venta");
						System.out.println("3.- Buscar Detalle de Venta");
						System.out.println("4.- Actualizar Detalle de Venta");
						System.out.println("5.- Salir");
						opcionDetalles_venta = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desee: ");
						if(opcionDetalles_venta != 5){
							switch(opcionDetalles_venta){
							case 1:
								detalles_ventaView.listar();
								break;
							case 2:
								detalles_ventaView.insertar();
								break;
							case 3:
								int id = ReadTypes.leerEntero(scanner, "Por favor ingrese el id del detalle de compra que desea buscar: ");
								detalles_ventaView.buscar(id);
								break;
							case 4:
								detalles_ventaView.actualizar();
								break;
							case 5:
								System.out.println("Adios!");
								break;
							}
						}
					} while(opcionDetalles_venta != 5);
				case 5:
					productosView productosView = new productosView(conexion, scanner);
					int opcionProductos;
					do{
						System.out.println("1.- Listar Productos");
						System.out.println("2.- Insertar nuevo Producto");
						System.out.println("3.- Buscar Producto");
						System.out.println("4.- Actualizar Producto");
						System.out.println("5.- Salir");
						
						opcionProductos = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desea: ");
						if(opcionProductos != 5){
							switch(opcionProductos){
							case 1:
								productosView.listar();
								break;
							case 2:
								productosView.insertar();
								break;
							case 3:
								int id = ReadTypes.leerEntero(scanner, "Por favor ingrese el id del producto que desea buscar: ");
								productosView.buscar(id);
								break;
							case 4:
								productosView.actualizar();
								break;
							case 5:
								System.out.println("Adios!");
								break;
							}
						}
					} while(opcionProductos != 5);
					
				case 6:
					proveedoresView proveedoresView = new proveedoresView(conexion, scanner);
					int opcionProveedores;
					do{
						System.out.println("1.- Listar Proveedores");
						System.out.println("2.- Insertar nuevo Proveedor");
						System.out.println("3.- Buscar Proveedor");
						System.out.println("4.- Actualizar Proveedor");
						System.out.println("5.- Salir");
						opcionProveedores = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desee: ");
						if(opcionProveedores != 5){
							switch(opcionProveedores){
							case 1:
								proveedoresView.listar();
								break;
							case 2:
								proveedoresView.insertar();
								break;
							case 3:
								int id = ReadTypes.leerEntero(scanner, "Por favor ingrese el id del proveedor que desea buscar: ");
								proveedoresView.buscar(id);
								break;
							case 4:
								proveedoresView.actualizar();
								break;
							case 5:
								System.out.println("Adios!");
								break;
							}
						}
					} while(opcionProveedores != 5);
				case 7:
					ventasView ventasView = new ventasView(conexion, scanner);
					int opcionVentas;
					do{
						System.out.println("1.- Listar Ventas");
						System.out.println("2.- Insertar nuevo Ventas");
						System.out.println("3.- Buscar Ventas");
						System.out.println("4.- Salir");
						opcionVentas = ReadTypes.leerEntero(scanner, "Ingrese la opcion que desee: ");
						if(opcionVentas != 4){
							switch(opcionVentas){
							case 1:
								ventasView.listar();
								break;
							case 2:
								ventasView.insertar();
								break;
							case 3:
								int id = ReadTypes.leerEntero(scanner, "Por favor ingrese el id de la venta que desea buscar: ");
								ventasView.buscar(id);
								break;
							case 4:
								System.out.println("Adios!");
								break;
							}
						}
					}while(opcionVentas != 4);
				}
			
			}
			
			break;
		case 3:
			System.out.println("ADIOS!");
			break;
		}	
	try {
		conexion.close();
	} catch (SQLException e) {
		System.out.println(e.getSQLState());
	}
   }
  }	
 }	 
}