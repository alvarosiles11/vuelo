package Dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VueloDto {

	public UUID key;
	public String nroVuelo;
	public UUID keyAeronave;
	public List<AsientoDto> asientoDtos;
	public String origen;
	public String destino;
	public Date fechaSalida;
	public Date fechaArribe;
	public UUID keyTripulacion;
	public List<TripulanteDto> tripulanteDtos;

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

	public UUID getKeyAeronave() {
		return keyAeronave;
	}

	public void setKeyAeronave(UUID keyAeronave) {
		this.keyAeronave = keyAeronave;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
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

	public UUID getKeyTripulacion() {
		return keyTripulacion;
	}

	public void setKeyTripulacion(UUID keyTripulacion) {
		this.keyTripulacion = keyTripulacion;
	}

	public List<AsientoDto> getAsientoDtos() {
		return asientoDtos;
	}

	public void setAsientoDtos(List<AsientoDto> asientoDtos) {
		this.asientoDtos = asientoDtos;
	}

	public List<TripulanteDto> getTripulanteDtos() {
		return tripulanteDtos;
	}

	public void setTripulanteDtos(List<TripulanteDto> tripulanteDtos) {
		this.tripulanteDtos = tripulanteDtos;
	}
}