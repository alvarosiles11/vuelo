package UseCases.Command.Tripulantes.Editar;

import Factories.ITripulanteFactory;
import Model.Vuelos.Tripulante;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class EditarTripulanteHandler
  implements RequestHandler<EditarTripulanteCommand, Tripulante> {

  protected ITripulanteFactory iTripulanteFactory;
  protected ITripulanteRepository iTripulanteRepository;
  protected IUnitOfWork unitOfWor;

  public EditarTripulanteHandler(
    ITripulanteFactory iTripulanteFactory,
    ITripulanteRepository iTripulanteRepository,
    IUnitOfWork unitOfWor
  ) {
    this.iTripulanteFactory = iTripulanteFactory;
    this.iTripulanteRepository = iTripulanteRepository;
    this.unitOfWor = unitOfWor;
  }

  @Override
  public Tripulante handle(EditarTripulanteCommand request)
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
    tripulante.key = request.tripulanteDto.getKey();

    tripulante.setKeyVuelo(request.tripulanteDto.getKeyVuelo());
    tripulante.setKeyTripulante(request.tripulanteDto.getKeyTripulante());
    tripulante.setCargo(request.tripulanteDto.getCargo());
    iTripulanteRepository.Update(tripulante);
    return tripulante;
  }
}
