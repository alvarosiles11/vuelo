package UseCases.Command.Aeronaves.Crear;

import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import Fourteam.mediator.RequestHandler;

public class CrearAeronaveHandler
		implements RequestHandler<CrearAeronaveCommand, Aeronave> {

	private IAeronaveFactory iAeronaveFactory;
	private IAeronaveRepository iAeronaveRepository;
	private IUnitOfWork unitOfWor;

	public CrearAeronaveHandler(
			IAeronaveFactory iAeronaveFactory,
			IAeronaveRepository iAeronaveRepository,
			IUnitOfWork unitOfWor) {
		this.iAeronaveFactory = iAeronaveFactory;
		this.iAeronaveRepository = iAeronaveRepository;
		this.unitOfWor = unitOfWor;
	}

	@Override
	public Aeronave handle(CrearAeronaveCommand arg0) throws Exception {
		Aeronave aeronave = iAeronaveFactory.Create(arg0.key, arg0.matricula, arg0.estado);
		iAeronaveRepository.Create(aeronave);
		unitOfWor.commit();
		return aeronave;
	}
}
