package modelo;

public class Hotel {
  String nombre;
  String pais;
  String ciudad;
  String direccion;
  Sring telefono;
  String email;
  int categoria;
  ArrayList<Servicio> listaDeServicios;
  Hour checkIn;
  Hour checkOut;
  ArrayList<FormaDePago> formasDePago;
  ArrayList<Calificacion> listaDeCalificaciones;

  public String getNombre() {
    return nombre;
  }

   public void setNombre(String nombre) {
     this.nombre = nombre; 
   }

   public String getpais() {
    return pais;
  }

   public void setPais(String unPais) {
     this.pais = unPais; 
   }
}
