package modelo;

import excepciones.OutOfMoneyException;

public abstract class FormaDePago {
	int nroPago;
	
	protected boolean puedePagar(Tarjeta t, int montoAGastar);
	
	protected double descontarMontoTarjeta(double montoAGastar,Tarjeta t);
	
	public double efectuarPago(int montoAGastar,Tarjeta t, int cantCuotas){
		double montoADevolver = 0;
		try {
			if(puedePagar(t,montoAGastar,cantCuotas)){
				montoADevolver = descontarMontoTarjeta(montoAGastar,t,cantCuotas);
			} else {
				throw new OutOfMoneyException();
			}
		} catch (OutOfMoneyException o){
			o.getMessage();
		}
	}
}
