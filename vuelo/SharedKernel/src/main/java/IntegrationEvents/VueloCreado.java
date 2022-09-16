package IntegrationEvents;

import core.IntegrationEvent;

import java.util.Date;
import java.util.UUID;

public class VueloCreado extends IntegrationEvent {

	private UUID key;
	private String nroVuelo;
	private String keyAeronave;
	private String keyAeropuertoOrigen;
	private String keyAeropuertoDestino;
	private Date fechaSalida;
	private Date fechaArribe;

	// public List<TripulanteDto> listaTripulante;
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

}
