package modelo;

public class Credito extends FormaDePago{
	
	public void descontarEnTarjeta(Tarjeta t, float montoAGastar, int cuotas){
		 t.setMontoDisponible(t.getMontoDisponible() - (montoAGastar / cuotas));
	}

	public boolean puedePagar(Tarjeta t, float montoAGastar, int cantCuotas) {
		return t.getMontoDisponible() > (montoAGastar / cantCuotas);
	}
}
