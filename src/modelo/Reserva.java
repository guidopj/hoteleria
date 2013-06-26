package modelo;

import java.text.SimpleDateFormat;

public class Reserva
{
  Habitacion h;
  Cliente c;
  SimpleDateFormat ingreso;
  SimpleDateFormat egreso;
  String lugar;
  Hotel h;

  public Reserva(Habitacion unaH, Cliente unCliente, SimpleDateFormat fechaIngreso, SimpleDateFormat fechaEgreso, String unLugar,Hotel elHotel)
  {
    this.h = unaH;
    this.c = unCliente;
    this.ingreso = fechaIngreso;
    this.egreso = fechaEgreso;
    this.lugar = unLugar;
    this.h = elHotel;
  }

  public String getLugar()
  {
    return this.lugar;
  }

  public void setLugar(String unLugar) {
    this.lugar = unLugar;
  }
}
