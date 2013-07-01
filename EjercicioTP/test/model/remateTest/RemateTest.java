package model.remateTest;

import model.cliente.Cliente;
import model.date.Date;
import model.estadoRemate.EstadoRemate;
import model.excepciones.PrecioMenorAlActualException;
import model.excepciones.RemateFinalizadoException;
import model.habitacion.Habitacion;
import model.hotel.Hotel;
import model.remate.Remate;
import model.remate.RemateActivo;
import model.remate.RemateFinalizado;
import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class RemateTest extends TestCase {

	private Remate remateActivo;
	private Remate remateFinalizado;
	private Hotel hotelDeLaSubasta;
	private Habitacion habitacionDeLaSubasta;
	private Date finEstadia;
	private Date inicioEstadia;
	private Date inicioRemate;
	private Date finRemate;
	private Cliente cliente;
	
	//*************************************************************** Set Up ****************************************************************************
	public void setUp(){
		this.cliente = mock(Cliente.class);
		this.inicioRemate = mock(Date.class);
		this.finRemate = mock(Date.class);
		this.hotelDeLaSubasta = mock(Hotel.class);
		this.inicioEstadia = mock(Date.class);
		this.finEstadia = mock(Date.class);
		this.habitacionDeLaSubasta = mock(Habitacion.class);
		this.remateActivo = new Remate(this.hotelDeLaSubasta, this.habitacionDeLaSubasta, this.inicioEstadia, this.finEstadia, this.inicioRemate, this.finRemate);
		this.remateFinalizado = new Remate(this.hotelDeLaSubasta, this.habitacionDeLaSubasta, this.inicioEstadia, this.finEstadia, this.inicioRemate, this.finRemate);
	}
	//***************************************************************************************************************************************************
	
	//******************************************************* Test de getters y setters de Remate *******************************************************
	public void testGetEstado(){
		EstadoRemate estadoRemateActivo = this.remateActivo.getEstado();
		Assert.assertTrue(estadoRemateActivo instanceof RemateActivo);
	}
	
	public void testGetPrecio(){
		int precioEsperado = 0;
		int precioSubasta = this.remateActivo.getPrecio();
		Assert.assertEquals(precioEsperado, precioSubasta);
	}
	
	public void testGetGanador(){
		Assert.assertNull(this.remateActivo.getGanador());
	}
	
	public void testGetInicioRemate(){
		Date inicioRemateEsperado = this.inicioRemate;
		Date inicioRemate = this.remateActivo.getInicioRemate();
		Assert.assertEquals(inicioRemateEsperado, inicioRemate);
	}
	
	public void testGetFinRemate(){
		Date finRemateEsperado = this.finRemate;
		Date finRemate = this.remateActivo.getFinRemate();
		Assert.assertEquals(finRemateEsperado, finRemate);
	}
	
	public void testGetInicioEstadia(){
		Date inicioEstadiaEsperado = this.inicioEstadia;
		Date inicioEstadia = this.remateActivo.getInicioEstadia();
		Assert.assertEquals(inicioEstadiaEsperado, inicioEstadia);
	}
	
	public void testGetFinEstadia(){
		Date finEstadiaEsperado = this.finEstadia;
		Date finEstadia = this.remateActivo.getFinEstadia();
		Assert.assertEquals(finEstadiaEsperado, finEstadia);
	}
	
	public void testGetHotelSubasta(){
		Hotel hotelEsperado = this.hotelDeLaSubasta;
		Hotel hotelsubasta = this.remateActivo.getHotelDeLaSubasta();
		Assert.assertEquals(hotelEsperado, hotelsubasta);
	}
	
	public void testGetHabitacionSubasta(){
		Habitacion habitacionEsperada = this.habitacionDeLaSubasta;
		Habitacion habitacionSubasta = this.remateActivo.getHabitacionDeLaSubasta();
		Assert.assertEquals(habitacionEsperada, habitacionSubasta);
	}
	
	public void testSetPrecio(){
		this.remateActivo.setPrecio(100);
		int precioEsperado = 100;
		int precioSubasta = this.remateActivo.getPrecio();
		Assert.assertEquals(precioEsperado, precioSubasta);
	}
	
	public void testSetCliente(){
		this.remateActivo.setCliente(this.cliente);
		Cliente clienteEsperado = this.cliente;
		Cliente clienteGanador = this.remateActivo.getGanador();
		Assert.assertEquals(clienteEsperado, clienteGanador);
	}
	
	//**************************************************************************************************************************************************
	
	//********************************************************* Test de finalizar un remate ************************************************************
	/*
	 Testea que el remate sea finalizado
	 */
	
	public void testFinalizarRemate(){
		this.remateFinalizado.finalizarRemate();
		EstadoRemate estadoRemateFinalizado = this.remateFinalizado.getEstado();
		Assert.assertTrue(estadoRemateFinalizado instanceof RemateFinalizado);
	}
	//**************************************************************************************************************************************************
	
	//********************************************************* Test de ofertar en un remate ************************************************************
	/*
	 Testea, para una oferta activa, que se
	 realiza la oferta de un cliente con un
	 monto superir al actual, como debe ser.
	 */
	public void testOfertarRemateActivo(){
		try{
			this.remateActivo.ofertar(this.cliente, 100);
			Cliente clienteEsperado = this.cliente;
			Cliente clienteGanador = this.remateActivo.getGanador();
			int precioEsperado = 100;
			int precioSubasta = this.remateActivo.getPrecio();
			Assert.assertEquals(clienteEsperado, clienteGanador);
			Assert.assertEquals(precioEsperado, precioSubasta);
		} catch(PrecioMenorAlActualException e){
			fail("No tendria que capturar excepcion");
		} catch (RemateFinalizadoException e) {
			fail("No tendria que capturar excepcion");
		}
	}
	
	/*
	 Testea, para una oferta activa, que la 
	 oferta realizada por un cliente, no se
	 realiza, ya que el monto de la oferta
	 es menor al actual en la subasta.
	 */
	public void testOfertarRemateActivoConPrecioMenorASubasta(){
		try{
			this.remateActivo.ofertar(this.cliente, 100);
			this.remateActivo.ofertar(this.cliente, 50);
			fail("Tendria que capturar una excepcion");
		} catch(PrecioMenorAlActualException e){
			
		} catch (RemateFinalizadoException e) {
			fail("No tendria que capturar excepcion");
		}
		finally{
			Cliente clienteEsperado = this.cliente;
			Cliente clienteGanador = this.remateActivo.getGanador();
			int precioEsperado = 100;
			int precioSubasta = this.remateActivo.getPrecio();
			Assert.assertEquals(clienteEsperado, clienteGanador);
			Assert.assertEquals(precioEsperado, precioSubasta);
		}
	}
	
	/*
	 Testea, para una subasta finalizada, que
	 la oferta no se realiza.
	 */
	public void testOfertarRemateFinalizado(){
		Cliente clienteEsperado;
		Cliente clienteGanador;
		int precioEsperado,precioSubasta;
		try{
			this.remateFinalizado.finalizarRemate();
			this.remateFinalizado.ofertar(this.cliente, 100);
			fail("Tendria que capturar una excepcion");
		} catch(PrecioMenorAlActualException e){
				
		} catch (RemateFinalizadoException e) {
			
		}
		finally{
			clienteEsperado = null;
			clienteGanador = this.remateFinalizado.getGanador();
			precioEsperado = 0;
			precioSubasta = this.remateFinalizado.getPrecio();
			Assert.assertEquals(clienteEsperado, clienteGanador);
			Assert.assertEquals(precioEsperado, precioSubasta);
		}
		
	}
	//***************************************************************************************************************************************************
}
