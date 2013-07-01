package model.habitacion;

import model.date.Date;
import java.util.*;

import model.rangeOfDate.Periodo;
import model.servicio.Servicio;

public class Habitacion {

	//******************************************************************** Variables de instancia *************************************************************
	
	private int capacidadMaxima;
	private boolean camaMatrimonial;
	private float precioPorNoche;
	private List<Periodo> noDisponible;
	private List<Servicio> servicios;
	
	//*********************************************************************************************************************************************************
	
	//******************************************************************** Constructor Habitacion *************************************************************
	
	public Habitacion(int capacidad, float precio, boolean camaMatrimonial, List<Servicio> servicios){
		this.capacidadMaxima = capacidad;
		this.camaMatrimonial = camaMatrimonial;
		this.precioPorNoche = precio;
		this.noDisponible = new ArrayList<Periodo>();
		this.servicios = servicios;
	}
	
	//*********************************************************************************************************************************************************
	
	//******************************************************************** Getters y setters ******************************************************************
	
	public List<Periodo> getRangosNoDisponibles() {
		return this.noDisponible;
	}
	
	public int getCapacidadMaxima() {
		return this.capacidadMaxima;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}
	
	public float getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	
	public void agregarNoDisponibilidad(Periodo rango) {
		this.noDisponible.add(rango);
	}
	
	public void agregarServicio(Servicio servicio) {
		if(!this.poseeElServicio(servicio)){
			this.servicios.add(servicio);
		}
	}
	
	//*********************************************************************************************************************************************************
	
	//********************************************************* Metodo para verificar disponibilidad de habitacion ********************************************
	/*
	 Verifica que la habitacion este disponible
	 entre las fechas especificadas, para una cierta
	 cantidad de pasajeros, y si desea o no cama matrimonial. 
	 */
	
	public boolean estaDisponibleEn(Date entrada, Date salida, int pasajeros,boolean camaMatri) {
		boolean disponible = true;
		if(!this.estaDisponiblePara(pasajeros, camaMatri) || !this.estaDisponibleEntre(entrada, salida)){
			disponible = false;
		}
		return disponible;
	}

	/*
	 Verifica si esta disponible la habitacion
	 entre dos fechas especificas. 
	 */
	
	public boolean estaDisponibleEntre(Date entrada, Date salida) {
		boolean disponible = true;
		for(Periodo rango:this.noDisponible){
			if(rango.seSuperpone(entrada, salida)){
				disponible = false;
				break;
			}
		}
		return disponible;
	}

	/*
	 Verifica que la habitacion este
	 disponible para una cierta cantidad de
	 pasajeros, y si desea o no cama matrimonial.
	 */
	
	public boolean estaDisponiblePara(int pasajeros, boolean camaMatri) {
		boolean disponible = true;
		if ((pasajeros > this.capacidadMaxima) || (this.camaMatrimonial != camaMatri)){
			disponible = false;
		}
		return disponible;
	}

	//*********************************************************************************************************************************************************
	
	//********************************************************* Metodo para verificar si posee un servicio especifico *****************************************
	/*
	 Verifica que la habitacion tenga un servicio
	 especifico.
	 */
	
	public boolean poseeElServicio(Servicio servicio1) {
		boolean retorno = false;
		for(Servicio serv:this.servicios){
			if(serv.getNombre() == servicio1.getNombre()){
				retorno = true;
				break;
			}
		}
		return retorno;
	}
	
	//*********************************************************************************************************************************************************

}
