package model.calificacionTest;

import junit.framework.Assert;
import model.calificacion.Calificacion;
import junit.framework.TestCase;

public class CalificacionTest extends TestCase{

	private Calificacion calificacion;
	
	//************************************************** Set Up ***********************************************************
	public void setUp(){
		this.calificacion = new Calificacion(10, "Excelente atencion");
	}
	//**********************************************************************************************************************
	
	//*************************************** Test de los getters de calificacion ******************************************
	
	// Testea que retorne correctamente el comentario de la calificacion.
	public void testGetComentario(){
		String comentarioEsperado = "Excelente atencion";
		String comentario = this.calificacion.getComentario();
		Assert.assertEquals(comentarioEsperado, comentario);
	}
	
	// Testea que retorne correctamente la nota de dicha calificacion.
	public void testGetCalificacion(){
		int calificacionEsperada = 10;
		int calificacion = this.calificacion.getCalificacion();
		Assert.assertEquals(calificacionEsperada, calificacion);
	}
	//**********************************************************************************************************************
}
