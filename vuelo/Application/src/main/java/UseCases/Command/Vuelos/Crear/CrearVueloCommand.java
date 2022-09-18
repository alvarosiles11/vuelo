package UseCases.Command.Vuelos.Crear;

import Dto.AsientoDto;
import Dto.TripulanteDto;
import Dto.VueloDto;
import Fourteam.mediator.Request;
import java.util.Date;
import java.util.List;

public class CrearVueloCommand implements Request<VueloDto> {

  public String nroVuelo;
  public String keyAeronave;
	public List<AsientoDto> listaAsientos;

  public String keyAeropuertoOrigen;
  public String keyAeropuertoDestino;
  public Date fechaSalida;
  public Date fechaArribe;

	public String keyTripulacion;
	public List<TripulanteDto> listaTripulantes;

  public CrearVueloCommand(VueloDto vueloDto) {
    this.nroVuelo = vueloDto.getNroVuelo();
    this.keyAeronave = vueloDto.getKeyAeronave();
    this.listaAsientos = vueloDto.getListaAsientos();
    this.keyAeropuertoOrigen = vueloDto.getKeyAeropuertoOrigen();
    this.keyAeropuertoDestino = vueloDto.getKeyAeropuertoDestino();
    this.fechaSalida = vueloDto.getFechaSalida();
    this.fechaArribe = vueloDto.getFechaArribe();

    this.keyTripulacion = vueloDto.getKeyTripulacion();
    this.listaTripulantes = vueloDto.getListaTripulantes();

  }
}
