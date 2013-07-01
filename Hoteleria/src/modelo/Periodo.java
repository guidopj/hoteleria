
public class Periodo {
	private Date inicio;
	private Date fin;
	
	public Periodo(Date i, Date f){
		this.inicio = i;
		this.fin = f;
	}

	public Date getInicio(){
		return this.inicio;
	}

	public Date getFin() {
		return this.fin;
	}
	
	public boolean seSuperpone(Date inicio, Date fin){
		if((inicio.esAntesDe(this.inicio) && fin.esAntesDe(this.inicio)) 
			||
			(inicio.esDespuesDe(this.fin) && fin.esDespuesDe(this.fin))){
			return false;
		}
		
		return true;
	}
}
