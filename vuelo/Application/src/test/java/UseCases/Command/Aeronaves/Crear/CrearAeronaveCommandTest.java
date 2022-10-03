package UseCases.Command.Aeronaves.Crear;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.AeronaveDto;

public class CrearAeronaveCommandTest {

	@Test
	public void dataValid() {

		final UUID keyAeronave = UUID.randomUUID();
		final String matricula = "xyz-1990";
		final String estado = "0";

		AeronaveDto aeronaveDto = new AeronaveDto();

		aeronaveDto.setKeyAeronave(keyAeronave);
		aeronaveDto.setMatricula(matricula);
		aeronaveDto.setEstado(estado);

		CrearAeronaveCommand command = new CrearAeronaveCommand(aeronaveDto);

		Assert.assertEquals(matricula, command.matricula);
		Assert.assertEquals(keyAeronave, command.key);
		Assert.assertEquals(matricula, command.matricula);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
				CrearAeronaveCommand.class.getConstructors()[0].canAccess(null));
	}
}
