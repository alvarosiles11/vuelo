package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TripulacionDto {

	public UUID keyVuelo; // vuelo registrado

	public UUID keyTripulacion;
	public String descripcion;
	public int estado;
	public List<TripulanteDto> listaTripulantes;

	public TripulacionDto() {
    listaTripulantes = new ArrayList<>();
  }

	public UUID getKeyVuelo() {
		return keyVuelo;
	}

	public void setKeyVuelo(UUID keyVuelo) {
		this.keyVuelo = keyVuelo;
	}

	public UUID getKeyTripulacion() {
		return keyTripulacion;
	}

	public void setKeyTripulacion(UUID keyTripulacion) {
		this.keyTripulacion = keyTripulacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<TripulanteDto> getListaTripulantes() {
		return listaTripulantes;
	}

	public void setListaTripulantes(List<TripulanteDto> listaTripulantes) {
		this.listaTripulantes = listaTripulantes;
	}




}