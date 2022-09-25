package UseCases.Command.Aeronaves.Editar;

import Dto.AeronaveDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class EditarAeronaveCommand implements Request<AeronaveDto> {

  public AeronaveDto aeronaveDto;

  public EditarAeronaveCommand(UUID key) {
    this.aeronaveDto = new AeronaveDto();
    this.aeronaveDto.setKeyAeronave(key);
  }
}
