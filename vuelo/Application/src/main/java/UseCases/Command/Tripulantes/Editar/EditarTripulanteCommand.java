package UseCases.Command.Tripulantes.Editar;

import Dto.TripulanteDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class EditarTripulanteCommand implements Request<TripulanteDto> {

  public TripulanteDto tripulanteDto;

  public EditarTripulanteCommand(UUID key) {
    tripulanteDto = new TripulanteDto();
    // tripulanteDto.setKey(key);
  }
}
