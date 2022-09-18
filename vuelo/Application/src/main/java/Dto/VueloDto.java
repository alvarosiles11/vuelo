package Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VueloDto {

	public UUID key;
	public String nroVuelo;
	public String keyAeronave;
	public List<AsientoDto> listaAsientos;

	public String keyAeropuertoOrigen;
	public String keyAeropuertoDestino;
	public Date fechaSalida;
	public Date fechaArribe;

	public String keyTripulacion;
	public List<TripulanteDto> listaTripulantes;

	public VueloDto() {
		listaAsientos = new ArrayList<>();
		listaTripulantes = new ArrayList<>();
	}

	public UUID getKey() {
		return key;
	}

	public void setKey(UUID key) {
		this.key = key;
	}

	public String getNroVuelo() {
		return nroVuelo;
	}

	public void setNroVuelo(String nroVuelo) {
		this.nroVuelo = nroVuelo;
	}

	public String getKeyAeronave() {
		return keyAeronave;
	}

	public void setKeyAeronave(String keyAeronave) {
		this.keyAeronave = keyAeronave;
	}

	public List<AsientoDto> getListaAsientos() {
		return listaAsientos;
	}

	public void setListaAsientos(List<AsientoDto> listaAsientos) {
		this.listaAsientos = listaAsientos;
	}

	public String getKeyAeropuertoOrigen() {
		return keyAeropuertoOrigen;
	}

	public void setKeyAeropuertoOrigen(String keyAeropuertoOrigen) {
		this.keyAeropuertoOrigen = keyAeropuertoOrigen;
	}

	public String getKeyAeropuertoDestino() {
		return keyAeropuertoDestino;
	}

	public void setKeyAeropuertoDestino(String keyAeropuertoDestino) {
		this.keyAeropuertoDestino = keyAeropuertoDestino;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaArribe() {
		return fechaArribe;
	}

	public void setFechaArribe(Date fechaArribe) {
		this.fechaArribe = fechaArribe;
	}

	public String getKeyTripulacion() {
		return keyTripulacion;
	}

	public void setKeyTripulacion(String keyTripulacion) {
		this.keyTripulacion = keyTripulacion;
	}

	public List<TripulanteDto> getListaTripulantes() {
		return listaTripulantes;
	}

	public void setListaTripulantes(List<TripulanteDto> listaTripulantes) {
		this.listaTripulantes = listaTripulantes;
	}


}
