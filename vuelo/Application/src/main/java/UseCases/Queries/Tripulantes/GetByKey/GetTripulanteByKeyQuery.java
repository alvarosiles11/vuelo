package UseCases.Queries.Tripulantes.GetByKey;

import Dto.VueloDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class GetTripulanteByKeyQuery implements Request<VueloDto> {

  protected UUID key;

  public GetTripulanteByKeyQuery(UUID key) {
    this.key = key;
  }
}
