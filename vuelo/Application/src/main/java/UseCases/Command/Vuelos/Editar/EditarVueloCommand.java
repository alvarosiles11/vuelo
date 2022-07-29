package UseCases.Command.Vuelos.Editar;

import Dto.VueloDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EditarVueloCommand implements Request<VueloDto> {

  public VueloDto vueloDto;

  public EditarVueloCommand(UUID key) {
    this.vueloDto = new VueloDto();
    this.vueloDto.setKey(key);
  }
}
