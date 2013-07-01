package model.date;

public class Date {
	
	private int dia;
	private int mes;
	private int año;
	
	public Date(int d,int m, int a){
		super();
		this.dia = d;
		this.mes = m;
		this.año = a;
	}
	
	public boolean esAntesDe(Date anDate){
		if(this.año < anDate.getAño()) return true;
		if(this.año == anDate.getAño() && this.mes < anDate.getMes()) return true;
		if(this.año == anDate.getAño() && this.mes == anDate.getMes() && this.dia < anDate.getDia()) return true;
		return false;
	}
	
	public boolean esDespuesDe(Date anDate){
		if(this.año > anDate.getAño()) return true;
		if(this.año == anDate.getAño() && this.mes > anDate.getMes()) return true;
		if(this.año == anDate.getAño() && this.mes == anDate.getMes() && this.dia > anDate.getDia()) return true;
		return false;
	}
	
	public boolean esLaMismaFecha(Date anDate){
		if(this.dia == anDate.getDia() && this.mes == anDate.getMes() && this.año == anDate.getAño()) return true;
		return false;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAño() {
		return año;
	}

}
