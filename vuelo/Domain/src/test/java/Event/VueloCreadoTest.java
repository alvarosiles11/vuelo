package Event;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class VueloCreadoTest {

	@Test
	public void CheckPropertiesValid() {

		// DomainEvent doServiceStub = new DomainEvent();
		// VueloCreado business = new VueloCreado(doServiceStub);
		VueloCreado vueloCreadoTest = new VueloCreado();

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

		VueloCreado vueloCreado = new VueloCreado();

		Assert.assertEquals(null, vueloCreado.getKey());
		Assert.assertNull(null, vueloCreado.getNroVuelo());
		Assert.assertNull(null, vueloCreado.getKeyAeronave());
		Assert.assertNull(null, vueloCreado.getOrigen());
		Assert.assertNull(null, vueloCreado.getDestino());
		Assert.assertNull(null, vueloCreado.getFechaSalida());
		Assert.assertNull(null, vueloCreado.getFechaArribe());
		Assert.assertNull(null, vueloCreado.getKeyTripulacion());
		Assert.assertNull(null, vueloCreado.getObservacion());
		Assert.assertNull(null, vueloCreado.getEstado());

		vueloCreado.setKey(key);
		vueloCreado.setNroVuelo(nroVuelo);
		vueloCreado.setKeyAeronave(keyAeronave);
		vueloCreado.setOrigen(origen);
		vueloCreado.setDestino(destino);
		vueloCreado.setFechaSalida(fechaSalida);
		vueloCreado.setFechaArribe(fechaArribe);
		vueloCreado.setKeyTripulacion(keyTripulacion);
		vueloCreado.setObservacion(observacion);
		vueloCreado.setEstado(estado);

		Assert.assertEquals(key, vueloCreado.getKey());
		Assert.assertEquals(nroVuelo, vueloCreado.getNroVuelo());
		Assert.assertEquals(keyAeronave, vueloCreado.getKeyAeronave());
		Assert.assertEquals(origen, vueloCreado.getOrigen());
		Assert.assertEquals(destino, vueloCreado.getDestino());
		Assert.assertEquals(fechaSalida, vueloCreado.getFechaSalida());
		Assert.assertEquals(fechaArribe, vueloCreado.getFechaArribe());
		Assert.assertEquals(keyTripulacion, vueloCreado.getKeyTripulacion());
		Assert.assertEquals(observacion, vueloCreado.getObservacion());
		Assert.assertEquals(estado, vueloCreado.getEstado());

	}

}

	@Test
	public void testName() {

	}

	@Test
	public void testGetDestino() {

	}

	@Test
	public void testGetEstado() {

	}

	@Test
	public void testGetFechaArribe() {

	}

	@Test
	public void testGetFechaSalida() {

	}

	@Test
	public void testGetKey() {

	}

	@Test
	public void testGetKeyAeronave() {

	}

	@Test
	public void testGetKeyTripulacion() {

	}

	@Test
	public void testGetNroVuelo() {

	}

	@Test
	public void testGetObservacion() {

	}

	@Test
	public void testGetOrigen() {

	}

	@Test
	public void testSetDestino() {

	}

	@Test
	public void testSetEstado() {

	}

	@Test
	public void testSetFechaArribe() {

	}

	@Test
	public void testSetFechaSalida() {

	}

	@Test
	public void testSetKey() {

	}

	@Test
	public void testSetKeyAeronave() {

	}

	@Test
	public void testSetKeyTripulacion() {

	}

	@Test
	public void testSetNroVuelo() {

	}

	@Test
	public void testSetObservacion() {

	}

	@Test
	public void testSetOrigen() {

	}
}
