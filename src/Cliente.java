package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cliente {
	String nombre;
	String apellido;
	int dni;
	Portal p;

	public Cliente(String elNombre, String elApellido,int elDni,Portal elP){
		this.nombre = elNombre;
		this.apellido = elApellido;
		this.dni = elDni;
		this.p = elP;
	}
	
	public ArrayList<Reserva> verMisReservas(){
		return getP().getListaDeReservas();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Portal getP() {
		return p;
	}

	public void setP(Portal p) {
		this.p = p;
	}
	
	public ArrayList<Reserva> obtenerReservasRealizadasEn(String pais){
		ArrayList<Reserva> aRetornar = new ArrayList<Reserva>();
		for(Reserva r : this.verMisReservas()){
			if(r.getLugar().equals(pais)){
				aRetornar.add(r);
			}
		}
		return aRetornar;
	}
	
	public  ArrayList<Reserva> cancelarReserva(Reserva r1){
		ArrayList<Reserva> misReservas = new ArrayList<Reserva>();
		for(Reserva r : this.verMisReservas()){
			if(!r.equals(r1)){
				misReservas.remove(r);
			}
		}
		return misReservas;
	}

	public Reserva modificarReserva(){
		return null;
		
	}
	
}