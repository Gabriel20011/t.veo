package co.edu.unbosque.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import co.edu.unbosque.model.Persona;
import co.edu.unbosque.model.ProcesarBaseDeDatos;

@ManagedBean
@RequestScoped
public class PersonaBean {
	private String nombre,documento,apellido,correo,ciudad,usuario,contraseña,edad,tarjeta;
	private FacesContext context;
	String mensaje;
	Persona persona = new Persona();
	ProcesarBaseDeDatos registrar = new ProcesarBaseDeDatos();
	 
	public PersonaBean() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
	
	
	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String registrar() {
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEdad(edad);
		persona.setDocumento(documento);
		persona.setCorreo(correo);
		persona.setCiudad(ciudad);
		persona.setUsuario(usuario);
		persona.setContraseña(contraseña);
		persona.setTarjeta(tarjeta);
		registrar.registrar(persona);
		
		return "/VentanaPrincipal.xhtml?faces-redirect=true";
	}
	
}
