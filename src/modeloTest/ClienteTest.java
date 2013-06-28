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
	SimpleDateFormat d1;
	SimpleDateFormat d2;
        Reserva mockedReserva1;
        Reserva mockedReserva2;
        Reserva mockedReserva3;

	public void setUp(){
	  mockedPortal = mock(Portal.class);
	  mockedReserva1 = mock(Reserva.class);
          mockedReserva2 = mock(Reserva.class);
          mockedReserva3 = mock(Reserva.class);
          
          c = new Cliente("Alguien", "Gomez", 32543234, mockedPortal);
          
          when(mockedReserva1.hotel.getPais()).thenReturn("EEUU");
          when(mockedReserva1.hotel.getPais()).thenReturn("EEUU");
          when(mockedReserva1.hotel.getPais()).thenReturn("Hong Kong");
          ArrayList<Reserva> listaDeReservas = new ArrayList<Reserva>();
            when
	    listaDeReservas.add(mockedReserva1);
	    listaDeReservas.add(mockedReserva2);
	    listaDeReservas.add(mockedReserva3);
            when(mockedPortal.getListaDeReservas()).thenReturn(listaDeReservas);
	}
	
	public void testReservasRealizadasEnEEUU(){
                assertTrue(mockedPortal.getListaDeReservas(),c.obtenerReservasRealizadasEn("EEUU").size());
	}
}
