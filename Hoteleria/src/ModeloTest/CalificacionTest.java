
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;


public class CalificacionTest extends TestCase {
	
	private Calificacion c;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		this.c = new Calificacion("Comentario",10);
	}

	@Test
	public void test_getComentario() {
		Assert.assertEquals("Comentario", this.c.getComentario());
	}
	
	@Test
	public void test_getCalificacion(){
		Assert.assertEquals(10, this.c.getCalificacion());
	}

}
