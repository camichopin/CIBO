package com.cibo.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.cibo.entity.categorias;

public class categoriasCtrl implements Control<categorias> {
	private Conexion conexion;
	
		public categoriasCtrl(com.cibo.control.Conexion conexion) {
			this.conexion=conexion;
		}

//GENERADOR DE CODIGO
		public int generadorid() throws Throwable{
			ResultSet rs;
			int id =0;
			conexion.SQL("SELECT id FROM categorias ORDER BY id DESC LIMIT 1");
			rs = conexion.resultSet();
			
			while (rs.next()){
				id = rs.getInt("id");
			}
			
			return id;
		}
//LISTAR CATEGORIAS
		public ArrayList<categorias> list() throws Throwable {
			ArrayList<categorias>categorias = new ArrayList<categorias>();
			ResultSet rs;
			int id ;
			String categoria;
			String descripcion;
			
			conexion.SQL("Select * from categorias");
		
			rs = conexion.resultSet();
			
			while (rs.next()) {
				id = rs.getInt("id");
				categoria = rs.getString("categoria");
				descripcion = rs.getString("descripcion");		
				categorias.add(new categorias(id, categoria, descripcion));
			}
			return categorias;
		}
//INSERTAR CATEGORIAS
		public void insert(categorias categoria) throws Throwable {
			conexion.SQL("Insert Into categorias (categoria,descripcion) VALUES (?,?)");
			conexion.preparedStatement().setString(1,  categoria.getCategoria());
			conexion.preparedStatement().setString(2, categoria.getDescripcion());
			conexion.CUD();
			int id = generadorid();
			categoria.setId(id);
			
		}
// BUSCAR CATEGORIAS por id
		public void search(categorias categoria) throws Throwable{
			ResultSet rs;
			
			conexion.SQL("Select * from categorias where id = ?");
			conexion.preparedStatement().setInt(1, categoria.getId());
			//categoria.setDescripcion(null);
			
			rs = conexion.resultSet();
			
			while (rs.next()) {
				categoria.setCategoria(rs.getString("categoria"));
				categoria.setDescripcion(rs.getString("descripcion"));
			}
			rs.close();		
			
		}
//ACTUALIZAR CATEGORIAS
		public void update(categorias categoria) throws Throwable{
			int id;
			String categoriaName;
			String descripcion;
	
			if (categoria != null) {
				id = categoria.getId();
				categoriaName = categoria.getCategoria();
				descripcion = categoria.getDescripcion();
				
				conexion.SQL("Update categorias SET categoria = ? descripcion = ? WHERE id = ?");
				conexion.preparedStatement().setString(1, categoriaName);
				conexion.preparedStatement().setString(2, descripcion);
				conexion.preparedStatement().setInt(3, id);
				conexion.CUD();
				
				
			}
			
		}
		
		public void updateCategoriaName(categorias categoria, String categoriaName) throws Throwable{
			int id;
			
			if (categoria != null) {
				id = categoria.getId();
	
				
				conexion.SQL("Update categorias SET categoria = ?  WHERE id = ?");
				conexion.preparedStatement().setString(1, categoriaName);
				conexion.preparedStatement().setInt(2, id);
				conexion.CUD();
			}
			
			
		}
		
		public void updateDescripcion(categorias categoria, String categoriaDescripcion) throws Throwable{
			int id;
			
			if (categoria != null) {
				id = categoria.getId();
				
				conexion.SQL("Update categorias SET descripcion = ?  WHERE id = ?");
				conexion.preparedStatement().setString(1, categoriaDescripcion);
				conexion.preparedStatement().setInt(2, id);
				conexion.CUD();
			}
			
			
		}
}