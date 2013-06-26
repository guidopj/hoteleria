package ModeloTest;

import org.junit.Assert;
import org.junit.Test;

import excepciones.OutOfMoneyException;
import junit.framework.TestCase;
import modelo.Debito;

public class DebitoTest extends TestCase{
	  
	Debito d;
	
	public void setUp(){
		d = new Debito(126);
	}
		
	@Test
	public void testEfectuarPagoSaldoPositivo() {
	  d.efectuarPago(1000);
	  assertEquals(d.getMontoQueTengo(),(float) 0);
	}
	
	@Test (expected = OutOfMoneyException.class)
	public void testEfectuarPagoSaldoNegativo() throws OutOfMoneyException {
		d.efectuarPago(1100);
	}
		
}
