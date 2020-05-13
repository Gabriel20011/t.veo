package co.edu.unbosque.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import co.edu.unbosque.model.Persona;
import co.edu.unbosque.model.ProcesarBaseDeDatos;
import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.Venta;
import co.edu.unbosque.model.VentaProductos;

@ManagedBean
@SessionScoped
public class IniciarSesion {
	private String usuario;
	private String contraseña;
	private FacesContext context;

	
	Persona persona = new Persona();
	ProcesarBaseDeDatos consultar = new ProcesarBaseDeDatos();
	
	

	public IniciarSesion() {
		// TODO Auto-generated constructor stub
	}


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public void ini() {
		context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		persona.setUsuario(usuario);
		persona.setContraseña(contraseña);
		System.out.println("entro");
		Persona p = new Persona();
		p = consultar.buscar(persona);
		if(p!=null) {
			try {
				if(p.getTipo().equals("CLIENTE")) {
					context.getExternalContext().redirect("Ventas.xhtml");
				context.getExternalContext().getSessionMap().put("nombre", p.getUsuario());
				context.getExternalContext().getSessionMap().put("usuario",p );
				context.getExternalContext().getSessionMap().put("lista", consultar.listaProductos(p));
				}else if(p.getTipo().equals("ADMINISTRADOR")){
					context.getExternalContext().redirect("Administrador.xhtml");
					context.getExternalContext().getSessionMap().put("usuario",p);
					context.getExternalContext().getSessionMap().put("lista", consultar.listaProductos(p));
				}else if(p.getTipo().equals("VENDEDOR")){
					context.getExternalContext().redirect("Vendedor.xhtml");
					context.getExternalContext().getSessionMap().put("usuario",p);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
		}
	}
	public void detalles(Producto pe) {
		context = FacesContext.getCurrentInstance();
		Producto p = consultar.detalles(pe);
		context.getExternalContext().getSessionMap().put("producto", p);
		try {
			context.getExternalContext().redirect("Ventas.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Agregar(Producto p) {
		context = FacesContext.getCurrentInstance();
		HttpSession session= (HttpSession) context.getExternalContext().getSession(true);
		ArrayList<Producto>ingresados;
		ingresados = (ArrayList<Producto>) session.getAttribute("carrito");
		if(ingresados == null) {
			ingresados  = new ArrayList<Producto>();

		}
		if(p!=null) {
			ingresados.add(p);
			context.getExternalContext().getSessionMap().put("info", "SE AGREGO CORRECTAMENTE: ("+p.getNombre()+") AL CARRITO");
			context.getExternalContext().getSessionMap().put("carrito", ingresados);
		}
		try {
			context.getExternalContext().redirect("Ventas.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Eliminar(Producto p) {
		context = FacesContext.getCurrentInstance();
		HttpSession session= (HttpSession) context.getExternalContext().getSession(true);
		ArrayList<Producto>ingresados;
	    ingresados = (ArrayList<Producto>) session.getAttribute("carrito");
		if(ingresados == null) {
			ingresados  = new ArrayList<Producto>();

		}
		if(p!=null) {
			ingresados.remove(p);
			try {
				context.getExternalContext().redirect("Ventas.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void agregarVenta(Venta v,String nombre) {
		context = FacesContext.getCurrentInstance();
		HttpSession session= (HttpSession) context.getExternalContext().getSession(true);
		ArrayList<Producto>productos;
		productos = (ArrayList<Producto>) session.getAttribute("carrito");
		Date f = new Date();
		SimpleDateFormat plantilla = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = plantilla.format(f);
		int total = 0;
		String ip="";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < productos.size(); i++) {
			total = productos.get(i).getCosto()* productos.get(i).getCantidad();
			VentaProductos venta = new VentaProductos(nombre, productos.get(i).getNombre(), v.getDireccion(), "COMPRA", fecha, productos.get(i).getCantidad(), total, v.getMetodoPago(), v.getVendedor(), ip);
			consultar.agregarVenta(venta);
			System.out.println(venta.toString());
		}
		
	}
	public void cerrarSesion() {
		FacesContext context = FacesContext.getCurrentInstance();
    	context.getExternalContext().invalidateSession();
        try {
			context.getExternalContext().redirect("VentanaPrincipal.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void verLista(PersonaBean per){
		context = FacesContext.getCurrentInstance();
		Persona p = new Persona();
		p.setCiudad(per.getCiudad());
		context.getExternalContext().getSessionMap().put("lista", consultar.listaProductos(p));
		try {
			context.getExternalContext().redirect("Gerente.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


