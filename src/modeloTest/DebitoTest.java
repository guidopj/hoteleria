package ModeloTest;
import org.junit.Test;
import static org.mockito.Mockito.*;

import excepciones.OutOfMoneyException;
import junit.framework.TestCase;
import modelo.Debito;
import modelo.Tarjeta;

public class DebitoTest extends TestCase{
	  
	Debito d;
	Tarjeta mockTarjeta;
	
	public void setUp(){
		d = new Debito(0);
		mockTarjeta = mock(Tarjeta.class);
	}
		
	@Test
	public void testEfectuarPagoSaldoPositivo() {
	  assertEquals(d.efectuarPago(1000, mockTarjeta),(double) 0);
	}
	
	@Test (expected = OutOfMoneyException.class)
	public void testEfectuarPagoSaldoNegativo() throws OutOfMoneyException {
		d.efectuarPago(3000, mockTarjeta);
	}
		
}
