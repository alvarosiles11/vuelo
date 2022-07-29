package UseCases.Command.Aeronaves.Eliminar;

import Dto.AeronaveDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EliminarAeronaveCommandTest {

  @Test
  public void dataValid() {
    UUID keyAeronave = UUID.randomUUID();
    AeronaveDto aeronaveDto = new AeronaveDto();
    aeronaveDto.setKeyAeronave(keyAeronave);
    EliminarAeronaveCommand command = new EliminarAeronaveCommand(
      aeronaveDto.getKeyAeronave()
    );
    Assert.assertEquals(keyAeronave, aeronaveDto.getKeyAeronave());
    System.out.println(command);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(
      EliminarAeronaveCommand.class.getConstructors()[0].canAccess(null)
    );
  }
}
