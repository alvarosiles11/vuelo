package Event;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class VueloCreadoTest {

	UUID key = UUID.randomUUID();
	String nroVuelo = "scz-cba-513184";
	UUID keyAeronave = UUID.randomUUID();
	String origen = "Scz-ViruViru";
	String destino = "CBA-CBA";
	Date fechaSalida = new Date();
	Date fechaArribe = new Date();
	UUID keyTripulacion = UUID.randomUUID();

	@Test
	public void CheckPropertiesValid() {
		VueloCreado vuelo = new VueloCreado();

		Assert.assertNull(vuelo.getKey());
		Assert.assertNull(vuelo.getNroVuelo());
		Assert.assertNull(vuelo.getKeyAeronave());
		Assert.assertNull(vuelo.getOrigen());
		Assert.assertNull(vuelo.getDestino());
		Assert.assertNull(vuelo.getFechaSalida());
		Assert.assertNull(vuelo.getFechaArribe());
		Assert.assertNull(vuelo.getKeyTripulacion());

		vuelo.setKey(key);
		vuelo.setNroVuelo(nroVuelo);
		vuelo.setKeyAeronave(keyAeronave);
		vuelo.setOrigen(origen);
		vuelo.setDestino(destino);
		vuelo.setFechaSalida(fechaSalida);
		vuelo.setFechaArribe(fechaArribe);
		vuelo.setKeyTripulacion(keyTripulacion);

		Assert.assertEquals(key, vuelo.getKey());
		Assert.assertEquals(nroVuelo, vuelo.getNroVuelo());
		Assert.assertEquals(keyAeronave, vuelo.getKeyAeronave());
		Assert.assertEquals(origen, vuelo.getOrigen());
		Assert.assertEquals(destino, vuelo.getDestino());
		Assert.assertEquals(fechaSalida, vuelo.getFechaSalida());
		Assert.assertEquals(fechaArribe, vuelo.getFechaArribe());
		Assert.assertEquals(keyTripulacion, vuelo.getKeyTripulacion());
	}

	@Test
	public void CheckConstructor() {
		VueloCreado vuelo = new VueloCreado(key, nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe,
				keyTripulacion);
		Assert.assertEquals(key, vuelo.getKey());
		Assert.assertEquals(nroVuelo, vuelo.getNroVuelo());
		Assert.assertEquals(keyAeronave, vuelo.getKeyAeronave());
		Assert.assertEquals(origen, vuelo.getOrigen());
		Assert.assertEquals(destino, vuelo.getDestino());
		Assert.assertEquals(fechaSalida, vuelo.getFechaSalida());
		Assert.assertEquals(fechaArribe, vuelo.getFechaArribe());
		Assert.assertEquals(keyTripulacion, vuelo.getKeyTripulacion());
	}
}