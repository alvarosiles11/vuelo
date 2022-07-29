package UseCases.Command.Aeronaves.Editar;

import Dto.AeronaveDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EditarAeronaveCommand implements Request<AeronaveDto> {

  protected AeronaveDto aeronaveDto;

  public EditarAeronaveCommand(UUID keyAeronave) {
    this.aeronaveDto = new AeronaveDto();
    this.aeronaveDto.setKeyAeronave(keyAeronave);
  }
}
