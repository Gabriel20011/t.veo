package co.edu.unbosque.model;

public class Producto { 
	private String nombre,sede,link,categoria;
	private int costo,cantidad,vendidos;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, String sede, String link, String categoria, int costo, int cantidad, int vendidos) {
		this.nombre = nombre;
		this.sede = sede;
		this.link = link;
		this.categoria = categoria;
		this.costo = costo;
		this.cantidad = cantidad;
		this.vendidos = vendidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getVendidos() {
		return vendidos;
	}
	public void setVendidos(int vendidos) {
		this.vendidos = vendidos;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", sede=" + sede + ", link=" + link + ", categoria=" + categoria
				+ ", costo=" + costo + ", cantidad=" + cantidad + ", vendidos=" + vendidos + "]";
	}
	

}
