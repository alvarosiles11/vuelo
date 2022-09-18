package UseCases.Queries.Vuelos.GetByKey;

import Dto.AsientoDto;
import Dto.TripulanteDto;
import Dto.VueloDto;
import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;

public class GetVueloByKeyHandler
		implements RequestHandler<GetVueloByKeyQuery, VueloDto> {

	private IVueloRepository iVueloRepository;

	public GetVueloByKeyHandler(IVueloRepository iVueloRepository) {
		this.iVueloRepository = iVueloRepository;
	}

	@Override
	public VueloDto handle(GetVueloByKeyQuery request) throws Exception {
		Vuelo vuelo = iVueloRepository.FindByKey(request.Key);

		if (vuelo == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo no encontrado");
		}

		VueloDto vueloDto = new VueloDto();

		vueloDto.setNroVuelo(vuelo.getNroVuelo());
		vueloDto.setKeyAeronave(vuelo.getKeyAeronave());
		vueloDto.setKeyAeropuertoOrigen(vuelo.getKeyAeropuertoOrigen());
		vueloDto.setKeyAeropuertoDestino(vuelo.getKeyAeropuertoDestino());
		vueloDto.setFechaSalida(vuelo.getFechaSalida());
		vueloDto.setFechaArribe(vuelo.getFechaArribe());

		vueloDto.setKeyTripulacion(vuelo.getKeyTripulacion());

		vuelo.listaAsientos.iterator().forEachRemaining(obj -> {
			vueloDto.listaAsientos.add(new AsientoDto(obj.keyAeronave, obj.numero, obj.clase, obj.precio));
		});

		// retorno lista de tripulante el dto
		// vuelo.listaTripulante.iterator().forEachRemaining(obj -> {
		// 	vueloDto.listaTripulantes.add(new TripulanteDto(obj.));
		// });
		return vueloDto;
	}
}
