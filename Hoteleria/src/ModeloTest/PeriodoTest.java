
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class PeriodoTest extends TestCase {
	
	private Periodo p;
	private Date di,df;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.di = new Date(10,10,2010);
		this.df = new Date(15,10,2010);
		this.p = new Periodo(di,df);
	}

	@Test
	public void test_getInicio() {
		Assert.assertTrue(di.esLaMismaFecha(this.p.getInicio()));
	}
	
	@Test
	public void test_getFin(){
		Assert.assertTrue("Las fechas de fin no son las misma", df.esLaMismaFecha(this.p.getFin()));
	}
	
	@Test
	public void test_seSuperpone(){
		Date d1,d2,d3,d4;
		d1 = new Date(5,10,2010);
		d2 = new Date(9,10,2010);
		d3 = new Date(16,10,2010);
		d4 = new Date(20,10,2010);
		
		Assert.assertTrue(this.p.seSuperpone(d1, d3));
		Assert.assertTrue(this.p.seSuperpone(d1, d4));
		Assert.assertFalse(this.p.seSuperpone(d1, d2));
		Assert.assertFalse(this.p.seSuperpone(d3, d4));
	}

}
