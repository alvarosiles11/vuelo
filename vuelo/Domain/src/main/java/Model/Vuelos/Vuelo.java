package Model.Vuelos;

import Event.VueloCreado;
import Model.Aeronaves.Asiento;
import Model.Vuelos.ValueObjects.NumeroVuelo;
import core.AggregateRoot;
import core.BussinessRuleValidateExeption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Vuelo extends AggregateRoot<UUID> {

	public UUID keyVuelo;

	public String nroVuelo;
	public String keyAeronave;
	public List<Asiento> listaAsientos;

	public String keyAeropuertoOrigen;
	public String keyAeropuertoDestino;
	public Date fechaSalida;
	public Date fechaArribe;

	public String keyTripulacion;
	public List<Tripulante> listaTripulantes;

	public Vuelo() {
	}

	public Vuelo(
			String _nroVuelo,
			String _keyAeronave,
			String _keyAeropuertoOrigen,
			String _keyAeropuertoDestino,
			Date _fechaSalida,
			Date _fechaArribe,
			String _keyTripulacion) {
		key = UUID.randomUUID();
		keyVuelo = UUID.randomUUID();
		// validaciones value objects y reglas de negocio
		try {
			this.nroVuelo = new NumeroVuelo(_nroVuelo).toString();
		} catch (BussinessRuleValidateExeption e) {
			System.out.println("Error en el NumeroVuelo Vuelo");
			return;
		}

		nroVuelo = _nroVuelo;
		keyAeronave = _keyAeronave;
		listaAsientos = new ArrayList<Asiento>();
		keyAeropuertoOrigen = _keyAeropuertoOrigen;
		keyAeropuertoDestino = _keyAeropuertoDestino;
		fechaSalida = _fechaSalida;
		fechaArribe = _fechaArribe;
		keyTripulacion = _keyTripulacion;
		listaTripulantes = new ArrayList<Tripulante>();
		System.out.println("Se a creado un nuevo vuelo");
	}

	public void eventCreado() {
		addDomainEvent(new VueloCreado(keyVuelo,nroVuelo, keyAeronave, keyAeropuertoOrigen, keyAeropuertoDestino, fechaSalida,
				fechaArribe, keyTripulacion, listaTripulantes, listaAsientos));

	}

	public void AgregarTripulante(Tripulante tripulante) {
		listaTripulantes
				.parallelStream()
				.filter(p -> p.getKey() == tripulante.getKey())
				.findFirst()
				.ifPresent(p -> {
					throw new RuntimeException("El tripulante ya existe");
				});
		listaTripulantes.add(tripulante);
	}

	public void agregarAsiento(Asiento asiento) {
		listaAsientos
				.parallelStream()
				.filter(p -> p.getKey() == asiento.getKey())
				.findFirst()
				.ifPresent(p -> {
					throw new RuntimeException("El asiento ya existe");
				});
		listaAsientos.add(asiento);
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

	public List<Asiento> getListaAsientos() {
		return listaAsientos;
	}

	public void setListaAsientos(List<Asiento> listaAsientos) {
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

	public List<Tripulante> getListaTripulantes() {
		return listaTripulantes;
	}

	public void setListaTripulantes(List<Tripulante> listaTripulantes) {
		this.listaTripulantes = listaTripulantes;
	}

}
