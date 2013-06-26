import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.awt.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DescuentoTest {
	
	private ArrayList habitaciones;
	private Date desde;
	private Date hasta;
	private double porcentaje;
	private Habitacion hAEliminar;
	
	private Descuento descuentoPasa;

	@Before
	public void setUp() throws Exception {
		this.habitaciones = new ArrayList();
		Habitacion h1mocked,h2mocked;
		h1mocked = mock(Habitacion.class);
		h2mocked = mock(Habitacion.class);
		this.hAEliminar = mock(Habitacion.class);
		this.habitaciones.add(h1mocked);
		this.habitaciones.add(h2mocked);
		this.habitaciones.add(this.hAEliminar);
		this.desde = mock(Date.class);
		this.hasta = mock(Date.class);
		this.porcentaje = 10.0;
		
		this.descuentoPasa = new Descuento(this.habitaciones, this.desde, this.hasta,this.porcentaje);
	}

	@Test
	public void getHabitacionesTest(){
		Assert.assertEquals(this.habitaciones, this.descuentoPasa.getHabitaciones());
	}
	
	@Test
	public void getDesdeTest(){
		Assert.assertEquals(this.desde, this.descuentoPasa.getDesde());
	}
	
	@Test
	public void getHastaTest(){
		Assert.assertEquals(this.hasta, this.descuentoPasa.getHasta());
	}
	
	@Test
	public void getPorcentajeTest(){
		Assert.assertEquals(this.porcentaje, this.descuentoPasa.getPorcentaje(), 0);
	}
	
	@Test
	public void agregarHabitacionTest(){
		Habitacion h4mocked = mock(Habitacion.class);
		this.habitaciones.add(h4mocked);
		this.descuentoPasa.agregarHabitacion(h4mocked);
		Assert.assertEquals(this.habitaciones, this.descuentoPasa.getHabitaciones());
	}
	
	@Test
	public void quitarHabitacionTest(){
		this.habitaciones.remove(this.hAEliminar);
		this.descuentoPasa.quitarHabitacion(this.hAEliminar);
		Assert.assertEquals(this.habitaciones, this.descuentoPasa.getHabitaciones());
	}
	
	@Test
	public void setHabitacionesTest(){
		
		ArrayList xs = new ArrayList();
		this.descuentoPasa.setHabitaciones(xs);
		Assert.assertEquals(xs, this.descuentoPasa.getHabitaciones());
		
	}

}
