
public class RangeOfDate {
	
	private Date inicio;
	private Date fin;
	
	public RangeOfDate(Date i, Date f){
		this.inicio = i;
		this.fin = f;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public Date getFin() {
		return this.fin;
	}

	public boolean estaDentroDelRango(Date date) {
		if(date.esDespuesDe(this.inicio) || this.inicio.esLaMismaFecha(date) 
			&&
			date.esAntesDe(this.fin) || this.fin.esLaMismaFecha(date)){
			return true;
		}
		return false;
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
