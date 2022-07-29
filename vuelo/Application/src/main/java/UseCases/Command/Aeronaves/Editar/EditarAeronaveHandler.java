package UseCases.Command.Aeronaves.Editar;

import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class EditarAeronaveHandler
  implements RequestHandler<EditarAeronaveCommand, Aeronave> {

  protected IAeronaveFactory iAeronaveFactory;
  protected IAeronaveRepository iAeronaveRepository;
  protected IUnitOfWork unitOfWor;

  public EditarAeronaveHandler(
    IAeronaveFactory iAeronaveFactory,
    IAeronaveRepository iAeronaveRepository,
    IUnitOfWork unitOfWor
  ) {
    this.iAeronaveFactory = iAeronaveFactory;
    this.iAeronaveRepository = iAeronaveRepository;
    this.unitOfWor = unitOfWor;
  }

  @Override
  public Aeronave handle(EditarAeronaveCommand request) throws HttpException {
    Aeronave aeronave = iAeronaveRepository.FindByKey(
      request.aeronaveDto.getKeyAeronave()
    );
    if (aeronave == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave no encontrada");
    }
    aeronave.matricula = request.aeronaveDto.getMatricula();
    iAeronaveRepository.Update(aeronave);
    return aeronave;
  }
}
