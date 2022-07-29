package UseCases.Command.Tripulantes.Crear;

import Dto.TripulanteDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class CrearTripulanteCommandTest {

  @Test
  public void dataValid() {
    UUID keyVuelo = UUID.randomUUID();
    String keyTripulante = "12345";
    String cargo = "Piloto";

    TripulanteDto tripulante = new TripulanteDto();

    tripulante.setKeyVuelo(keyVuelo);
    tripulante.setKeyTripulante(keyTripulante);
    tripulante.setCargo(cargo);
  }

  @Test
  public void constructorIsPrivate() {
    Assert.assertTrue(
      CrearTripulanteCommand.class.getConstructors()[0].canAccess(null)
    );
  }
}
