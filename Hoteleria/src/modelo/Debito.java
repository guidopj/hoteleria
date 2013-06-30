package modelo;

public class Debito extends FormaDePago{
	
	int numero;
	
	public Debito(int elNumero){
		this.numero = elNumero;
	}
	
	public void descontarMontoTarjeta(Tarjeta t, double montoAGastar, int cuotas){
		 t.setMontoDisponible(t.getMontoDisponible() - montoAGastar);
	}

	public boolean puedePagar(Tarjeta t, float montoAGastar, int cantCuotas) {
		return t.getMontoDisponible() - montoAGastar >= 0;
	}
}
