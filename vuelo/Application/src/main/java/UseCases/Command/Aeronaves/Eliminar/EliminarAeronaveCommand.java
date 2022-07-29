package UseCases.Command.Aeronaves.Eliminar;

import Dto.AeronaveDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EliminarAeronaveCommand implements Request<AeronaveDto> {

  protected AeronaveDto aeronaveDto;

  public EliminarAeronaveCommand(UUID keyAeronave) {
    aeronaveDto = new AeronaveDto();
    aeronaveDto.setKeyAeronave(keyAeronave);
  }
}
