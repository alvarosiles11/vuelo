package UseCases.Command.Tripulacion.Editar;

import java.util.UUID;

import Dto.TripulacionDto;
import Fourteam.mediator.Request;

public class EditarTripulacionCommand implements Request<TripulacionDto> {

	public TripulacionDto tripulacionDto;

	public EditarTripulacionCommand(UUID key) {
		this.tripulacionDto = new TripulacionDto();
		this.tripulacionDto.setKeyTripulacion(key);
	}
}
