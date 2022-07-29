package UseCases.Command.Tripulantes.Eliminar;

import Dto.TripulanteDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EliminarTripulanteCommandTest {

  @Test
  public void dataValid() {
    UUID keyVuelo = UUID.randomUUID();

    TripulanteDto tripulanteDto = new TripulanteDto();
    tripulanteDto.setKeyVuelo(keyVuelo);

    EliminarTripulanteCommand command = new EliminarTripulanteCommand(
      tripulanteDto.getKeyVuelo()
    );
    Assert.assertEquals(keyVuelo, tripulanteDto.getKeyVuelo());
    System.out.println(command);
  }
}
