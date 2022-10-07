package UseCases.Command.Vuelos.Editar;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Fourteam.mediator.RequestHandler;
import Model.Vuelos.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class EditarVueloHandler
		implements RequestHandler<EditarVueloCommand, VueloDto> {

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
	public VueloDto handle(EditarVueloCommand request) throws Exception {

		Vuelo vuelo = iVueloRepository.FindByKey(request.vueloDto.key);
		if (vuelo == null) {
			System.out.println("mierda");
			// throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo no encontrado");
		}

		vuelo.setNroVuelo(request.vueloDto.getNroVuelo());
		vuelo.setKeyAeronave(request.vueloDto.getKeyAeronave());
		vuelo.setOrigen(request.vueloDto.getOrigen());
		vuelo.setDestino(request.vueloDto.getDestino());
		vuelo.setFechaSalida(request.vueloDto.getFechaSalida());
		vuelo.setFechaArribe(request.vueloDto.getFechaArribe());
		vuelo.setKeyTripulacion(request.vueloDto.getKeyTripulacion());
		iVueloRepository.Update(vuelo);

		return new VueloDto(vuelo.nroVuelo, vuelo.keyAeronave, vuelo.origen, vuelo.destino, vuelo.fechaSalida,
				vuelo.fechaArribe, vuelo.keyTripulacion);
	}
}
