package UseCases.Command.Vuelos.Crear;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.VueloDto;

public class CrearVueloCommand_Test {

	@Test
	public void dataValid() {
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

		VueloDto vueloDto = new VueloDto();

		vueloDto.setKey(key);
		vueloDto.setNroVuelo(nroVuelo);
		vueloDto.setKeyAeronave(keyAeronave);
		vueloDto.setOrigen(origen);
		vueloDto.setDestino(destino);
		vueloDto.setFechaSalida(fechaSalida);
		vueloDto.setFechaArribe(fechaArribe);
		vueloDto.setKeyTripulacion(keyTripulacion);
		vueloDto.setObservacion(observacion);
		vueloDto.setEstado(estado);

		CrearVueloCommand command = new CrearVueloCommand(vueloDto);

		Assert.assertEquals(nroVuelo, command.data.nroVuelo);
		Assert.assertEquals(keyAeronave, command.data.keyAeronave);
		Assert.assertEquals(origen, command.data.origen);
		Assert.assertEquals(destino, command.data.destino);
		Assert.assertEquals(fechaSalida, command.data.fechaSalida);
		Assert.assertEquals(fechaArribe, command.data.fechaArribe);
		Assert.assertEquals(keyTripulacion, command.data.keyTripulacion);
		Assert.assertEquals(observacion, command.data.observacion);
		Assert.assertEquals(estado, command.data.estado);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
				CrearVueloCommand.class.getConstructors()[0].canAccess(null));
	}
}