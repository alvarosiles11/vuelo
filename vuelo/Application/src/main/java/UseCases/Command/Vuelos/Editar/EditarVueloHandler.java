package UseCases.Command.Vuelos.Editar;

import Factories.IVueloFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Vuelos.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class EditarVueloHandler
		implements RequestHandler<EditarVueloCommand, Vuelo> {

	private IVueloFactory iVueloFactory;
	private IVueloRepository iVueloRepository;
	private IUnitOfWork unitOfWor;

	public EditarVueloHandler(
			IVueloFactory iVueloFactory,
			IVueloRepository iVueloRepository,
			IUnitOfWork unitOfWor) {
		this.iVueloFactory = iVueloFactory;
		this.iVueloRepository = iVueloRepository;
		this.unitOfWor = unitOfWor;
	}

	@Override
	public Vuelo handle(EditarVueloCommand request) throws Exception {
		Vuelo vuelo = iVueloRepository.FindByKey(request.vueloDto.getKey());
		if (vuelo == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo no encontrada");
		}

		vuelo.setNroVuelo(request.vueloDto.getNroVuelo());
		vuelo.setKeyAeronave(request.vueloDto.getKeyAeronave());
		vuelo.setOrigen(request.vueloDto.getOrigen());
		vuelo.setDestino(request.vueloDto.getDestino());
		vuelo.setFechaSalida(request.vueloDto.getFechaSalida());
		vuelo.setFechaArribe(request.vueloDto.getFechaArribe());
		vuelo.setKeyTripulacion(request.vueloDto.getKeyTripulacion());
		iVueloRepository.Update(vuelo);

		// consultar a los otros si les muestra el editar
		// VueloDto vueloDto = new VueloDto();
		// vueloDto.setKey(vuelo.getKey());
		// vueloDto.setNroVuelo(vuelo.getNroVuelo());
		// vueloDto.setKeyAeronave(vuelo.getKeyAeronave());
		// vueloDto.setOrigen(vuelo.getOrigen());
		// vueloDto.setDestino(vuelo.getDestino());
		// vueloDto.setFechaSalida(vuelo.getFechaSalida());
		// vueloDto.setFechaArribe(vuelo.getFechaArribe());
		// vueloDto.setKeyTripulacion(vuelo.getKeyTripulacion());
		return vuelo;
	}
}
