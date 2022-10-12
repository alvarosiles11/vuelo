package Event;

import static org.mockito.ArgumentMatchers.anyString;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class VueloCreadoTest {

	@Test
	public void CheckPropertiesValid() {

		UUID key = UUID.randomUUID();
		String nroVuelo = "scz-cba-513184";
		UUID keyAeronave = UUID.randomUUID();
		String origen = "Scz-ViruViru";
		String destino = "CBA-CBA";
		Date fechaSalida = new Date();
		Date fechaArribe = new Date();
		UUID keyTripulacion = UUID.randomUUID();
		String observacion = "En horario";
		String estado = "1";

		VueloCreado vueloCreadoTest = new VueloCreado();

		VueloCreado vueloCreado = new VueloCreado();

		Assert.assertNull(vueloCreado.getKey());
		Assert.assertNull(vueloCreado.getNroVuelo());
		Assert.assertNull(vueloCreado.getKeyAeronave());
		Assert.assertNull(vueloCreado.getOrigen());
		Assert.assertNull(vueloCreado.getDestino());
		Assert.assertNull(vueloCreado.getFechaSalida());
		Assert.assertNull(vueloCreado.getFechaArribe());
		Assert.assertNull(vueloCreado.getKeyTripulacion());
		Assert.assertNull(vueloCreado.getObservacion());
		Assert.assertNull(vueloCreado.getEstado());

		vueloCreado.setKey(key);
		vueloCreado.setNroVuelo(nroVuelo);
		vueloCreado.setKeyAeronave(keyAeronave);
		vueloCreado.setOrigen(origen);
		vueloCreado.setDestino(destino);
		vueloCreado.setFechaSalida(fechaSalida);
		vueloCreado.setFechaArribe(fechaArribe);
		vueloCreado.setKeyTripulacion(keyTripulacion);
		vueloCreado.setObservacion(anyString());
		vueloCreado.setEstado(anyString());

		Assert.assertEquals(key, vueloCreado.getKey());
		Assert.assertEquals(nroVuelo, vueloCreado.getNroVuelo());
		Assert.assertEquals(keyAeronave, vueloCreado.getKeyAeronave());
		Assert.assertEquals(origen, vueloCreado.getOrigen());
		Assert.assertEquals(destino, vueloCreado.getDestino());
		Assert.assertEquals(fechaSalida, vueloCreado.getFechaSalida());
		Assert.assertEquals(fechaArribe, vueloCreado.getFechaArribe());
		Assert.assertEquals(keyTripulacion, vueloCreado.getKeyTripulacion());
		Assert.assertEquals(anyString(), vueloCreado.getObservacion());
		Assert.assertEquals(anyString(), vueloCreado.getEstado());

	}

	@Test
	public void CheckConstructor() {

		UUID key = UUID.randomUUID();
		String nroVuelo = "scz-cba-513184";
		UUID keyAeronave = UUID.randomUUID();
		String origen = "Scz-ViruViru";
		String destino = "CBA-CBA";
		Date fechaSalida = new Date();
		Date fechaArribe = new Date();
		UUID keyTripulacion = UUID.randomUUID();
		String observacion = "En horario";
		String estado = "1";
		VueloCreado vueloCreadoa = new VueloCreado();

		VueloCreado vuelo = new VueloCreado(key, nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe,
				keyTripulacion, observacion, estado);
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