package UseCases.Command.Vuelos.Eliminar;

import Dto.VueloDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EliminarVueloCommand implements Request<VueloDto> {

  VueloDto vueloDto;

  public EliminarVueloCommand(UUID key) {
    this.vueloDto = new VueloDto();
    this.vueloDto.setKey(key);
  }
}
