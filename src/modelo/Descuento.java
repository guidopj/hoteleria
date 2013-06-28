import java.util.ArrayList;


public class Descuento {
	
	private ArrayList habitaciones;
	private Date desde,hasta;
	private double porcentaje;
	
	public Descuento(Date desde, Date hasta, double porcentaje){
		super();
		this.habitaciones = new ArrayList();
		this.desde = desde;
		this.hasta = hasta;
		this.porcentaje = porcentaje;
	}

	public Descuento(ArrayList habitaciones, Date desde, Date hasta,
			double porcentaje) {
		super();
		this.habitaciones = habitaciones;
		this.desde = desde;
		this.hasta = hasta;
		this.porcentaje = porcentaje;
	}



	public ArrayList getHabitaciones() {
		return this.habitaciones;
	}

	public Date getDesde() {
		return this.desde;
	}

	public Date getHasta() {
		return this.hasta;
	}

	public double getPorcentaje() {
		return this.porcentaje;
	}

	public void agregarHabitacion(Habitacion unaHabitacion) {
		this.habitaciones.add(unaHabitacion);
		
	}

	public void quitarHabitacion(Habitacion unaHabitacion) {
		this.habitaciones.remove(unaHabitacion);
		
	}

	public void setHabitaciones(ArrayList xs) {
		this.habitaciones = xs;
	}

}
