
public class Calificacion {
	
	private int nota;
	private String comentario;

	public Calificacion(String string, int i) {
		super();
		this.nota = i;
		this.comentario = string;
	}

	public int getCalificacion() {
		return nota;
	}

	public String getComentario() {
		return comentario;
	}


}
