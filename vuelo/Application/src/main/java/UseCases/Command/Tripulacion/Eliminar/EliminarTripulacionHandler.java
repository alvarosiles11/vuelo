package UseCases.Command.Tripulacion.Eliminar;

import Factories.ITripulacionFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;

public class EliminarTripulacionHandler implements RequestHandler<EliminarTripulacionCommand, Tripulacion> {

	private ITripulacionFactory iTripulacionFactory;
	private ITripulacionRepository iTripulacionRepository;
	private IUnitOfWork iUnitOfWork;

	public EliminarTripulacionHandler(ITripulacionFactory iTripulacionFactory,
			ITripulacionRepository iTripulacionRepository, IUnitOfWork iUnitOfWork) {
		this.iTripulacionFactory = iTripulacionFactory;
		this.iTripulacionRepository = iTripulacionRepository;
		this.iUnitOfWork = iUnitOfWork;
	}

	@Override
	public Tripulacion handle(EliminarTripulacionCommand request) throws Exception {
		Tripulacion tripulacion = iTripulacionRepository.FindByKey(request.tripulacionDto.getKeyTripulacion());

		if (tripulacion == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "tripulacion no encontrada");
		}
		return iTripulacionRepository.Delete(tripulacion);
	}
}