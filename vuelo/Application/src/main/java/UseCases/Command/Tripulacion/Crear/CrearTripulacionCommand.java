package UseCases.Command.Tripulacion.Crear;

import java.util.UUID;

import Dto.TripulacionDto;
import Fourteam.mediator.Request;

public class CrearTripulacionCommand implements Request<TripulacionDto> {

	public UUID keyTripulacion;
	public String descripcion;
	public String estado;

	public CrearTripulacionCommand(TripulacionDto tripulacionDto) {
		this.keyTripulacion = tripulacionDto.getKeyTripulacion();
		this.descripcion = tripulacionDto.getDescripcion();
		this.estado = tripulacionDto.getEstado();
	}
}