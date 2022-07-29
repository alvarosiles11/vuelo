package UseCases.Queries.Tripulantes.GetAll;

import Model.Vuelos.Tripulante;
import Repositories.ITripulanteRepository;
import fourteam.mediator.RequestHandler;
import java.util.List;

public class GetAllTripulanteHandler
  implements RequestHandler<GetAllTripulanteQuery, List<Tripulante>> {

  private ITripulanteRepository iTripulanteRepository;

  public GetAllTripulanteHandler(ITripulanteRepository iTripulanteRepository) {
    this.iTripulanteRepository = iTripulanteRepository;
  }

  @Override
  public List<Tripulante> handle(GetAllTripulanteQuery request) {
    return iTripulanteRepository.GetAll();
  }
}
