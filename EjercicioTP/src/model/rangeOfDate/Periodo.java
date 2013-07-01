package model.rangeOfDate;

import model.date.Date;

public class Periodo {

	public Date getDateEntrada() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getDateSalida() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	boolean disponible = true;
	for(Periodo rango:this.noDisponible){
		Date rangoEntrada = rango.getDateEntrada();
		Date rangoSalida = rango.getDateSalida();
		if((rangoEntrada.esAntesDe(entrada) && rangoSalida.esDespuesDe(entrada)) || rangoEntrada.esLaMismaFecha(entrada)){
			disponible = false;
			break;
		}
		else{
			if((rangoEntrada.esAntesDe(salida) && rangoSalida.esDespuesDe(salida)) || rangoSalida.esLaMismaFecha(salida)){
				disponible = false;
				break;
			}
		}
	}
	return disponible;
}
*/

	public boolean seSuperpone(Date entradaHabitacion, Date salidaHabitacion) {
		// TODO Auto-generated method stub
		return false;
	}
}
