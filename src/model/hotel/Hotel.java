package model.hotel;

public class Hotel {

	private String nombre;
	private String pais;
	private String ciudad;
	private String direccion;
	private String telefono;
	private String email;
	
	public Hotel(String nombreHotel, String nombrePais, String nombreCiudad, String nombreDireccion, String telefonoHotel, String emailHotel) {
		this.nombre = nombreHotel;
		this.pais = nombrePais;
		this.ciudad = nombreCiudad;
		this.direccion = nombreDireccion;
		this.telefono = telefonoHotel;
		this.email = emailHotel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public String getEmail() {
		return this.email;
	}

}
