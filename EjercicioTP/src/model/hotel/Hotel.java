package model.hotel;

import model.date.Date;
import model.calificacion.Calificacion;
import model.habitacion.Habitacion;
import model.hotelero.Hotelero;

import java.util.*;

public class Hotel {

	//******************************************************************** Variables de instancia *************************************************************
	
	private String nombre;
	private String pais;
	private String ciudad;
	private String direccion;
	private String telefono;
	private String email;
	private List<Habitacion> habitaciones;
	private List<Calificacion> calificaciones;
	private Hotelero hotelero;
	
	//*********************************************************************************************************************************************************
	
	//******************************************************************** Constructor Hotel ******************************************************************
	
	public Hotel(String nombreHotel, String nombrePais, String nombreCiudad, String nombreDireccion, String telefonoHotel, String emailHotel, Hotelero hotelero) {
		this.nombre = nombreHotel;
		this.pais = nombrePais;
		this.ciudad = nombreCiudad;
		this.direccion = nombreDireccion;
		this.telefono = telefonoHotel;
		this.email = emailHotel;
		this.habitaciones = new ArrayList<Habitacion>();
		this.calificaciones = new ArrayList<Calificacion>();
		this.hotelero = hotelero;
	}
	
	//*********************************************************************************************************************************************************
	
	//******************************************************************** Getters y setters ******************************************************************
	
	public String getNombre() {
		return this.nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public List<Habitacion> getHabitaciones() {
		return this.habitaciones;
	}
	
	public Hotelero getHotelero() {
		return this.hotelero;
	}
	
	public List<Calificacion> getCalificaciones() {
		return this.calificaciones;
	}
	
	public void agregarHabitacion(Habitacion habitacion1) {
		this.habitaciones.add(habitacion1);
	}

	//*********************************************************************************************************************************************************
	
	//********************************************************* Metodo para buscar habitaciones disponibles ***************************************************
	/*
	 Busca las habitaciones disponibles en el hotel
	 para una fecha de entrada y salida determinada,
	 para una cantidad de pasajeros definida y en caso
	 de ser dos, si quiere o no cama matrimonial. 
	 */
	
	public List<Habitacion> buscarHabitacionesDisponiblesPara(Date entrada, Date salida, int pasajeros, boolean camaMatri) {
		List<Habitacion> habitacionesDisponibles = new ArrayList<Habitacion>();
		for(Habitacion hab: this.habitaciones){
			if(hab.estaDisponibleEn(entrada, salida, pasajeros, camaMatri)){
				habitacionesDisponibles.add(hab);
			}
		}
		return habitacionesDisponibles;
	}
	
	//*********************************************************************************************************************************************************

	//********************************************************* Metodo para calificar al hotel ****************************************************************
	/*
	 Agrega una calificacion a su lista
	 de calificaciones del hotel.
	 */
	
	public void calificar(int calificacion, String comentario) {
		this.calificaciones.add(new Calificacion(calificacion, comentario));
	}
	
	//*********************************************************************************************************************************************************

	//*********************************************** Metodo para obtener los comentarios del hotel ***********************************************************
	/*
	 Retorna una lista con todos los
	 comentarios que recibio el hotel.
	 */
	
	public List<String> comentarios() {
		List<String> comentarios = new ArrayList<String>();
		for(Calificacion cal:this.calificaciones){
			comentarios.add(cal.getComentario());
		}
		return comentarios;
	}
	
	//*********************************************************************************************************************************************************

	//************************************************ Metodo para obtener la calificacion total del hotel ****************************************************
	/*
	 Retorna la calificacion total, de
	 todas las calificacions que recibio
	 el hotel.
	 */
	
	public int getCalificacion() {
		int calificacion = 0;
		for(Calificacion cal:this.calificaciones){
			calificacion = calificacion + cal.getCalificacion();
		}
		return calificacion;
	}

	//*********************************************************************************************************************************************************
}
