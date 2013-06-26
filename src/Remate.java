
public class Remate {
	
	private Habitacion habitacion;
	private Date inicio,fin;
	private Date ingreso,egreso;
	private double precioActual;
	private Cliente ganador;
	
	public Remate(Habitacion h,Date inicio, Date fin, Date ingreso, Date egreso,Cliente c){
		
		super();
		this.habitacion = h;
		this.inicio = inicio;
		this.fin = fin;
		this.ingreso = ingreso;
		this.egreso = egreso;
		this.precioActual = 0.0;
		this.ganador = c;
	}

	public Habitacion getHabitacion() {
		// TODO Auto-generated method stub
		return this.habitacion;
	}

	public Date getInicioSubasta() {
		// TODO Auto-generated method stub
		return this.inicio;
	}

	public Date getFinSubasta() {
		// TODO Auto-generated method stub
		return this.fin;
	}

	public Date getIngreso() {
		// TODO Auto-generated method stub
		return this.ingreso;
	}
	
	public Date getEgreso() {
		// TODO Auto-generated method stub
		return this.egreso;
	}

	public double getPrecioActual() {
		// TODO Auto-generated method stub
		return this.precioActual;
	}

	public Cliente getGanador() {
		// TODO Auto-generated method stub
		return this.ganador;
	}

	public void ofertar(double monto, Cliente cliente) {
		if(monto >= (this.getPrecioActual() + 10.0)){
			this.precioActual = monto;
			this.ganador = cliente;
		}
		else{
			System.out.print("Para ofertar tiene que subir el precio actual al menos en 10$");
		}
		
	}

}
