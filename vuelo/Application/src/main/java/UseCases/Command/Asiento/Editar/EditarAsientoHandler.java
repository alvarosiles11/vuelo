package UseCases.Command.Asiento.Editar;

import java.util.ArrayList;
import java.util.List;

import Dto.AsientoDto;
import Factories.IVueloFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Model.Vuelos.Vuelo;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class EditarAsientoHandler
		implements RequestHandler<EditarAsientoCommand, List<AsientoDto>> {

	private IVueloFactory iVueloFactory;
	private IVueloRepository iVueloRepository;
	private IAeronaveRepository iAeronaveRepository;
	private IUnitOfWork unitOfWor;

	public EditarAsientoHandler(
			IVueloFactory iVueloFactory,
			IVueloRepository iVueloRepository,
			IUnitOfWork unitOfWor) {
		this.iVueloFactory = iVueloFactory;
		this.iVueloRepository = iVueloRepository;
		this.unitOfWor = unitOfWor;
	}

	@Override
	public List<AsientoDto> handle(EditarAsientoCommand request) throws Exception {

		// Vuelo vuelo= iVueloRepository.FindByKey(object.KeyVuelo);
		Vuelo vuelo = iVueloRepository.FindByKey(request.vueloDto.key);
		if (vuelo == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo no encontrada");
		}

		Aeronave aeronave = iAeronaveRepository.FindByKey(request.vueloDto.keyAeronave);
		if (aeronave == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "aeronave no encontrada");
		}

		List<AsientoDto> asientos = new ArrayList<>();
		for (Asiento asiento : aeronave.asientos) {
			asientos.add(new AsientoDto(asiento.keyAeronave, asiento.numero, asiento.clase, 500.00));
		}
		return asientos;
	}
}
