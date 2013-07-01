package model.hotelTest;

import model.date.Date;
import model.calificacion.Calificacion;
import model.habitacion.Habitacion;
import model.hotel.Hotel;
import model.hotelero.Hotelero;
import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

import java.util.*;

public class HotelTest extends TestCase {

	private Hotel hotel;
	private Habitacion habitacion1;
	private Habitacion habitacion2;
	private List<Habitacion> habitaciones;
	private Date entrada;
	private Date salida;
	private Hotelero hotelero;
	
	//*************************************************************** Set Up ****************************************************************************
	
	public void setUp(){
		this.hotelero = mock(Hotelero.class);
		when(this.hotelero.getNombre()).thenReturn("Julian");
		
		this.habitacion1 = mock(Habitacion.class);
		this.habitacion2 = mock(Habitacion.class);
		this.habitaciones = new ArrayList<Habitacion>();
		this.habitaciones.add(habitacion1);
		
		this.entrada = mock(Date.class);
		this.salida = mock(Date.class);
		when(this.habitacion1.estaDisponibleEn(this.entrada, this.salida, 2, true)).thenReturn(true);
		when(this.habitacion2.estaDisponibleEn(this.entrada, this.salida, 2, false)).thenReturn(false);
		
		this.hotel = new Hotel("Condor", "Argentina", "Buenos Aires", "Comandante Franco 1019", "4-259-4889", "skalic.julian@gmail.com", this.hotelero);
	}
	//***************************************************************************************************************************************************

	//******************************************************** Test de los getters del hotel ************************************************************

	public void testGetNombre(){
		String nombreEsperado = "Condor";
		String nombreHotel = hotel.getNombre();
		Assert.assertEquals(nombreEsperado, nombreHotel);
	}
	
	public void testGetPais(){
		String paisEsperado = "Argentina";
		String paisHotel = hotel.getPais();
		Assert.assertEquals(paisEsperado, paisHotel);
	}
	
	public void testGetCiudad(){
		String ciudadEsperada = "Buenos Aires";
		String ciudadHotel = hotel.getCiudad();
		Assert.assertEquals(ciudadEsperada, ciudadHotel);
	}
	
	public void testGetDireccion(){
		String direccionEsperada = "Comandante Franco 1019";
		String direccionHotel = hotel.getDireccion();
		Assert.assertEquals(direccionEsperada, direccionHotel);
	}
	
	public void testGetTelefono(){
		String telefonoEsperado = "4-259-4889";
		String telefonoHotel = hotel.getTelefono();
		Assert.assertEquals(telefonoEsperado, telefonoHotel);
	}
	
	public void testGetEmail(){
		String emailEsperado = "skalic.julian@gmail.com";
		String emailHotel = hotel.getEmail();
		Assert.assertEquals(emailEsperado, emailHotel);
	}
	
	public void testGetHotelero(){
		Hotelero hoteleroEsperado = this.hotelero;
		Hotelero hoteleroHotel = this.hotel.getHotelero();
		Assert.assertEquals(hoteleroEsperado, hoteleroHotel);
	}
	//***************************************************************************************************************************************************

	
	public void testAgregarHabitacionYGetHabitacion(){
		this.hotel.agregarHabitacion(this.habitacion1);
		List<Habitacion> habitacionesHotel = this.hotel.getHabitaciones();
		Assert.assertEquals(this.habitaciones, habitacionesHotel);
	}
	
	//************************************************** Test de las habitaciones disponibles en el hotel ***********************************************
	/*
	 Testea que retorne las habitaciones disponibles segun
	 el criterio de busqueda que un usuario realize.
	 */
	
	public void testHabitacionesDisponibles(){
		this.hotel.agregarHabitacion(this.habitacion1);
		this.hotel.agregarHabitacion(this.habitacion2);
		List<Habitacion> habitacionesDisponiblesEsperado = new ArrayList<Habitacion>();
		habitacionesDisponiblesEsperado.add(this.habitacion1);
		List<Habitacion> habitacionesDisponiblesHotel = this.hotel.buscarHabitacionesDisponiblesPara(this.entrada, this.salida, 2, true);
		Assert.assertEquals(habitacionesDisponiblesEsperado, habitacionesDisponiblesHotel);
	}
	//***************************************************************************************************************************************************
	
	//************************************************** Test para calificar a un hotel *****************************************************************
	/*
	 Testea que una calificacion es realizada
	 por un usuario al hotel.
	 */
	
	public void testCalificar(){
		this.hotel.calificar(10, "Excelente atencion");
		Calificacion calificacionHotel = this.hotel.getCalificaciones().get(0);  //Al estar vacia la lista de calificaciones, tomo la primera y me fijo que califico correctamente
		int calificacionEsperada = 10;
		String comentarioEsperado = "Excelente atencion";
		Assert.assertEquals(comentarioEsperado, calificacionHotel.getComentario());
		Assert.assertEquals(calificacionEsperada, calificacionHotel.getCalificacion());
	}
	//***************************************************************************************************************************************************
	
	//************************************************** Test obtener comentarios del hotel *************************************************************
	/*
	 Testea que retorne todos los comentarios
	 del hotel.
	 */
	
	public void testComentarios(){
		this.hotel.calificar(10, "Excelente atencion");
		List<String> comentariosEsperados = new ArrayList<String>();
		comentariosEsperados.add("Excelente atencion");
		List<String> comentariosHotel = this.hotel.comentarios();
		Assert.assertEquals(comentariosEsperados, comentariosHotel);
	}
	//***************************************************************************************************************************************************
	
	//************************************************** Test obtener calificacion del hotel ************************************************************
	/*
	 Testea que retorne la calificacion
	 total del hotel.
	 */
	
	public void testCalificacion(){
		this.hotel.calificar(10, "Excelente atencion");
		this.hotel.calificar(20, "Excelente atencion");
		int calificacionEsperada = 30;
		int calificacionHotel = this.hotel.getCalificacion();
		Assert.assertEquals(calificacionEsperada, calificacionHotel);
	}
	//***************************************************************************************************************************************************
	
	
}
