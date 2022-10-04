package Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class VueloDtoTest {
	@Test
	public void CheckPropertiesValid() {

		// Todo el nro de vuelo tiene que ser consecurtivo?
		// si o si tiene que haver horario, porque podria haver la misma fecha y a que
		// hora saldria!!!?
		// ver si el objeto Date tiene hora
		final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final List<AsientoDto> asientos = getListAsiento();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();

		final List<TripulanteDto> tripulantes = getListdaTripulantes();

		final VueloDto vueloDto = new VueloDto();

		Assert.assertEquals(null, vueloDto.getKey());
		Assert.assertNull(null, vueloDto.getNroVuelo());
		Assert.assertNull(null, vueloDto.getKeyAeronave());
		Assert.assertEquals(0, asientos.size());

		Assert.assertNull(null, vueloDto.getOrigen());
		Assert.assertNull(null, vueloDto.getDestino());
		Assert.assertNull(null, vueloDto.getFechaSalida());
		Assert.assertNull(null, vueloDto.getFechaArribe());
		Assert.assertNull(null, vueloDto.getKeyTripulacion());
		Assert.assertEquals(0, tripulantes.size());

		vueloDto.setKey(key);
		vueloDto.setNroVuelo(nroVuelo);
		vueloDto.setKeyAeronave(keyAeronave);
		vueloDto.setAsientos(asientos);
		vueloDto.setOrigen(origen);
		vueloDto.setDestino(destino);
		vueloDto.setFechaSalida(fechaSalida);
		vueloDto.setFechaArribe(fechaArribe);
		vueloDto.setKeyTripulacion(keyTripulacion);
		vueloDto.setTripulantes(tripulantes);

		Assert.assertEquals(key, vueloDto.getKey());
		Assert.assertEquals(nroVuelo, vueloDto.getNroVuelo());
		Assert.assertEquals(keyAeronave, vueloDto.getKeyAeronave());
		Assert.assertEquals(asientos, vueloDto.getAsientos());
		Assert.assertEquals(origen, vueloDto.getOrigen());
		Assert.assertEquals(destino, vueloDto.getDestino());
		Assert.assertEquals(fechaSalida, vueloDto.getFechaSalida());
		Assert.assertEquals(fechaArribe, vueloDto.getFechaArribe());
		Assert.assertEquals(keyTripulacion, vueloDto.getKeyTripulacion());
		Assert.assertEquals(tripulantes, vueloDto.getTripulantes());
	}

	private List<AsientoDto> getListAsiento() {
		return new ArrayList<>();
	}

	private List<TripulanteDto> getListdaTripulantes() {
		return new ArrayList<>();
	}
}
