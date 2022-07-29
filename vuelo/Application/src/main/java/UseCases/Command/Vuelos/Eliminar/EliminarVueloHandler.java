package UseCases.Command.Vuelos.Eliminar;

import Factories.IVueloFactory;
import Model.Vuelos.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class EliminarVueloHandler
  implements RequestHandler<EliminarVueloCommand, Vuelo> {

  protected IVueloFactory iVueloFactory;
  protected IVueloRepository iVueloRepository;
  protected IUnitOfWork unitOfWor;

  public EliminarVueloHandler(
    IVueloFactory iVueloFactory,
    IVueloRepository iVueloRepository,
    IUnitOfWork unitOfWor
  ) {
    this.iVueloFactory = iVueloFactory;
    this.iVueloRepository = iVueloRepository;
    this.unitOfWor = unitOfWor;
  }

  @Override
  public Vuelo handle(EliminarVueloCommand request) throws HttpException {
    Vuelo vuelo = iVueloRepository.FindByKey(request.vueloDto.getKey());
    if (vuelo == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo no encontrada");
    }
    return iVueloRepository.Delete(vuelo);
  }
}
