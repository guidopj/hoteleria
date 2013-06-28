import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RangeOfDateTest {
	
	private RangeOfDate rango;
	private Date inicio,fin;

	@Before
	public void setUp() throws Exception {
		this.inicio = new Date(10,12,2012);
		this.fin = new Date(20,12,2012);
		this.rango = new RangeOfDate(this.inicio,this.fin);
	}
	
	@Test
	public void getInicio(){
		Assert.assertEquals(this.inicio, this.rango.getInicio());
	}
	
	@Test
	public void getFin(){
		Assert.assertEquals(this.fin, this.rango.getFin());
	}
	
	@Test
	public void estaDentroDelRangoTest(){
		Date datePasa,dateFalla;
		datePasa = new Date(11,12,2012);
		dateFalla = new Date(9,12,2012);
		
		Assert.assertTrue(this.rango.estaDentroDelRango(datePasa));
		Assert.assertFalse(this.rango.estaDentroDelRango(dateFalla));
		
	}
	
	@Test 
	public void seSuperponeTest(){
		Date inicioPasa = new Date(5,12,2012);
		Date finPasa = new Date(9,12,2012);
		Date inicioNoPasa = new Date(10,12,2012);
		Date finNoPasa = new Date(19,12,2012);
		
		Assert.assertFalse(this.rango.seSuperpone(inicioPasa, finPasa));
		Assert.assertTrue(this.rango.seSuperpone(inicioNoPasa, finNoPasa));
		Assert.assertTrue(this.rango.seSuperpone(inicioPasa, finNoPasa));
		Assert.assertTrue(this.rango.seSuperpone(inicioNoPasa, finPasa));
		
	}

}
