package UseCases.Command.Tripulacion.Eliminar;

import java.util.UUID;

import Dto.TripulacionDto;
import Fourteam.mediator.Request;

public class EliminarTripulacionCommand implements Request<TripulacionDto> {

	public TripulacionDto tripulacionDto;

	public EliminarTripulacionCommand(UUID key) {
		this.tripulacionDto = new TripulacionDto();
		this.tripulacionDto.setKeyTripulacion(key);
	}
}
