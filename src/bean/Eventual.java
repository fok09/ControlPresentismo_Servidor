package bean;

public class Eventual extends Contratacion {
	
	private float cantHoras;
	private float precioHora;
		
	//constructor
	public Eventual(float cantHoras, float precioHora) {
		super();
		this.cantHoras = cantHoras;
		this.precioHora = precioHora;
	}


	public float calcularMonto() {
		
		return this.cantHoras * this.precioHora;
	}

	
	//gets and sets
	public float getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(float cantHoras) {
		this.cantHoras = cantHoras;
	}

	public float getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}
	
}
