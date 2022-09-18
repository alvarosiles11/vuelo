package Event;

import Model.Aeronaves.Asiento;
import Model.Vuelos.Tripulante;
import core.DomainEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VueloCreado extends DomainEvent {

	public UUID key;
	public String nroVuelo;
	public String keyAeronave;
	public String keyAeropuertoOrigen;
	public String keyAeropuertoDestino;
	public Date fechaSalida;
	public Date fechaArribe;
	public String keyTripulacion;

	public List<Tripulante> listaTripulantes;
	public List<Asiento> listaAsientos;

	public VueloCreado() {
		super();
	}

	public VueloCreado(UUID key, String nroVuelo, String keyAeronave,
			String keyAeropuertoOrigen, String keyAeropuertoDestino, Date fechaSalida, Date fechaArribe,
			String keyTripulacion, List<Tripulante> listaTripulantes, List<Asiento> listaAsientos) {
		super(LocalDateTime.now());
		this.key = key;
		this.nroVuelo = nroVuelo;
		this.keyAeronave = keyAeronave;
		this.keyAeropuertoOrigen = keyAeropuertoOrigen;
		this.keyAeropuertoDestino = keyAeropuertoDestino;
		this.fechaSalida = fechaSalida;
		this.fechaArribe = fechaArribe;
		this.keyTripulacion = keyTripulacion;
		this.listaTripulantes = new ArrayList<Tripulante>();
		this.listaAsientos = new ArrayList<Asiento>();
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

	public String getKeyTripulacion() {
		return keyTripulacion;
	}

	public void setKeyTripulacion(String keyTripulacion) {
		this.keyTripulacion = keyTripulacion;
	}

	public List<Tripulante> getListaTripulantes() {
		return listaTripulantes;
	}

	public void setListaTripulantes(List<Tripulante> listaTripulantes) {
		this.listaTripulantes = listaTripulantes;
	}

	public List<Asiento> getListaAsientos() {
		return listaAsientos;
	}

	public void setListaAsientos(List<Asiento> listaAsientos) {
		this.listaAsientos = listaAsientos;
	}

	public UUID getKey() {
		return key;
	}

	public void setKey(UUID key) {
		this.key = key;
	}

}
