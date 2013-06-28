package modelo;

import java.util.ArrayList;

public class Portal {
  ArrayList<Hotel> hoteles;
  ArrayList<Reserva> reservas;

  public ArrayList<Reserva> getReservas() {
    return reservas;
  }

  public void setReservas(ArrayList<Reserva> misReservas) {
    this.reservas = misReservas;
  }

  
}
