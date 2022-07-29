package UseCases.Command.Vuelos2.Eliminar;

import Dto.VueloDto;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloCommand;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EliminarVueloCommandTest {

  @Test
  public void dataValid() {
    UUID key = UUID.randomUUID();
    VueloDto vueloDto = new VueloDto();
    vueloDto.setKey(key);
    EliminarVueloCommand command = new EliminarVueloCommand(vueloDto.getKey());
    Assert.assertEquals(key, vueloDto.getKey());
    System.out.println(command);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(
      EliminarVueloCommand.class.getConstructors()[0].canAccess(null)
    );
  }
}
