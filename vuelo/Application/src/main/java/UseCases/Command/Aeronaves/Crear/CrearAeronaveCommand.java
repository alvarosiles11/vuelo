package UseCases.Command.Aeronaves.Crear;

import java.util.UUID;

import Dto.AeronaveDto;
import Fourteam.mediator.Request;

public class CrearAeronaveCommand implements Request<AeronaveDto> {

	public UUID key;
	public String matricula;
	public String estado;

	public CrearAeronaveCommand(AeronaveDto aeronaveDto) {
		this.key = aeronaveDto.getKeyAeronave();
		this.matricula = aeronaveDto.getMatricula();
		this.estado = aeronaveDto.getEstado();

	}
}