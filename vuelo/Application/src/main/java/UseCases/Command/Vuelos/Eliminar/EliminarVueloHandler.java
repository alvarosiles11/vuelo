package UseCases.Command.Vuelos.Eliminar;

import Factories.IVueloFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Vuelos.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class EliminarVueloHandler
		implements RequestHandler<EliminarVueloCommand, Vuelo> {

	private IVueloFactory iVueloFactory;
	private IVueloRepository iVueloRepository;
	private IUnitOfWork unitOfWor;

	public EliminarVueloHandler(
			IVueloFactory iVueloFactory,
			IVueloRepository iVueloRepository,
			IUnitOfWork unitOfWor) {
		this.iVueloFactory = iVueloFactory;
		this.iVueloRepository = iVueloRepository;
		this.unitOfWor = unitOfWor;
	}

	@Override
	public Vuelo handle(EliminarVueloCommand request) throws Exception {
		Vuelo vuelo = iVueloRepository.FindByKey(request.vueloDto.getKey());
		if (vuelo == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo no encontrada");
		}

		return iVueloRepository.Delete(vuelo);
	}
}
