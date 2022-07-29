package UseCases.Command.Tripulantes.Eliminar;

import Dto.TripulanteDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EliminarTripulanteCommand implements Request<TripulanteDto> {

  TripulanteDto tripulanteDto;

  public EliminarTripulanteCommand(UUID key) {
    this.tripulanteDto = new TripulanteDto();
    this.tripulanteDto.setKey(key);
  }
}
