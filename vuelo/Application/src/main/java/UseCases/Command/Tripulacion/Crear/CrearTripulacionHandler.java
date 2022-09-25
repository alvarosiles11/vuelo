package UseCases.Command.Tripulacion.Crear;

import Factories.ITripulacionFactory;
import Fourteam.mediator.RequestHandler;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;

public class CrearTripulacionHandler
		implements RequestHandler<CrearTripulacionCommand, Tripulacion> {

	private ITripulacionFactory iTripulacionFactory;
	private ITripulacionRepository iTripulacionRepository;
	private IUnitOfWork iUnitOfWork;

	public CrearTripulacionHandler(
			ITripulacionFactory iTripulanteFactory,
			ITripulacionRepository iTripulanteRepository,
			IUnitOfWork unitOfWor) {
		this.iTripulacionFactory = iTripulanteFactory;
		this.iTripulacionRepository = iTripulanteRepository;
		this.iUnitOfWork = unitOfWor;
	}

	// hilo de ejecucion
	@Override
	public Tripulacion handle(CrearTripulacionCommand request) throws Exception {
		Tripulacion tripulacion = iTripulacionFactory.Create(request.keyTripulacion, request.descripcion, request.estado);
		iTripulacionRepository.Create(tripulacion);
		iUnitOfWork.commit();
		return tripulacion;
	}
}
