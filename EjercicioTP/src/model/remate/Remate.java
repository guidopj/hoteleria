package model.remate;

import model.cliente.Cliente;
import model.date.Date;
import model.estadoRemate.EstadoRemate;
import model.excepciones.PrecioMenorAlActualException;
import model.excepciones.RemateFinalizadoException;
import model.habitacion.Habitacion;
import model.hotel.Hotel;

public class Remate {

	//******************************************************************** Variables de instancia *************************************************************
	
	private Hotel hotelDeLaSubasta;
	private Habitacion habitacionDeLaSubasta;
	private EstadoRemate estado;
	private Date inicioEstadia;
	private Date finEstadia;
	private Date inicioRemate;
	private Date finRemate;
	private int precio;
	private Cliente ganador;
	
	//*********************************************************************************************************************************************************
	
	//******************************************************************** Constructor Remate *****************************************************************
	
	public Remate(Hotel hotel, Habitacion habitacion, Date inicioEstadia, Date finEstadia, Date inicioRemate, Date finRemate){
		this.hotelDeLaSubasta = hotel;
		this.habitacionDeLaSubasta = habitacion;
		this.inicioEstadia = inicioEstadia;
		this.finEstadia = finEstadia;
		this.estado = new RemateActivo();
		this.finRemate = finRemate;
		this.precio = 0;
		this.ganador = null;
	}

	//*********************************************************************************************************************************************************
	
	//******************************************************************** Getters y setters ******************************************************************
	
	public EstadoRemate getEstado() {
		return this.estado;
	}

	public int getPrecio() {
		return this.precio;
	}

	public Cliente getGanador() {
		return this.ganador;
	}

	public Date getInicioRemate() {
		return this.inicioRemate;
	}

	public Date getFinRemate() {
		return this.finRemate;
	}

	public Date getInicioEstadia() {
		return this.inicioEstadia;
	}

	public Date getFinEstadia() {
		return this.finEstadia;
	}

	public Hotel getHotelDeLaSubasta() {
		return this.hotelDeLaSubasta;
	}

	public Habitacion getHabitacionDeLaSubasta() {
		return this.habitacionDeLaSubasta;
	}
	
	public void setPrecio(int i) {
		this.precio = i;
	}

	public void setCliente(Cliente cliente) {
		this.ganador = cliente;
	}
	
	//*********************************************************************************************************************************************************
	
	//********************************************************* Metodo para finalizar una subasta *************************************************************
	/*
	 Finaliza el remate.
	 */
	public void finalizarRemate() {
		this.estado = new RemateFinalizado();		
	}

	
	//*********************************************************************************************************************************************************
	
	//********************************************************* Metodo para ofertar en una subasta ************************************************************
	/*
	 Realiza una oferta si la subasta esta
	 activa, sino lanza una excepcion
	 indicando que la subasta finalizo, o si
	 se oferto con un monto menor al actual.
	 */
	
	public void ofertar(Cliente cliente, int i) throws RemateFinalizadoException, PrecioMenorAlActualException {
		this.estado.realizarOferta(this, cliente, i);
		/*
		try{
			this.estado.realizarOferta(this, cliente, i);
		}
		catch(RemateFinalizadoException e){
			System.out.println(e);
		}
		catch(PrecioMenorAlActualException e){
			System.out.println(e);
		}
		*/
	}
	
	//*********************************************************************************************************************************************************
}
