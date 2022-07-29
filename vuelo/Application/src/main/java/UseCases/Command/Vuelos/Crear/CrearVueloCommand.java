package UseCases.Command.Vuelos.Crear;

import Dto.VueloDto;
import fourteam.mediator.Request;
import java.util.Date;

public class CrearVueloCommand implements Request<VueloDto> {

  public String nroVuelo;
  public String keyAeronave;
  public String keyAeropuertoOrigen;
  public String keyAeropuertoDestino;
  public Date fechaSalida;
  public Date fechaArribe;

  public CrearVueloCommand(VueloDto vueloDto) {
    this.nroVuelo = vueloDto.getNroVuelo();
    this.keyAeronave = vueloDto.getKeyAeronave();
    this.keyAeropuertoOrigen = vueloDto.getKeyAeropuertoOrigen();
    this.keyAeropuertoDestino = vueloDto.getKeyAeropuertoDestino();
    this.fechaSalida = vueloDto.getfechaSalida();
    this.fechaArribe = vueloDto.getfechaArribe();
  }
}
