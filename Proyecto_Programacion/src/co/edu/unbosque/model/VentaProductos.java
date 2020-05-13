package co.edu.unbosque.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ventas")
public class VentaProductos {
	
	@Column(name="numero")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numero;
	
	@Id
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="producto")
	private String producto;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fechaPedido")
	private String fechaPedido;
	
	@Column(name="cantidad")
	private int catidad;
	
	@Column(name="total")
	private int total;
	
	@Column(name="metodoPago")
	private String metodoPago;
	
	@Column(name="vendedor")
	private String vendedor;
	
	@Column(name="ip")
	private String ip;

	public VentaProductos() {
		// TODO Auto-generated constructor stub
	}
	

	public VentaProductos(String usuario, String producto, String direccion, String estado, String fechaPedido,
			int catidad, int total, String metodoPago, String vendedor, String ip) {
		this.usuario = usuario;
		this.producto = producto;
		this.direccion = direccion;
		this.estado = estado;
		this.fechaPedido = fechaPedido;
		this.catidad = catidad;
		this.total = total;
		this.metodoPago = metodoPago;
		this.vendedor = vendedor;
		this.ip = ip;
	}


	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public int getCatidad() {
		return catidad;
	}

	public void setCatidad(int catidad) {
		this.catidad = catidad;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	@Override
	public String toString() {
		return "VentaProductos [numero=" + numero + ", usuario=" + usuario + ", producto=" + producto + ", direccion="
				+ direccion + ", estado=" + estado + ", fechaPedido=" + fechaPedido + ", catidad=" + catidad
				+ ", total=" + total + ", metodoPago=" + metodoPago + ", vendedor=" + vendedor + ", ip=" + ip + "]";
	}
	
	

}
