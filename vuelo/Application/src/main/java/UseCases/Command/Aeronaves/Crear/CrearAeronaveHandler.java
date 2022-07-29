package UseCases.Command.Aeronaves.Crear;

import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;

public class CrearAeronaveHandler
  implements RequestHandler<CrearAeronaveCommand, Aeronave> {

  protected IAeronaveFactory iAeronaveFactory;
  protected IAeronaveRepository iAeronaveRepository;
  protected IUnitOfWork unitOfWor;

  public CrearAeronaveHandler(
    IAeronaveFactory iAeronaveFactory,
    IAeronaveRepository iAeronaveRepository,
    IUnitOfWork unitOfWor
  ) {
    this.iAeronaveFactory = iAeronaveFactory;
    this.iAeronaveRepository = iAeronaveRepository;
    this.unitOfWor = unitOfWor;
  }

  @Override
  public Aeronave handle(CrearAeronaveCommand arg0) throws HttpException {
    Aeronave aeronave = iAeronaveFactory.Create(arg0.matricula);
    iAeronaveRepository.Create(aeronave);
    unitOfWor.commit();
    return aeronave;
  }
}
