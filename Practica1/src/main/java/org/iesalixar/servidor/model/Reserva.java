package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Arrays;

public class Reserva implements Serializable {
	
	private String inicio;
	private String fin;
	private int personas;
	private String[] servicios;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	public String[] getServicios() {
		return servicios;
	}

	public void setServicios(String[] servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Reserva [inicio=" + inicio + ", fin=" + fin + ", personas=" + personas + ", servicios="
				+ Arrays.toString(servicios) + "]";
	}
	
	
	
}
