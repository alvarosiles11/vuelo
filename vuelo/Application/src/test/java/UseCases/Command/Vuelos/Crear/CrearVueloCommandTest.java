package UseCases.Command.Vuelos.Crear;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.VueloDto;

public class CrearVueloCommandTest {

	@Test
	public void dataValid() {
		final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();

		final VueloDto vueloDto = new VueloDto();

		vueloDto.setKey(key);
		vueloDto.setNroVuelo(nroVuelo);
		vueloDto.setKeyAeronave(keyAeronave);
		vueloDto.setOrigen(origen);
		vueloDto.setDestino(destino);
		vueloDto.setFechaSalida(fechaSalida);
		vueloDto.setFechaArribe(fechaArribe);
		vueloDto.setKeyTripulacion(keyTripulacion);

		final CrearVueloCommand command = new CrearVueloCommand(vueloDto);

		Assert.assertEquals(nroVuelo, command.nroVuelo);
		Assert.assertEquals(keyAeronave, command.keyAeronave);
		Assert.assertEquals(origen, command.origen);
		Assert.assertEquals(destino, command.destino);
		Assert.assertEquals(fechaSalida, command.fechaSalida);
		Assert.assertEquals(fechaArribe, command.fechaArribe);
		Assert.assertEquals(keyTripulacion, command.keyTripulacion);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
				CrearVueloCommand.class.getConstructors()[0].canAccess(null));
	}
}