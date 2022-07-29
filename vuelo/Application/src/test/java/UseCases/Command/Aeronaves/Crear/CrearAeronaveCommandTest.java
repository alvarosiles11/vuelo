package UseCases.Command.Aeronaves.Crear;

import Dto.AeronaveDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class CrearAeronaveCommandTest {

  @Test
  public void dataValid() {
    UUID keyAeronave = UUID.randomUUID();
    String matricula = "xyz-1990";

    AeronaveDto aeronave = new AeronaveDto();

    aeronave.setKeyAeronave(keyAeronave);
    aeronave.setMatricula(matricula);

    CrearAeronaveCommand command = new CrearAeronaveCommand(aeronave);
    Assert.assertEquals(matricula, command.matricula);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(
      CrearAeronaveCommand.class.getConstructors()[0].canAccess(null)
    );
  }
}
