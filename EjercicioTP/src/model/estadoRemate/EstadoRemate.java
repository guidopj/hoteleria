package model.estadoRemate;

import model.cliente.Cliente;
import model.excepciones.PrecioMenorAlActualException;
import model.excepciones.RemateFinalizadoException;
import model.remate.Remate;

public abstract class EstadoRemate {

	public abstract void realizarOferta(Remate remate, Cliente cli, int precio) throws RemateFinalizadoException, PrecioMenorAlActualException;
}
