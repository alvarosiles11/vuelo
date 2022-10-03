package UseCases.Command.Asiento.Editar;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.AsientoDto;
import Dto.VueloDto;

public class EditarAsientoCommandTest {

	@Test
	public void dataValid() {

		UUID key = UUID.randomUUID();
		UUID keyAeronave = UUID.randomUUID();
		UUID keyAsiento = UUID.randomUUID();
		int numero = 1;
		String clase = "comercial";
		Double precio = 20.20;
		int disponibilidad = 1;

		AsientoDto asientoDto = new AsientoDto();

		asientoDto.setKeyAeronave(keyAeronave);
		asientoDto.setKeyAsiento(keyAsiento);
		asientoDto.setNumero(numero);
		asientoDto.setClase(clase);
		asientoDto.setPrecio(precio);
		asientoDto.setDisponibilidad(disponibilidad);

		VueloDto vueloDto = new VueloDto();
		vueloDto.setKey(key);

		EditarAsientoCommand command = new EditarAsientoCommand(asientoDto.keyAsiento);

		// TODO cuando haga un cambio el tripulante, tiene que hacer el cambio en mi
		// vuelo registrado

		Assert.assertEquals(key, command.vueloDto.getKey());
		Assert.assertEquals(clase, command.asientoDto.getClase());
		Assert.assertEquals(precio, command.asientoDto.getPrecio());
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
				EditarAsientoCommand.class.getConstructors()[0].canAccess(null));
	}
}
