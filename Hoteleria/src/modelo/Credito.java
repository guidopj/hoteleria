package modelo;

public class Credito extends FormaDePago{

	public boolean puedePagar(Tarjeta t, double montoAGastar, int cantCuotas) {
		return t.getMontoDisponible() > (montoAGastar / cantCuotas);
	}
	
	protected void descontarMontoTarjeta(Tarjeta t, double montoAGastar,int cantCuotas) {
		 t.setMontoDisponible(t.getMontoDisponible() - (montoAGastar / cantCuotas));
	}
}
