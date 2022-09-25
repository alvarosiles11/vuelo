package UseCases.Queries.Tripulacion.GetByKey;

import Dto.TripulacionDto;
import Dto.TripulanteDto;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;

public class GetTripulacionByKeyHandler
		implements RequestHandler<GetTripulacionByKeyQuery, TripulacionDto> {

	private ITripulacionRepository iTripulanteRepository;

	public GetTripulacionByKeyHandler(
			ITripulacionRepository iTripulanteRepository) {
		this.iTripulanteRepository = iTripulanteRepository;
	}

	@Override
	public TripulacionDto handle(GetTripulacionByKeyQuery request) throws Exception {
		Tripulacion tripulacion = iTripulanteRepository.FindByKey(request.key);

		if (tripulacion == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "tripulacion no encontrada");
		}
		TripulacionDto tripulacionDto = new TripulacionDto();

		tripulacionDto.setKeyTripulacion(tripulacion.getKey());
		tripulacionDto.setDescripcion(tripulacion.getDescripcion());
		tripulacionDto.setEstado(tripulacion.getEstado());

		tripulacion.tripulantes
				.iterator()
				.forEachRemaining(obj -> {
					tripulacionDto.tripulantes
							.add(new TripulanteDto(obj.keyTripulacion, obj.key, obj.nombre, obj.apellido, obj.cargo, obj.estado));
				});
		return tripulacionDto;
	}
}