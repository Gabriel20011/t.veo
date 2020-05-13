package co.edu.unbosque.model;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class ProcesarBaseDeDatos extends Conexion{
	Statement miStatement = null;
	Connection conexion;
	ResultSet miResultSet = null;
	Persona aux;
	
	
	
	
	
	//Registar usuario
	public int registrar(Persona persona){
		int result=0;
		
		conexion = ConectarBaseDeDatos();
		
		try {		
			String query = "INSERT INTO Usuarios(Nombre, Apellido, Edad, Documento, Correo, Ciudad, Usuario,Contraseña,Numero_Tarjeta,Tipo_Usuario) VALUES"
					
					+ " ('"+persona.getNombre()+"',"
					+ "'"+ persona.getApellido() +"',"
					+ "'"+ persona.getEdad()+"',"
					+ "'"+ persona.getDocumento() +"',"
					+ "'"+ persona.getCorreo() +"',"
					+ "'"+ persona.getCiudad() +"',"
					+"'"+ persona.getUsuario() +"'," 
					+"'"+ persona.getContraseña()+"',"
					+"'"+ persona.getTarjeta()+"',"
					+"'VENDEDOR'"+")";
			
			PreparedStatement pst = conexion.prepareStatement(query);
			System.out.println(query);
			result = pst.executeUpdate();
			conexion.close();
			pst.close();
		} catch (Exception e) {
			System.out.println("error aca"+e.getMessage());
		}
		return result;
		
		
	}
	public Persona buscar(Persona usuario) {
		conexion = ConectarBaseDeDatos();

		try {
			miStatement = conexion.createStatement();
			miResultSet = miStatement.executeQuery("SELECT * FROM Usuarios WHERE Usuario='" + usuario.getUsuario() + "'" + " AND Contraseña = '" + usuario.getContraseña()+ "'");
			while (miResultSet.next()) {
				aux = new Persona();
				aux.setUsuario(miResultSet.getString("Usuario"));
				aux.setNombre(miResultSet.getString("Nombre"));
				aux.setCiudad(miResultSet.getString("Ciudad"));
				aux.setApellido(miResultSet.getString("Apellido"));
				aux.setEdad(miResultSet.getString("Edad"));
				aux.setTarjeta(miResultSet.getString("Numero_Tarjeta"));
				aux.setCorreo(miResultSet.getString("Correo"));
				aux.setTipo(miResultSet.getString("Tipo_Usuario"));
			}		
			conexion.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return aux;		
	}
	public ArrayList<Producto> listaProductos(Persona p){
		conexion = ConectarBaseDeDatos();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			miStatement = conexion.createStatement();
			miResultSet = miStatement.executeQuery("SELECT * FROM Productos WHERE Sede='" + p.getCiudad()+"'");
			
			while (miResultSet.next()) {
				productos.add(new Producto(miResultSet.getString("Nombre"), miResultSet.getString("Sede"), miResultSet.getString("Link"), miResultSet.getString("Categoria"), miResultSet.getInt("Costo"), miResultSet.getInt("Cantidad"),  miResultSet.getInt("Vendidos")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return productos;
		
	}
	public Producto detalles(Producto nombre) {
		Producto p = new Producto();	
		try {
			miStatement = conexion.createStatement();
			miResultSet = miStatement.executeQuery("SELECT * FROM Productos WHERE Nombre='" +nombre.getNombre()+"' AND Sede ='"+nombre.getSede()+"'");
			miResultSet.next();
			
				p = new Producto(miResultSet.getString("Nombre"), miResultSet.getString("Sede"), miResultSet.getString("Link"), miResultSet.getString("Categoria"), miResultSet.getInt("Costo"), miResultSet.getInt("Cantidad"),  miResultSet.getInt("Vendidos"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		
	}
	
	public void agregarVenta(VentaProductos p) {
		
		SessionFactory fabrica = new Configuration().configure().addAnnotatedClass(VentaProductos.class).buildSessionFactory();
		Session sesion = fabrica.getCurrentSession();
		
		try {
			
			sesion.beginTransaction();
			
			sesion.save(p);
			
			sesion.getTransaction().commit();
			
		} finally {
			// TODO: handle finally clause
			fabrica.close();
		}
	}
	
}