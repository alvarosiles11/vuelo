package UseCases.Command.Vuelos.Crear;

import org.junit.Assert;
import org.junit.Test;

import Dto.VueloDto;

public class CrearVueloCommandTest {

	@Test
	public void dataValid() {
		VueloDto data = new VueloDto();
		CrearVueloCommand command = new CrearVueloCommand(data);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
				CrearVueloCommand.class.getConstructors()[0].canAccess(null));
	}
}
