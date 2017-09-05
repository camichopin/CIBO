package com.cibo.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.cibo.entity.proveedores;

public class proveedoresCtrl implements Control<proveedores> {

	private Conexion conexion;
	
	public proveedoresCtrl(com.cibo.control.Conexion conexion) {
	
			this.conexion = conexion;
	}

//LISTAR PROVEEDORES
	
	public ArrayList<proveedores> list() throws Throwable {
		ArrayList<proveedores> proveedores = new ArrayList<proveedores>();
		ResultSet rs;
		int id;
		String empresa;
		String ciudad;
		String pais;
		String contacto;
		
		conexion.SQL("Select * from proveedores");
		
		rs = conexion.resultSet();
		
		while (rs.next()) {
			id = rs.getInt("id");
			empresa = rs.getString("empresa");
			ciudad = rs.getString("ciudad");
			pais = rs.getString("pais");
			contacto = rs.getString("contacto");
			proveedores.add(new proveedores(id, empresa, ciudad, pais, contacto));
		}
		return proveedores;
	}
	
//INSERTAR PROVEEDORES
	

	public void insert(proveedores proveedor)  throws Throwable{
		conexion.SQL("Insert into proveedores(empresa, ciudad, pais, contacto) VALUES(?,?,?,?)");
		conexion.preparedStatement().setString(1, proveedor.getEmpresa());
		conexion.preparedStatement().setString(2, proveedor.getCiudad());
		conexion.preparedStatement().setString(3, proveedor.getPais());
		conexion.preparedStatement().setString(4, proveedor.getContacto());
		conexion.CUD();
	}

//BUSCAR PROVEEDOR solo busca por id
	
	public void search(proveedores proveedor) throws Throwable{
		
	ResultSet rs;
	
	conexion.SQL("Select * from proveedores where id=?");
	conexion.preparedStatement().setInt(1, proveedor.getId());
	/**proveedor.setEmpresa(null);
	proveedor.setCiudad(null);
	proveedor.setPais(null);
	proveedor.setContacto(null);**/
	
	rs = conexion.resultSet();
	
		while (rs.next()) {
		
			proveedor.setEmpresa(rs.getString("empresa"));
			proveedor.setCiudad(rs.getString("ciudad"));
			proveedor.setPais(rs.getString("pais"));
			proveedor.setContacto(rs.getString("contacto"));	
		}
	
		rs.close();		
	}
	
//ACTUALIZAR PROVEEDORES
	public void update(proveedores proveedor) throws Throwable {
		int id;
		String empresa;
		String ciudad;
		String pais;
		String contacto;
		if (proveedor!= null) {
			id = proveedor.getId();
			empresa = proveedor.getEmpresa();
			ciudad = proveedor.getCiudad();
			pais = proveedor.getPais();
			contacto = proveedor.getContacto();
			
			conexion.SQL("Update proveedores set empresa = ?, ciudad = ?, pais = ?, contacto = ? where id=?");
			conexion.preparedStatement().setString(1, empresa);
			conexion.preparedStatement().setString(2, ciudad);
			conexion.preparedStatement().setString(3,  pais);
			conexion.preparedStatement().setString(4,  contacto);
			conexion.preparedStatement().setInt(5, id);
			conexion.CUD();
			
		}
		
	}
	
	public void updateEmpresa(proveedores proveedor, String empresa) throws Throwable {
		int id;
		
		if (proveedor!= null) {
			id = proveedor.getId();
			//empresa = proveedor.getEmpresa();
			
			conexion.SQL("Update proveedores set empresa = ? where id=?");
			conexion.preparedStatement().setString(1, empresa);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();
			
		}
		
	}
	
	public void updateCiudad(proveedores proveedor, String ciudad) throws Throwable {
		int id;
		
		if (proveedor!= null) {
			id = proveedor.getId();
			//ciudad = proveedor.getCiudad();
			
			conexion.SQL("Update proveedores set ciudad = ? where id=?");
			conexion.preparedStatement().setString(1, ciudad);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();
			
		}
		
	}
	
	public void updatePais(proveedores proveedor, String pais) throws Throwable {
		int id;
		
		if (proveedor!= null) {
			id = proveedor.getId();
			//pais = proveedor.getPais();
			
			conexion.SQL("Update proveedores set pais = ? where id=?");
			conexion.preparedStatement().setString(1, pais);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();
			
		}
		
	}
	
	public void updateContacto(proveedores proveedor, String contacto) throws Throwable {
		int id;
		
		if (proveedor!= null) {
			id = proveedor.getId();
			//contacto = proveedor.getContacto();
			
			conexion.SQL("Update proveedores set contacto = ? where id=?");
			conexion.preparedStatement().setString(1, contacto);
			conexion.preparedStatement().setInt(2, id);
			conexion.CUD();
			
		}
		
	}
	
}