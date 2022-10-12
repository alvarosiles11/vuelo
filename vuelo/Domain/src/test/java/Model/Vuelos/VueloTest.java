package Model.Vuelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;

public class VueloTest {

	@Test
	public void constructorVoid_accept() {
		Assert.assertNotNull(new Vuelo());
	}

	@Test
	public void constructor_accept() {
		// final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final List<Asiento> asientos = new ArrayList<>();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();
		final List<Tripulante> tripulantes = new ArrayList<>();
		final String observacion = "En horario";
		final String estado = "1";

		final Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);

		Assert.assertEquals(nroVuelo, vuelo.getNroVuelo());
		Assert.assertEquals(keyAeronave, vuelo.getKeyAeronave());
		Assert.assertEquals(asientos, vuelo.getAsientos());
		Assert.assertEquals(origen, vuelo.getOrigen());
		Assert.assertEquals(destino, vuelo.getDestino());
		Assert.assertEquals(fechaSalida, vuelo.getFechaSalida());
		Assert.assertEquals(fechaArribe, vuelo.getFechaArribe());
		Assert.assertEquals(keyTripulacion, vuelo.getKeyTripulacion());
		Assert.assertEquals(tripulantes, vuelo.getTripulantes());

		// vuelo.setKey(key);
		vuelo.setNroVuelo(nroVuelo);
		vuelo.setKeyAeronave(keyAeronave);
		vuelo.setAsientos(asientos);
		vuelo.setOrigen(origen);
		vuelo.setDestino(destino);
		vuelo.setFechaSalida(fechaSalida);
		vuelo.setFechaArribe(fechaArribe);
		vuelo.setKeyTripulacion(keyTripulacion);
		vuelo.setTripulantes(tripulantes);
	}

	@Test
	public void constructor_denied() {
		// final UUID key = null;
		final String nroVuelo = "";
		final UUID keyAeronave = null;
		final List<Asiento> asientos = null;
		final String origen = "";
		final String destino = "";
		final Date fechaSalida = null;
		final Date fechaArribe = null;
		final UUID keyTripulacion = null;
		final List<Tripulante> tripulantes = null;
		final String observacion = "";
		final String estado = "";

		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);

		// Assert.assertEquals(vuelo.key, null);
		// Assert.assertEquals(vuelo.nroVuelo, null);
		// Assert.assertEquals(vuelo.keyAeronave, null);
		// Assert.assertEquals(vuelo.origen, null);
		// Assert.assertEquals(vuelo.destino, null);
		// Assert.assertEquals(vuelo.fechaSalida, null);
		// Assert.assertEquals(vuelo.fechaArribe, null);
		// Assert.assertEquals(vuelo.keyTripulacion, null);
		// Assert.assertEquals(vuelo.asientos, null);
		// Assert.assertEquals(vuelo.tripulantes, null);
	}

	@Test
	public void addDomainEvent_accept() {

		// final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final List<Asiento> asientos = new ArrayList<>();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();
		final List<Tripulante> tripulantes = new ArrayList<>();
		final String observacion = "En horario";
		final String estado = "1";
		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);
		vuelo.eventCreado();
		Assert.assertEquals(vuelo.domainEvents.size(), 1);
	}

}
