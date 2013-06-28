package ModeloTest;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

import modelo.Cliente;
import modelo.Habitacion;
import modelo.Portal;
import modelo.Reserva;
import modelo.Tarjeta;

import org.mockito.Mockito.*;

public class ClienteTest extends TestCase{
	Cliente c;
	Portal mockedPortal;
	Habitacion mockedHabitacion;
	SimpleDateFormat d1;
	SimpleDateFormat d2;
	
	public void setUp(){
		mockedPortal = mock(Portal.class);
		mockedHabitacion = mock(Habitacion.class);
		c = new Cliente("Alguien", "Gomez", 32543234, mockedPortal);
		d1 = new SimpleDateFormat();
		d2 = new SimpleDateFormat();
	}
	
	public void testReservasRealizadasEnEEUU(){
		Reserva r1 = new Reserva(mockedHabitacion,c,d1,d2,"Hong Kong");
		Reserva r2= new Reserva(mockedHabitacion,c,d1,d2,"EEUU");
		Reserva r3 = new Reserva(mockedHabitacion,c,d1,d2,"EEUU");
		
		ArrayList<Reserva> listaDeReservas = new ArrayList<Reserva>();
		listaDeReservas.add(r1);
		listaDeReservas.add(r2);
		listaDeReservas.add(r3);
		when(mockedPortal.getListaDeReservas()).thenReturn(listaDeReservas);
	}
}