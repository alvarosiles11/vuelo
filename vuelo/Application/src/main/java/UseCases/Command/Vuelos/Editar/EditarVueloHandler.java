package UseCases.Command.Vuelos.Editar;

import Factories.IVueloFactory;
import Model.Vuelos.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;

public class EditarVueloHandler
  implements RequestHandler<EditarVueloCommand, Vuelo> {

  protected IVueloFactory iVueloFactory;
  protected IVueloRepository iVueloRepository;
  protected IUnitOfWork unitOfWor;

  public EditarVueloHandler(
    IVueloFactory iVueloFactory,
    IVueloRepository iVueloRepository,
    IUnitOfWork unitOfWor
  ) {
    this.iVueloFactory = iVueloFactory;
    this.iVueloRepository = iVueloRepository;
    this.unitOfWor = unitOfWor;
  }

  @Override
  public Vuelo handle(EditarVueloCommand request) throws Exception {
    Vuelo vuelo = iVueloRepository.FindByKey(request.vueloDto.getKey());
    if (vuelo == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo no encontrada");
    }

    vuelo.setNroVuelo(request.vueloDto.getNroVuelo());
    vuelo.setKeyAeronave(request.vueloDto.getKeyAeronave());
    // vuelo.listaAsientos= request.vueloDto.listaAsientos;

		vuelo.setKeyAeropuertoOrigen(request.vueloDto.getKeyAeropuertoOrigen());
    vuelo.setKeyAeropuertoDestino(request.vueloDto.getKeyAeropuertoDestino());
    vuelo.setFechaSalida(request.vueloDto.getFechaSalida());
    vuelo.setFechaArribe(request.vueloDto.getFechaArribe());
		vuelo.setKeyTripulacion(request.vueloDto.getKeyTripulacion());
    // vuelo.setListaTripulante(request.vueloDto.listaTripulantes);


    iVueloRepository.Update(vuelo);
    return vuelo;
  }
}
