package UseCases.Command.Tripulacion.Editar;

import Factories.ITripulacionFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;

public class EditarTripulacionHandler
		implements RequestHandler<EditarTripulacionCommand, Tripulacion> {

	private ITripulacionFactory iTripulacionFactory;
	private ITripulacionRepository iTripulacionRepository;
	private IUnitOfWork iUnitOfWork;

	public EditarTripulacionHandler(ITripulacionFactory iTripulacionFactory,
			ITripulacionRepository iTripulacionRepository, IUnitOfWork iUnitOfWork) {
		this.iTripulacionFactory = iTripulacionFactory;
		this.iTripulacionRepository = iTripulacionRepository;
		this.iUnitOfWork = iUnitOfWork;
	}

	@Override
	public Tripulacion handle(EditarTripulacionCommand request) throws Exception {
		Tripulacion tripulacion = iTripulacionRepository.FindByKey(request.tripulacionDto.getKeyTripulacion());
		if (tripulacion == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "tripulacion no encontrada");
		}
		tripulacion.descripcion = request.tripulacionDto.getDescripcion();
		tripulacion.estado = request.tripulacionDto.getEstado();

		iTripulacionRepository.Update(tripulacion);
		return tripulacion;
	}
}