package UseCases.Command.Tripulantes.Eliminar;

import Factories.ITripulanteFactory;
import Model.Vuelos.Tripulante;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class EliminarTripulanteHandler
  implements RequestHandler<EliminarTripulanteCommand, Tripulante> {

  protected ITripulanteFactory iTripulanteFactory;
  protected ITripulanteRepository iTripulanteRepository;
  protected IUnitOfWork unitOfWor;

  public EliminarTripulanteHandler(
    ITripulanteFactory iTripulanteFactory,
    ITripulanteRepository iTripulanteRepository,
    IUnitOfWork unitOfWor
  ) {
    this.iTripulanteFactory = iTripulanteFactory;
    this.iTripulanteRepository = iTripulanteRepository;
    this.unitOfWor = unitOfWor;
  }

  @Override
  public Tripulante handle(EliminarTripulanteCommand request)
    throws HttpException {
    Tripulante tripulante = iTripulanteRepository.FindByKey(
      request.tripulanteDto.getKey()
    );
    if (tripulante == null) {
      throw new HttpException(
        HttpStatus.BAD_REQUEST,
        "Tripulante no encontrada"
      );
    }
    return iTripulanteRepository.Delete(tripulante);
  }
}
