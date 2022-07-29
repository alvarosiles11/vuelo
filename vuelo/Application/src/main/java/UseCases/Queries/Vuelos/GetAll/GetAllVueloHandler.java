package UseCases.Queries.Vuelos.GetAll;

import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;
import fourteam.mediator.RequestHandler;
import java.util.List;

public class GetAllVueloHandler
  implements RequestHandler<GetAllVueloQuery, List<Vuelo>> {

  private IVueloRepository iVueloRepository;

  public GetAllVueloHandler(IVueloRepository iVueloRepository) {
    this.iVueloRepository = iVueloRepository;
  }

  @Override
  public List<Vuelo> handle(GetAllVueloQuery request) {
    return iVueloRepository.GetAll();
  }
}
