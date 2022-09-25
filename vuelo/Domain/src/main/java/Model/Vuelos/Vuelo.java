package Model.Vuelos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import Event.VueloCreado;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.ValueObjects.NumeroVuelo;
import core.AggregateRoot;
import core.BussinessRuleValidateExeption;

public class Vuelo extends AggregateRoot<UUID> {

	public String nroVuelo;
	public UUID keyAeronave;
	public String origen;
	public String destino;
	public Date fechaSalida;
	public Date fechaArribe;
	public UUID keyTripulacion;

	// para ver mi getllHandler
	public List<Tripulante> tripulantes;
	public List<Asiento> asientos;

	public Vuelo() {
	}

	public Vuelo(
			String _nroVuelo,
			UUID _keyAeronave,
			String _origen,
			String _destino,
			Date _fechaSalida,
			Date _fechaArribe,
			UUID _keyTripulacion,
			List<Asiento> _asientos,
			List<Tripulante> _tripulantes) {
		// validaciones value objects y reglas de negocio
		try {
			this.nroVuelo = new NumeroVuelo(_nroVuelo).toString();
		} catch (BussinessRuleValidateExeption e) {
			System.out.println("Error en el NumeroVuelo Vuelo");
			return;
		}
		key = UUID.randomUUID();
		nroVuelo = _nroVuelo;
		keyAeronave = _keyAeronave;
		origen = _origen;
		destino = _destino;
		fechaSalida = _fechaSalida;
		fechaArribe = _fechaArribe;
		keyTripulacion = _keyTripulacion;
		asientos = _asientos;
		tripulantes = _tripulantes;

		System.out.println("Se a creado un nuevo vuelo");
	}

	public void eventCreado() {
		addDomainEvent(
				new VueloCreado(key, nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe,
						keyTripulacion));
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

	public List<Tripulante> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
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
}
