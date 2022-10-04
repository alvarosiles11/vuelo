package UseCases.Command.Vuelos.Crear;

import java.util.Date;
import java.util.UUID;

import Dto.VueloDto;
import Fourteam.mediator.Request;

public class CrearVueloCommand implements Request<VueloDto> {

	public String nroVuelo;
	public String origen;
	public String destino;
	public Date fechaSalida;
	public Date fechaArribe;
	public UUID keyAeronave;
	public UUID keyTripulacion;

	public CrearVueloCommand(VueloDto vueloDto) {
		this.nroVuelo = vueloDto.getNroVuelo();
		this.keyAeronave = vueloDto.getKeyAeronave();
		this.origen = vueloDto.getOrigen();
		this.destino= vueloDto.getDestino();
		this.fechaSalida = vueloDto.getFechaSalida();
		this.fechaArribe = vueloDto.getFechaArribe();
		this.keyTripulacion = vueloDto.getKeyTripulacion();
	}
}
