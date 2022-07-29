package UseCases.Queries.Vuelos.GetByKey;

import Dto.TripulanteDto;
import Dto.VueloDto;
import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class GetVueloByKeyHandler
  implements RequestHandler<GetVueloByKeyQuery, VueloDto> {

  private IVueloRepository iVueloRepository;

  public GetVueloByKeyHandler(IVueloRepository iVueloRepository) {
    this.iVueloRepository = iVueloRepository;
  }

  @Override
  public VueloDto handle(GetVueloByKeyQuery request) throws HttpException {
    Vuelo vuelo = iVueloRepository.FindByKey(request.Key);

    if (vuelo == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo no encontrado");
    }

    VueloDto vueloDto = new VueloDto();

    vueloDto.setNroVuelo(vuelo.getNroVuelo());
    vueloDto.setKeyAeronave(vuelo.getKeyAeronave());
    vueloDto.setKeyAeropuertoOrigen(vuelo.getKeyAeropuertoOrigen());
    vueloDto.setKeyAeropuertoDestino(vuelo.getKeyAeropuertoDestino());
    vueloDto.setfechaSalida(vuelo.getfechaSalida());
    vueloDto.setfechaArribe(vuelo.getfechaArribe());

    // retorno lista de tripulante el dto
    vuelo.listaTripulante
      .iterator()
      .forEachRemaining(obj -> {
        vueloDto.listaTripulante.add(
          new TripulanteDto(
            obj.getKeyVuelo(),
            obj.getKeyTripulante(),
            obj.getCargo()
          )
        );
      });
    return vueloDto;
  }
}
