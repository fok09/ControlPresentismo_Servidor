package bean;
import java.util.*;
@SuppressWarnings("deprecation")

public class Factura {
	private int nroFactura;
	private float monto;
	private Date fecha;
	private String tipo;
	private boolean pagado;
	private Date fechaPago;
	
	private Cliente cliente;
	private Contratacion contratacion;
	

	
	public void registrarPago() {
		
		this.pagado=true;
	}
	
	//constructor
	public Factura(int nroFactura, float monto, String tipo, Date fechaPago,
			Cliente cliente, Contratacion contratacion) {
		this.nroFactura = nroFactura;
		this.monto = monto;
		this.fecha.getDate();
		this.tipo = tipo;
		this.pagado = false; //cuando se crea la factura figura como impago
		this.fechaPago = fechaPago;
		this.cliente = cliente;
		this.contratacion = contratacion;
	}
	
}
