package model.remate;

import model.cliente.Cliente;
import model.estadoRemate.EstadoRemate;
import model.excepciones.RemateFinalizadoException;


public class RemateFinalizado extends EstadoRemate {

	@Override
	public void realizarOferta(Remate remate, Cliente cli, int precio) throws RemateFinalizadoException {
		throw new RemateFinalizadoException();
	}

}
