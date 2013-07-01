package model.remate;

import model.cliente.Cliente;
import model.estadoRemate.EstadoRemate;
import model.excepciones.PrecioMenorAlActualException;

public class RemateActivo extends EstadoRemate {

	@Override
	public void realizarOferta(Remate remate, Cliente cli, int precio) throws PrecioMenorAlActualException {
		if(remate.getPrecio() < precio){
			int precioActual = remate.getPrecio() + precio;
			remate.setCliente(cli);
			remate.setPrecio(precioActual);
		}
		else
		{
			throw new PrecioMenorAlActualException();
		}
	}

}
