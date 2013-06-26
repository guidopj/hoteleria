package modelo;

public class Tarjeta {

	int nroTarjeta;
	Cliente dueno;
	float montoQueTengo;
	
	public float getMontoQueTengo() {
		return montoQueTengo;
	}
	public void setMontoQueTengo(float f) {
		this.montoQueTengo = f;
	}
	public int getNroTarjeta() {
		return nroTarjeta;
	}
	public void setNroTarjeta(int nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}
	public Cliente getDueno() {
		return dueno;
	}
	public void setDueno(Cliente dueno) {
		this.dueno = dueno;
	}
	
	public Tarjeta(int miNroTarjeta){
		this.nroTarjeta = miNroTarjeta;
		this.montoQueTengo = 1000;
	}
	
}
