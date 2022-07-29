package UseCases.Queries.Tripulantes.GetByKey;

import Dto.TripulanteDto;
import Model.Vuelos.Tripulante;
import Repositories.ITripulanteRepository;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class GetTripulanteByKeyHandler
  implements RequestHandler<GetTripulanteByKeyQuery, TripulanteDto> {

  protected ITripulanteRepository iTripulanteRepository;

  public GetTripulanteByKeyHandler(
    ITripulanteRepository iTripulanteRepository
  ) {
    this.iTripulanteRepository = iTripulanteRepository;
  }

  @Override
  public TripulanteDto handle(GetTripulanteByKeyQuery request)
    throws HttpException {
    Tripulante tripulante = iTripulanteRepository.FindByKey(request.key);
    if (tripulante == null) {
      throw new HttpException(
        HttpStatus.BAD_REQUEST,
        "tripulante no encontrado"
      );
    }
    TripulanteDto tripulanteDto = new TripulanteDto();

    tripulanteDto.setKey(tripulante.getKey());
    tripulanteDto.setKeyVuelo(tripulante.getKeyVuelo());
    tripulanteDto.setKeyTripulante(tripulante.getKeyTripulante());
    tripulanteDto.setCargo(tripulante.getCargo());

    return tripulanteDto;
  }
}
