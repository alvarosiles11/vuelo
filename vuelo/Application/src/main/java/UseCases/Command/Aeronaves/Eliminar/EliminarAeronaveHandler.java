package UseCases.Command.Aeronaves.Eliminar;

import Factories.IAeronaveFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;

public class EliminarAeronaveHandler
		implements RequestHandler<EliminarAeronaveCommand, Aeronave> {

	private IAeronaveFactory iAeronaveFactory;
	private IAeronaveRepository iAeronaveRepository;
	private IUnitOfWork unitOfWor;

	public EliminarAeronaveHandler(
			IAeronaveFactory iAeronaveFactory,
			IAeronaveRepository iAeronaveRepository,
			IUnitOfWork unitOfWor) {
		this.iAeronaveFactory = iAeronaveFactory;
		this.iAeronaveRepository = iAeronaveRepository;
		this.unitOfWor = unitOfWor;
	}

	@Override
	public Aeronave handle(EliminarAeronaveCommand request) throws Exception {
		Aeronave aeronave = iAeronaveRepository.FindByKey(
				request.aeronaveDto.getKeyAeronave());
		if (aeronave == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave no encontrada");
		}
		return iAeronaveRepository.Delete(aeronave);
	}
}
