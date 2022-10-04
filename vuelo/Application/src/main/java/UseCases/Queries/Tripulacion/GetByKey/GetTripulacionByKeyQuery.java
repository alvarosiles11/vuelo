package UseCases.Queries.Tripulacion.GetByKey;

import java.util.UUID;

import Dto.TripulacionDto;
import Fourteam.mediator.Request;

public class GetTripulacionByKeyQuery implements Request<TripulacionDto> {

	public UUID key;

	public GetTripulacionByKeyQuery(UUID key) {
		this.key = key;
	}
}
