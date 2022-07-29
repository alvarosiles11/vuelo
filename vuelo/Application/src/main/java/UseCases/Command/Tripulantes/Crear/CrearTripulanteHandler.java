package UseCases.Command.Tripulantes.Crear;

import Factories.ITripulanteFactory;
import Model.Vuelos.Tripulante;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;

public class CrearTripulanteHandler
  implements RequestHandler<CrearTripulanteCommand, Tripulante> {

  private ITripulanteFactory _ITripulanteFactory;
  private ITripulanteRepository _ITripulanteRepository;
  private IUnitOfWork _unitOfWor;

  public CrearTripulanteHandler(
    ITripulanteFactory iTripulanteFactory,
    ITripulanteRepository iTripulanteRepository,
    IUnitOfWork unitOfWor
  ) {
    this._ITripulanteFactory = iTripulanteFactory;
    this._ITripulanteRepository = iTripulanteRepository;
    this._unitOfWor = unitOfWor;
  }

  // hilo de ejecucion
  @Override
  public Tripulante handle(CrearTripulanteCommand arg0) throws HttpException {
    Tripulante tripulante = _ITripulanteFactory.Create(
      arg0.keyVuelo,
      arg0.keyTripulante,
      arg0.cargo
    );
    _ITripulanteRepository.Create(tripulante);
    _unitOfWor.commit();
    return tripulante;
  }
}
