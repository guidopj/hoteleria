package model.habitacionTest;



import model.date.Date;
import model.habitacion.Habitacion;
import model.rangeOfDate.Periodo;
import model.servicio.Servicio;
import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import java.util.*;

public class HabitacionTest extends TestCase{

	private Habitacion habitacion1;
	private Habitacion habitacion2;
	private Habitacion habitacion3;
	private Periodo rango;
	private List<Periodo> rangosNoDisponibles;
	private Date entradaHabitacion;
	private Date salidaHabitacion;
	private Servicio servicio1;
	private Servicio servicio2;
	private List<Servicio> servicios;
	
	//*************************************************************** Set Up ****************************************************************************
	public void setUp(){
		this.entradaHabitacion = mock(Date.class);
		this.salidaHabitacion = mock(Date.class);
		
		this.servicios = new ArrayList<Servicio>();
		this.servicio1 = mock(Servicio.class);
		this.servicio2 = mock(Servicio.class);
		when(this.servicio1.getNombre()).thenReturn("WIFI");
		this.servicios.add(this.servicio1);
		
		this.habitacion1 = new Habitacion(2, 180, true, this.servicios);
		this.habitacion2 = new Habitacion(2, 180, false, this.servicios);
		this.habitacion3 = new Habitacion(5, 180, false, this.servicios);
		
		this.rangosNoDisponibles = new ArrayList<Periodo>();
		this.rango = mock(Periodo.class);
		when(this.rango.seSuperpone(this.entradaHabitacion, this.salidaHabitacion)).thenReturn(true);
		this.rangosNoDisponibles.add(this.rango);
	}
	//***************************************************************************************************************************************************
	
	//*************************************************** Test de los getters de Habitacion *************************************************************
	public void testGetCapacidadMaxima(){
		int capacidadEsperada = 5;
		int capacidadHabitacion = this.habitacion3.getCapacidadMaxima();
		Assert.assertEquals(capacidadEsperada, capacidadHabitacion);
	}
	
	public void testGetServicios(){
		List<Servicio> serviciosEsperados = this.servicios;
		List<Servicio> serviciosHabitacion = this.habitacion1.getServicios();
		Assert.assertEquals(serviciosEsperados, serviciosHabitacion);
	}
	
	public void testGetPrecioPorNoche(){
		float precioEsperado = 180;
		float precioHabitacion = this.habitacion1.getPrecioPorNoche();
		Assert.assertEquals(precioEsperado, precioHabitacion);
	}
	
	public void testGetRangosNoDisponibles(){
		List<Periodo> rangosEsperados = this.rangosNoDisponibles;
		this.habitacion1.agregarNoDisponibilidad(this.rango);
		List<Periodo> rangosHabitacion = this.habitacion1.getRangosNoDisponibles();
		Assert.assertEquals(rangosEsperados, rangosHabitacion);
	}
	
	//***************************************************************************************************************************************************
	
	//*************************************************************** Test posee el servicio ************************************************************
	/*
	 Testea que el srvicio que se pasa
	 este incluido en su lista de 
	 servicios de la habitacion 
	 */
	
	public void testPoseeElServicio(){
		boolean poseeServicioHabitacion = this.habitacion1.poseeElServicio(this.servicio1);
		Assert.assertTrue(poseeServicioHabitacion);
	}
	//***************************************************************************************************************************************************
	
	//****************************************************** Test agregar servicios a la habitacion *****************************************************
	/*
	 Testea que se agrege
	 el servicio a la habitacion requerida.
	 */
	
	public void testAgregarServicio(){
		List<Servicio> serviciosEsperados = new ArrayList<Servicio>();
		serviciosEsperados.add(this.servicio1);						
		serviciosEsperados.add(this.servicio2);
		this.habitacion1.agregarServicio(this.servicio1);			//Lo agrego por seguna vez para verificar que solo lo agrega una unica vez y no hay repetidos
		this.habitacion1.agregarServicio(this.servicio2);
		List<Servicio> serviciosHabitacion = this.habitacion1.getServicios();
		Assert.assertEquals(serviciosEsperados, serviciosHabitacion);
	}
	//***************************************************************************************************************************************************
	
	//****************************************************** Test agregar no disponiblidad de habitacion ************************************************
	/*
	 Testea que se agrege la no disponibilidad
	 de la habitacion. Es decir, agrega un rango
	 donde la habitacion no estara disponible. 
	 */
	
	public void testAgregarNoDisponibilidad(){
		this.habitacion1.agregarNoDisponibilidad(this.rango);
		List<Periodo> rangosHabitacion = this.habitacion1.getRangosNoDisponibles();
		Assert.assertEquals(this.rangosNoDisponibles, rangosHabitacion);
	}
	//***************************************************************************************************************************************************
	
	//******************************************************** Test esta disponible en *******************************************************************
	/*
	 Testea que la habitacion etste disponible
	 entre dos fechas especificas.
	 */
	
	public void testEstaDisponibleEntre(){
		this.habitacion1.agregarNoDisponibilidad(this.rango);
		boolean disponibleHabitacion1 = this.habitacion1.estaDisponibleEntre(this.entradaHabitacion, this.salidaHabitacion);
		boolean disponibleHabitacion2 = this.habitacion2.estaDisponibleEntre(this.entradaHabitacion, this.salidaHabitacion);
		Assert.assertTrue(disponibleHabitacion2);
		Assert.assertFalse(disponibleHabitacion1);
	}
	
	/*
	 Testea que la habitacion este disponible
	 para la cantidad de pasajeros requeridos,
	 y si tiene cama matrimonial o no.
	 */
	
	public void testEstaDisponiblePara(){
		boolean habitacion3DisponiblePara = this.habitacion3.estaDisponiblePara(10, false);
		boolean habitacion1DisponiblePara = this.habitacion1.estaDisponiblePara(2, true);
		Assert.assertTrue(habitacion1DisponiblePara);
		Assert.assertFalse(habitacion3DisponiblePara);
	}
	
	/*
	 Testea que se cumpla con las dos
	 condiciones anteriores.
	 */
	
	public void testEstaDisponibleEn(){
		this.habitacion1.agregarNoDisponibilidad(this.rango);
		boolean disponibleHabitacion1 = this.habitacion1.estaDisponibleEn(this.entradaHabitacion, this.salidaHabitacion, 2, true);
		boolean disponibleHabitacion2 = this.habitacion2.estaDisponibleEn(this.entradaHabitacion, this.salidaHabitacion, 2, false);
		Assert.assertTrue(disponibleHabitacion2);
		Assert.assertFalse(disponibleHabitacion1);
	}
	//***************************************************************************************************************************************************
}
