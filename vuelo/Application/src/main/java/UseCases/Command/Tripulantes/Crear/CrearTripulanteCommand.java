package UseCases.Command.Tripulantes.Crear;

import Dto.TripulanteDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class CrearTripulanteCommand implements Request<TripulanteDto> {

  protected UUID keyVuelo; // vuelo
  protected String keyTripulante; // tripulante
  protected String cargo; // cargo

  public CrearTripulanteCommand(TripulanteDto tripulanteDto) {
    this.keyVuelo = tripulanteDto.getKeyVuelo();
    this.keyTripulante = tripulanteDto.getKeyTripulante();
    this.cargo = tripulanteDto.getCargo();
  }
}
