import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RemateTest {
	
	private Remate rematePrueba;
	private Habitacion mockHabitacion;
	private Date inicio,fin,ingreso,egreso;
	private Cliente mockCliente;

	@Before
	public void setUp() throws Exception {
		
		this.mockHabitacion = mock(Habitacion.class);
		this.mockCliente = mock(Cliente.class);
		this.inicio = new Date(10,10,2012);
		this.fin = new Date(15,10,2012);
		this.ingreso = new Date(10,11,2012);
		this.egreso = new Date(20,11,2012);
		
		
		this.rematePrueba = new Remate(this.mockHabitacion,this.inicio,this.fin,this.ingreso,this.egreso,this.mockCliente);
	}

	@Test
	public void getHabitacionTest(){
		Assert.assertEquals(this.mockHabitacion, this.rematePrueba.getHabitacion());
	}
	
	@Test
	public void getInicioSubastaTest(){
		Assert.assertEquals(this.inicio, this.rematePrueba.getInicioSubasta());
	}
	
	@Test
	public void getFinSubastaTest(){
		Assert.assertEquals(this.fin, this.rematePrueba.getFinSubasta());
	}
	
	@Test
	public void getIngresoTest(){
		Assert.assertEquals(this.ingreso,this.rematePrueba.getIngreso());
	}
	
	@Test
	public void getEgresoTest(){
		Assert.assertEquals(this.egreso, this.rematePrueba.getEgreso());
	}
	
	@Test
	public void getPrecioActualTest(){
		Assert.assertTrue(this.rematePrueba.getPrecioActual() == 0.0);
	}
	
	@Test
	public void getGanadorTest(){
		Assert.assertEquals(this.mockCliente, this.rematePrueba.getGanador());
	}
	
	@Test
	public void ofertarTest(){
		Cliente cmock = mock(Cliente.class);
		this.rematePrueba.ofertar(150.0,cmock);
		Assert.assertEquals(cmock, this.rematePrueba.getGanador());
		Assert.assertTrue(this.rematePrueba.getPrecioActual() == 150.0);
	}

}
