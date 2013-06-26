package modelo;

import excepciones.OutOfMoneyException;

public class Debito extends Tarjeta{
	
	public Debito(int miNroTarjeta){
		super(miNroTarjeta);
	}

	public void efectuarPago(float montoAGastar){
		try {
			if(this.getMontoQueTengo() - montoAGastar >= 0){
				this.setMontoQueTengo(this.getMontoQueTengo() - montoAGastar);
			} else {
				throw new OutOfMoneyException();
			}
		} catch (OutOfMoneyException o){
			o.getMessage();
		}
	}
}
