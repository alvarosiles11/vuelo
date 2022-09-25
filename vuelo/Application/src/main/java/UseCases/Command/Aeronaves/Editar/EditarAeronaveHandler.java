package UseCases.Command.Aeronaves.Editar;

import Factories.IAeronaveFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;

public class EditarAeronaveHandler
		implements RequestHandler<EditarAeronaveCommand, Aeronave> {

	private IAeronaveFactory iAeronaveFactory;
	private IAeronaveRepository iAeronaveRepository;
	private IUnitOfWork unitOfWor;

	public EditarAeronaveHandler(
			IAeronaveFactory iAeronaveFactory,
			IAeronaveRepository iAeronaveRepository,
			IUnitOfWork unitOfWor) {
		this.iAeronaveFactory = iAeronaveFactory;
		this.iAeronaveRepository = iAeronaveRepository;
		this.unitOfWor = unitOfWor;
	}

	@Override
	public Aeronave handle(EditarAeronaveCommand request) throws Exception {
		Aeronave aeronave = iAeronaveRepository.FindByKey(request.aeronaveDto.getKeyAeronave());

		if (aeronave == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave no encontrada");
		}
		aeronave.matricula = request.aeronaveDto.getMatricula();
		aeronave.estado = request.aeronaveDto.getEstado();

		iAeronaveRepository.Update(aeronave);
		return aeronave;

	}
}
