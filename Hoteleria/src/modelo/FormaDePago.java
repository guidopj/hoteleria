package modelo;

import excepciones.OutOfMoneyException;

public abstract class FormaDePago {
	int nroPago;
	
	protected boolean puedePagar(Tarjeta t, int montoAGastar){
		return t.getMontoDisponible() - montoAGastar >= 0;
	}
	
	protected abstract void descontarMontoTarjeta(Tarjeta t,double montoAGastar,int cantCuotas);
	
	public double efectuarPago(int montoAGastar,Tarjeta t,int cantCuotas){
		double montoADevolver = 0;
		try {
			if(puedePagar(t,montoAGastar)){
				 descontarMontoTarjeta(t,montoAGastar,cantCuotas);
			} else {
				throw new OutOfMoneyException();
			}
		} catch (OutOfMoneyException o){
			o.getMessage();
		}
		return montoADevolver;
	}
}