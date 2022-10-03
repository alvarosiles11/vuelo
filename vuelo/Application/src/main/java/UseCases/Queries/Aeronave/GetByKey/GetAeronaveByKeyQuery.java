package UseCases.Queries.Aeronave.GetByKey;

import java.util.UUID;

import Dto.AeronaveDto;
import Fourteam.mediator.Request;

public class GetAeronaveByKeyQuery implements Request<AeronaveDto> {

	public UUID key;

	public GetAeronaveByKeyQuery(UUID key) {
		this.key = key;
	}
}
