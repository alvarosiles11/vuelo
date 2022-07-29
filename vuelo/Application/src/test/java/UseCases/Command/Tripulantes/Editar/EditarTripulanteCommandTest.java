package UseCases.Command.Tripulantes.Editar;

import Dto.TripulanteDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EditarTripulanteCommandTest {

  @Test
  public void dataValid() {
    UUID keyVuelo = UUID.randomUUID();
    String keyTripulante = "12345";
    String cargo = "Piloto";

    TripulanteDto tripulanteDto = new TripulanteDto();
    tripulanteDto.setKeyVuelo(keyVuelo);
    tripulanteDto.setKeyTripulante(keyTripulante);
    tripulanteDto.setCargo(cargo);

    EditarTripulanteCommand command = new EditarTripulanteCommand(
      tripulanteDto.getKey()
    );
    command.tripulanteDto = tripulanteDto;

    Assert.assertEquals(keyVuelo, tripulanteDto.getKeyVuelo());
  }
}
