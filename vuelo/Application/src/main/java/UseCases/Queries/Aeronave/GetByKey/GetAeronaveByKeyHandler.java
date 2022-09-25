package UseCases.Queries.Aeronave.GetByKey;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;

public class GetAeronaveByKeyHandler implements RequestHandler<GetAeronaveByKeyQuery, AeronaveDto> {

	private IAeronaveRepository iAeronaveRepository;

	public GetAeronaveByKeyHandler(
			IAeronaveRepository iAeronaveRepository) {
		this.iAeronaveRepository = iAeronaveRepository;
	}

	@Override
	public AeronaveDto handle(GetAeronaveByKeyQuery request) throws Exception {
		Aeronave aeronave = iAeronaveRepository.FindByKey(request.key);
		if (aeronave == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave no encontrada");
		}
		AeronaveDto aeronaveDto = new AeronaveDto();
		aeronaveDto.keyAeronave = aeronave.key;
		aeronaveDto.matricula = aeronave.matricula;
		aeronaveDto.estado = aeronave.estado;

		aeronave.asientos
				.iterator()
				.forEachRemaining(obj -> {
					aeronaveDto.listaAsientos.add(new AsientoDto(obj.keyAeronave, obj.numero, obj.clase, obj.precio));
				});
		return aeronaveDto;
	}
}
