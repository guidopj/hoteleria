package modelo;

import java.text.SimpleDateFormat;

public class Reserva
{
  Habitacion h;
  Cliente c;
  SimpleDateFormat ingreso;
  SimpleDateFormat egreso;
  String lugar;

  public Reserva(Habitacion unaH, Cliente unCliente, SimpleDateFormat fechaIngreso, SimpleDateFormat fechaEgreso, String unLugar)
  {
    this.h = unaH;
    this.c = unCliente;
    this.ingreso = fechaIngreso;
    this.egreso = fechaEgreso;
    this.lugar = unLugar;
  }

  public String getLugar()
  {
    return this.lugar;
  }

  public void setLugar(String unLugar) {
    this.lugar = unLugar;
  }
}