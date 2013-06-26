package modelo;

import excepciones.OutOfMoneyException;

public abstract class FormaDePago {
	int nroPago;
	
	protected boolean puedePagar(Tarjeta t, int montoAGastar){
		return t.getMontoDisponible() - montoAGastar >= 0;
	}
	
	protected double descontarMontoTarjeta(double montoAGastar,Tarjeta t){
		return t.getMontoDisponible() - montoAGastar;
	}
	
	public double efectuarPago(int montoAGastar,Tarjeta t){
		double montoADevolver = 0;
		try {
			if(puedePagar(t,montoAGastar)){
				montoADevolver = descontarMontoTarjeta(montoAGastar,t);
			} else {
				throw new OutOfMoneyException();
			}
		} catch (OutOfMoneyException o){
			o.getMessage();
		}
		return montoADevolver;
	}
}